package taewookim.smoothTP.manager.teleport;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

/*-----CantTouchBottom-----*/

public record TeleportData(
        Entity entity,
        Location to,
        boolean isEnd
) {
}
