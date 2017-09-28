/**
 * Created by julia on 02.12.2016.
 */
public class Circle2 implements Polygon{
    private double radius;

    public Circle2(double radius){
        this.radius=radius ;
    }

    @Override
    public double area() {
        return radius*radius*Math.PI;
    }

    @Override
    public double perimeter() {
        return radius*2*Math.PI;
    }
}
