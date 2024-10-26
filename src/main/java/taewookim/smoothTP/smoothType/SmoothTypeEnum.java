package taewookim.smoothTP.smoothType;

public enum SmoothTypeEnum {

    DEFAULT(SmoothType.class);

    private final Class<? extends SmoothType> clz;

    SmoothTypeEnum(Class<? extends SmoothType> clz) {
        this.clz = clz;
    }

}
