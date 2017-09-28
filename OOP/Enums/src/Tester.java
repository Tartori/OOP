import org.junit.Assert;

/**
 * Created by julia on 20-Dec-16.
 */
public class Tester {

    public static void main(String[] args){
        for (Month m: Month.values()) {
            System.out.println(m+" - Month:"+m.value()+" - Number of Days:"+m.daysOfMonth());
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Summer months:");
        for (Month m: Month.values()) {
            if(m.getSeason() == Season.SUMMER)
                System.out.print(m + " ");
        }

    }

    @org.junit.Test
    public void converter() throws Exception {
        Month m = Month.MARCH;
        Month m2 = Month.getMonth(3);
        Assert.assertEquals(m,m2);
    }
}
