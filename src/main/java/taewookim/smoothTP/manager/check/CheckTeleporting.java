package taewookim.smoothTP.manager.check;

import org.bukkit.entity.Entity;

import java.util.ArrayList;

public class CheckTeleporting {

    private static final ArrayList<Entity> teleporting = new ArrayList<>(2000);

    public synchronized static void addTeleporting(Entity entity) {
        teleporting.add(entity);
    }

    public synchronized static boolean isTeleporting(Entity entity) {
        return teleporting.contains(entity);
    }

    public synchronized static void removeTeleporting(Entity entity) {
        teleporting.remove(entity);
    }

}
