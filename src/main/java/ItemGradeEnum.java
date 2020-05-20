public enum ItemGradeEnum {
    PREMIUM,
    BEST,
    GOOD,
    NOT_BAD,
    NOT_GOOD,
    BAD,
    WORST;

    private static int maskBit = 1;
    private int mask;
    static {
        for(ItemGradeEnum item : ItemGradeEnum.values()) {
            item.mask = ItemGradeEnum.maskBit;
            ItemGradeEnum.maskBit *= 2;
        }
    }

    public static int getMask() {
        return ItemGradeEnum.maskBit;
    }
}
