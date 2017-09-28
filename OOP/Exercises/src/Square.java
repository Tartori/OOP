/**
 * Created by julia on 02.12.2016.
 */
public class Square implements Polygon {
    private double length;

    public Square(double length){
        this.length = length;
    }

    @Override
    public double area() {
        return length*length;
    }

    @Override
    public double perimeter() {
        return length * 4;
    }
}
