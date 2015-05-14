/**
 * Created by dshook on 5/11/15.
 */
public class MeasurableFactory {

    public static Measurable getCircle(double r) {
        return new Circle(r);
    }

    public static Measurable getSquare(double l) {
        return new Square(l);
    }

    public static Measurable getTriangle(double s1, double s2, double s3) {
        return new Triangle(s1, s2, s3);
    }

    public static Measurable getShape(int numberOfSides) {
        if(numberOfSides == 1) {
            return new Circle();
        } else if(numberOfSides == 3) {
            return new Triangle();
        } else if(numberOfSides == 4) {
            return new Square();
        } else {
            throw new IllegalArgumentException("Must be 1, 3, 4");
        }
    }
}
