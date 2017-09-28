import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by julian on 02.12.2016.
 */
public class CheckBoundsTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void checkInBounds() throws Exception {
        Assert.assertTrue(CheckBounds.checkInBounds(5,4,6));
        Assert.assertTrue(CheckBounds.checkInBounds(5,4,99));
        Assert.assertTrue(CheckBounds.checkInBounds(0,Integer.MIN_VALUE,Integer.MAX_VALUE));
        Assert.assertTrue(CheckBounds.checkInBounds(20000,Integer.MIN_VALUE,Integer.MAX_VALUE));
        Assert.assertTrue(CheckBounds.checkInBounds(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE));
        Assert.assertTrue(CheckBounds.checkInBounds(Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE));
        Assert.assertTrue(CheckBounds.checkInBounds(-5,-6,-5));
        Assert.assertTrue(CheckBounds.checkInBounds(-100,-101,-99));
    }

    @org.junit.Test
    public void checkOutOfBounds() throws Exception {
        Assert.assertFalse(CheckBounds.checkInBounds(7,4,6));
        Assert.assertFalse(CheckBounds.checkInBounds(7,4,-5));
        Assert.assertFalse(CheckBounds.checkInBounds(Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE));
        Assert.assertFalse(CheckBounds.checkInBounds(Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE));
    }
}