/**
 * Created by dshook on 5/6/15.
 */
public class Square implements Measurable {

    private double length;

    public Square(double l) {
        this.length = l;
    }

    /**
     * Returns the area of the square
     * @return
     */
    @Override
    public double getArea() {
        return this.length * this.length;
    }

    /**
     * Returns the perimeter of square
     * @return
     */
    @Override
    public double getPerimeter() {
        return 4 * this.length;
    }

    @Override
    public int getNumberOfSides() {
        return 0;
    }
}
