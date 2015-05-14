/**
 * Created by dshook on 5/8/15.
 */
public class RPSPlayer {

    private RPSStrategy strategy;

    public RPSPlayer(RPSStrategy r) {
        this.strategy = r;
    }

    public String nextMove() {
        return strategy.getNextMove();
    }

    public static void main(String[] args) {

        RPSPlayer player1 = new RPSPlayer(new RockStrategy());
        RPSPlayer player2 = new RPSPlayer(new RandomStrategy());

        for(int i = 0; i < 5; i++) {
            String player1move = player1.nextMove();
            String player2move = player2.nextMove();

            System.out.println("Player 1 played: " + player1move);
            System.out.println("Player 2 played: " + player2move);
            if(player1move.equals(player2move)) {
                System.out.println("Its a tie!");
            } else if((player1move.equals("Rock") && player2move.equals("Scissors")) || (player1move.equals("Paper") && player2move.equals("Rock")) || (player1move.equals("Scissors") && player2move.equals("Paper"))) {
                System.out.println("Player 1 wins!");
            } else {
                System.out.println("Player 2 wins!");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        RPSPlayer rpsPlayer = (RPSPlayer) o;

        if (strategy != null ? !strategy.equals(rpsPlayer.strategy) : rpsPlayer.strategy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return strategy != null ? strategy.hashCode() : 0;
    }
}
