import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Created by dshook on 5/6/15.
 */
public class Circle implements Measurable{

    private double radius;

    public Circle(double r) {
        if (r < 0) {
            throw new IllegalArgumentException();
        }
        this.radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public int getNumberOfSides() {
        File f = new File("/home/dshook/Documents/launchcode-java-class/InterfacesLecture/src/file.txt");
        return 0;
    }

    public static void main(String[] args) {

        Measurable c = new Circle(-5.0);
        Measurable s = new Square(5.0);

        Measurable[] listOfShapes = new Measurable[10];

        listOfShapes[0] = c;
        listOfShapes[1] = s;

    }
}
