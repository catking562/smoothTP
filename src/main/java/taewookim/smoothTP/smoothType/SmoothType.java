package taewookim.smoothTP.smoothType;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class SmoothType {

    private boolean isEnd = false;
    private int tick = 0;
    private final int maxTick;



    public SmoothType(int maxTick, Entity entity, Location from, Location to) {
        this.maxTick = maxTick;
    }

    public final boolean isEnd() {
        return isEnd;
    }

    public final void setEnd() {
        isEnd = true;
    }

    public void created() {

    }

    public void everyTickUpdating() {
        switch(tick) {
            case 0:
                firstUpdate();
                break;
            default:
                update();
        }
        tick++;
        if(maxTick<=tick) {
            setEnd();
        }
    }

    public void firstUpdate() {

    }

    public void update() {

    }

}
