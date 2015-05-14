import javax.swing.*;

/**
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

    public String ask() {
        String userAnswer = JOptionPane.showInputDialog(
                null, this.getQuestionText());
        return userAnswer;
    }

    public boolean check(String userAnswer) {
        return this.getAnswer().equals(userAnswer.toLowerCase());
    }

    public boolean checkAndTell(String userAnswer) {
        if (this.check(userAnswer.toLowerCase())) {
            JOptionPane.showMessageDialog(null, "Correct!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Wrong.");
            return false;
        }
    }
}
