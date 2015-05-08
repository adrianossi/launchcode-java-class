import java.util.Scanner;

/**
 * The Question class stores a simple question and its answer.
 *
 * The class is appropriate when the anticipated response will be entirely
 * user-generated in the form of a String (for example, fill-in-the-blank
 * and simple numerical questions).
 *
 * @author Adrian Ossi
 *
 * Created by adrian on 5/5/15.
 */

public class Question {
    private String questionText;
    private String answer;

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public String getAnswer() {
        return this.answer;
    }


    /**
     * The ask() method prints the question to the terminal and returns
     * the user's response.
     *
     * @return String
     */
    public String ask() {
        System.out.println(this.getQuestionText());
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }

    /**
     * The check() method compares a user-provided answer of type String with
     * the correct answer, returning true if it's correct.
     *
     * @param userAnswer A String, typically provided by the user who is taking
     *                   the test.
     * @return boolean
     */
    public boolean check(String userAnswer) {
        return this.getAnswer().toLowerCase().equals(userAnswer.toLowerCase());
    }

}