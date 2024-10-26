package taewookim.smoothTP.manager.ansyupdater;

import taewookim.smoothTP.smoothType.AsyUpdater;

import java.util.ArrayList;

public class AsyUpdaterManager {

    /*-----DontTouchBottom-----*/

    private static final ArrayList<AsyUpdater> list = new ArrayList<>();

    public synchronized static void addUpdate(AsyUpdater updater) {
        list.add(updater);
    }

    public synchronized static void update() {
        ArrayList<AsyUpdater> removing = new ArrayList<>(list.size());
        for(AsyUpdater updater : list) {
            updater.everyTickUpdating();
            if(updater.isEnd()) {
                removing.add(updater);
            }
        }
        list.removeAll(removing);
    }

    /*-----CanCustomBottom-----*/

    /*-----CanUseBottom---*/

}
