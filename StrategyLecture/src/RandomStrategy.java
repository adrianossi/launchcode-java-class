/**
 * Created by dshook on 5/8/15.
 */
public class RandomStrategy implements RPSStrategy {
    @Override
    public String getNextMove() {
        double x = Math.random();

        if ( x < .33) {
            return "Rock";
        } else if (x >= .33 && x < .66) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }
}
