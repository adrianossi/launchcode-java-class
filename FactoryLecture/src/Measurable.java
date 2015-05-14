/**
 * Created by dshook on 5/4/15.
 *
 * Static Methods
 *  Creation
 *  Usage
 * Factory Pattern
 *  When to use it
 *  How to use it
 *  Advantages
 * Refactoring
 *
 * Why refactor?
 *  - Make code easier to maintain, understand, and more efficient
 *
 *  Reasons to refactor: repetition (make a method)
 *                      Violating relationships (has - a, is - a, can - do)
 *                      Poor design (design patterns)
 *
 *  Most important rule of refactoring: don't add new features
 *
 *  Use your tests!
 *
 */

public interface Measurable {

    public double getArea();
    public double getPerimeter();
}
