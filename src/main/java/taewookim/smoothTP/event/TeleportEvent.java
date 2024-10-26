package taewookim.smoothTP.event;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import taewookim.smoothTP.manager.ansyupdater.AsyUpdaterManager;
import taewookim.smoothTP.manager.check.CheckTeleporting;
import taewookim.smoothTP.manager.teleport.TeleportManager;
import taewookim.smoothTP.smoothType.AsyUpdater;
import taewookim.smoothTP.smoothType.SmoothUpdater;

public class TeleportEvent implements Listener {

    public boolean sendTeleport(Entity entity, Location from, Location to) {
        if(CheckTeleporting.isTeleporting(entity)) {
            return false;
        }
        AsyUpdaterManager.addUpdate(new SmoothUpdater(20, entity, from, to));
        return true;
    }

    @EventHandler
    public void teleport(EntityTeleportEvent e) {
        e.setCancelled(sendTeleport(e.getEntity(), e.getFrom(), e.getTo()));
    }

    @EventHandler
    public void teleportPlayer(PlayerTeleportEvent e) {
        e.setCancelled(sendTeleport(e.getPlayer(), e.getFrom(), e.getTo()));
    }

}
