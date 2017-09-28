/**
 * Created by julian on 02.12.2016.
 */
public class CheckBounds {
    public static boolean checkInBounds(Integer number,
                                        Integer lowerLimit, Integer upperLimit) {
        if (number >= lowerLimit && number <= upperLimit)
            return true;
        else
            return false;
    }
}
