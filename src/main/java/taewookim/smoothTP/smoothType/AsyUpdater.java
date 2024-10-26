package taewookim.smoothTP.smoothType;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import taewookim.smoothTP.manager.check.CheckTeleporting;

public abstract class AsyUpdater {

    private boolean isEnd = false;
    protected int tick = 0;
    protected final int maxTick;

    protected final Entity entity;
    protected final Location from;
    protected final Location to;

    public AsyUpdater(int maxTick, Entity entity, Location from, Location to) {
        this.maxTick = maxTick;
        created();
        this.entity = entity;
        this.from = from;
        this.to = to;
        CheckTeleporting.addTeleporting(entity);
    }

    /*-----DontTouchBottom-----*/

    public final boolean isEnd() {
        return isEnd;
    }

    public final void setEnd() {
        isEnd = true;
        whenEnd();
    }

    /*-----CanCustomBottom-----*/

    public void everyTickUpdating() {
        switch(tick) {
            case 0:
                firstUpdate();
                break;
            default:
                update();
                break;
        }
        tick++;
        if(maxTick<=tick) {
            setEnd();
        }
    }

    /*-----CanUseBottom---*/

    /**If you need many calculate, you should use "firstUpdate()"*/
    public abstract void created();

    public abstract void firstUpdate();

    public abstract void update();

    public abstract void whenEnd();

}
