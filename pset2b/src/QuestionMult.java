import java.util.Scanner;

/**
 * This extension of the Question class stores a multiple choice
 * question that has one option as the correct answer.
 *
 * @author Adrian Ossi
 *
 * Created by adrian on 5/5/15.
 */
public class QuestionMult extends Question {
    private String[] answerChoices;
    private int correctAnswerIndex;

    public QuestionMult(String questionText,
                        String[] answerChoices,
                        int correctAnswerIndex) {
        super(questionText, answerChoices[correctAnswerIndex]);
        this.answerChoices = answerChoices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String[] getAnswerChoices() {
        return this.answerChoices;
    }

    public int getCorrectAnswerIndex() {
        return this.correctAnswerIndex;
    }

    /**
     * Via Scanner, this method presents the question to a user and
     * gets the user's answer.
     *
     * @return a String that is the user's answer.
     */
    public String ask() {

        // ask the question in the command line
        System.out.println(this.getQuestionText());

        // char variable for answer tracking
        char answerSlot = 'A';

        // print the answer choices in the command line one by one
        for (int i = 0; i < this.getAnswerChoices().length; i++) {
            System.out.println(answerSlot + ". " + this.getAnswerChoices()[i]);
            answerSlot++;
        }

        // get the user's answer
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }

    /**
     * The check() method takes a user-provided answer of type String, extracts
     * the first letter, converts it to an int, and compares it with the correct
     * answer index, returning true if they match.
     *
     * @param userAnswer A String, typically provided by the user who is taking
     *                   the test. The method takes only the first letter.
     * @return True if the answer is correct.
     */
    public boolean check(String userAnswer) {
        String correctAnswer = "" + (char)('A' + this.getCorrectAnswerIndex());
        return correctAnswer.equals(userAnswer.toUpperCase());
    }

}
