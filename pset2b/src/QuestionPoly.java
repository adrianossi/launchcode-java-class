import java.util.Scanner;

/**
 * This extension of the Question class stores a multiple choice
 * question that requires selection of several options to make a
 * correct answer.
 *
 * @author Adrian Ossi
 *
 * Created by adrian on 5/7/15.
 */
public class QuestionPoly extends Question {
    private String[] answerChoices;

    public QuestionPoly(String questionText,
                        String answer,
                        String[] answerChoices) {

        super(questionText, answer);
        this.answerChoices = answerChoices;
    }

    public String[] getAnswerChoices() {
        return this.answerChoices;
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

        // char variable for answer list
        char answerSlot = 'A';

        // print the answer choices in the command line one by one
        for (int i = 0; i < this.getAnswerChoices().length; i++) {
            System.out.println(answerSlot + ". " + this.getAnswerChoices()[i]);
            answerSlot++;
        }

        // prints instructions and get the user's answer
        System.out.println("Enter your choices in one line, with no spaces.");
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }
}
