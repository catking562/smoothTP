package taewookim.smoothTP.smoothType;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import taewookim.smoothTP.manager.ansyupdater.AsyUpdaterManager;
import taewookim.smoothTP.manager.teleport.TeleportManager;

public class SmoothUpdater extends AsyUpdater {

    public SmoothUpdater(int maxTick, Entity entity, Location from, Location to) {
        super(maxTick, entity, from, to);
    }

    private Vector v;

    @Override
    public void created() {

    }

    @Override
    public void firstUpdate() {
        v = to.toVector().add(from.toVector().multiply(-1)).multiply(1d/((double)maxTick));
        update();
    }

    @Override
    public void update() {
        from.add(v);
        TeleportManager.addTeleport(entity, from);
    }

    @Override
    public void whenEnd() {
        TeleportManager.addTeleport(entity, to, true);
    }
}
