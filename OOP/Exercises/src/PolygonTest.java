import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by julia on 02.12.2016.
 */
public class PolygonTest {
    ArrayList<Polygon> polygons;
    double epsilon = 1e-14;
    @Before
    public void setUp() throws Exception {
        polygons=new ArrayList<Polygon>();
        polygons.add(new Circle2(1));
        polygons.add(new Square(2));
        polygons.add(new Circle2(0));
        polygons.add(new Square(25));
    }

    @After
    public void tearDown() throws Exception {
        polygons.clear();
        polygons=null;
    }

    @Test
    public void area() throws Exception {
        Assert.assertEquals(Math.PI,polygons.get(0).area(),epsilon);
        Assert.assertEquals(4,polygons.get(1).area(),epsilon);
        Assert.assertEquals(0,polygons.get(2).area(),epsilon);
        Assert.assertEquals(625,polygons.get(3).area(),epsilon);
    }

    @Test
    public void perimeter() throws Exception {
        Assert.assertEquals(Math.PI*2,polygons.get(0).perimeter(),epsilon);
        Assert.assertEquals(8,polygons.get(1).perimeter(),epsilon);
        Assert.assertEquals(0,polygons.get(2).perimeter(),epsilon);
        Assert.assertEquals(100,polygons.get(3).perimeter(),epsilon);
    }

}