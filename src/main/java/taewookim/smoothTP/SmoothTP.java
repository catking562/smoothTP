package taewookim.smoothTP;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import taewookim.smoothTP.event.TeleportEvent;
import taewookim.smoothTP.manager.ansyupdater.AsyUpdaterManager;
import taewookim.smoothTP.manager.teleport.TeleportData;
import taewookim.smoothTP.manager.teleport.TeleportManager;

public final class SmoothTP extends JavaPlugin {

    /*-----DontTouchBottom-----*/
    private static boolean isUpdating = false;
    private void startUpdate() {
        if(isUpdating) {
            return;
        }
        isUpdating = true;
        BukkitRunnable brunasy = new BukkitRunnable() {
            @Override
            public void run() {
                AsyUpdaterManager.update();
            }
        };brunasy.runTaskTimerAsynchronously(this, 0, 0);
        BukkitRunnable brun = new BukkitRunnable() {
            @Override
            public void run() {
                TeleportManager.update();
            }
        };brun.runTaskTimer(this, 0, 0);
    }

    private boolean isResist = false;
    private void registEvent() {
        if(isResist) {
            return;
        }
        isResist = true;
        Bukkit.getPluginManager().registerEvents(new TeleportEvent(), this);
    }

    @Override
    public void onEnable() {
        startUpdate();
        registEvent();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /*-----CanCustomBottom-----*/

    /*-----CanUseBottom---*/

}
