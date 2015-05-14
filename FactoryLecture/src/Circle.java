import java.io.File;

/**
 * Created by dshook on 5/6/15.
 */
public class Circle implements Measurable{

    private double radius;

    public Circle() {
        this.radius = 10.0;
    }

    public void setRadius(double r) {

    }

    public Circle(double r) {
        if (r < 0) {
            throw new IllegalArgumentException();
        }
        this.radius = r;
    }

    public static double getArea(double r) {
        return Math.PI * r * r;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public static void main(String[] args) {

        Measurable circle = MeasurableFactory.getShape(1);
        System.out.println(circle.getArea());

        Measurable square = MeasurableFactory.getShape(4);
        System.out.println(square.getArea());

    }

}
