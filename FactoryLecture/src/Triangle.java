/**
 * Created by dshook on 5/11/15.
 */
public class Triangle implements Measurable {

    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this.side1 = this.side2 = this.side3 = 10.0;
    }

    public Triangle(double s1, double s2, double s3) {
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    @Override
    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3) / 2.0;
        return Math.sqrt(p*(p - this.side1) * (p - this.side2) *(p - this.side3));
    }

    @Override
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

}
