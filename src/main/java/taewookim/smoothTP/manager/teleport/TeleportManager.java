package taewookim.smoothTP.manager.teleport;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import taewookim.smoothTP.manager.check.CheckTeleporting;

import java.util.ArrayList;

public class TeleportManager {

    /*-----DontTouchBottom-----*/

    private static final ArrayList<TeleportData> list = new ArrayList<>(100);

    public synchronized static void addTeleport(Entity entity, Location to) {
        list.add(new TeleportData(entity, to, false));
    }

    public synchronized static void addTeleport(Entity entity, Location to, boolean isEnd) {
        list.add(new TeleportData(entity, to, isEnd));
    }

    public synchronized static void update() {
        for(TeleportData data : list) {
            Entity en = data.entity();
            en.teleport(data.to());
            if(data.isEnd()) {
                CheckTeleporting.removeTeleporting(en);
            }
        }
        list.clear();
    }

    /*-----CanCustomBottom-----*/

    /*-----CanUseBottom---*/

}
