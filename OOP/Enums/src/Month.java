/**
 * Created by julia on 20-Dec-16.
 */
public enum Month {
    JANUARY(1,31),
    FEBRUARY(2,28),
    MARCH(3,31),
    APRIL(4,30),
    MAY(5,31),
    JUNE(6,30),
    JULY(7,31),
    AUGUST(8,31),
    SEPTEMBER(9,30),
    OCTOBER(10,31),
    NOVEMBER(11,30),
    DECEMBER(12,31);
    private final int code;
    private final int days;

    Month(int code,int days){
        this.code=code;
        this.days=days;
    }
    public int value(){
        return code;
    }
    public int daysOfMonth(){
        return days;
    }
    public static Month getMonth(int i){
        return Month.values()[i-1];
    }

    public Season getSeason(){
        switch (this){

            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return Season.WINTER;
            case MARCH:
            case APRIL:
            case MAY:
                return Season.SPRING;
            case JUNE:
            case JULY:
            case AUGUST:
                return Season.SUMMER;
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                return Season.AUTUMN;
        }
        return null;
    }
}
