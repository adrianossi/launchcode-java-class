import javax.swing.*;

/**
 * Created by adrian on 5/5/15.
 */
public class QuestionMult extends Question {
    private String[] answerChoices;
    private int correctAnswerIndex;

    public QuestionMult(String questionText, String[] answerChoices, int correctAnswerIndex) {
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

    public String ask() {

        String userAnswer = (String)JOptionPane.showInputDialog(
                null,
                this.getQuestionText(),
                "Question",
                JOptionPane.OK_CANCEL_OPTION,
                null,
                answerChoices,
                answerChoices[0]
        );
        return userAnswer;
    }

}

/*

null,
                this.getQuestionText(),
                "Question",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                answerChoices,
                answerChoices[0]
 */