package taewookim.smoothTP.smoothType;

public enum SmoothUpdaterEnum {

    /*-----DontTouchBottom-----*/

    DEFAULT(SmoothUpdater.class);

    private final Class<? extends SmoothUpdater> clz;

    SmoothUpdaterEnum(Class<? extends SmoothUpdater> clz) {
        this.clz = clz;
    }

    /*-----CanCustomBottom-----*/

    /*-----CanUseBottom---*/

}
