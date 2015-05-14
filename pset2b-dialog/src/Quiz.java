import javax.swing.*;

/**
 * Created by adrian on 5/5/15.
 */
public class Quiz {
    private Question[] questions;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public Question[] getQuestions() {
        return this.questions;
    }

    public Question getQuestion(int qIndex) {
        return this.getQuestions()[qIndex];
    }

    public void report(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public void administer(Question[] questions) {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            if (getQuestion(i).check(getQuestion(i).ask())) {
                report("Correct!");
                score++;
            } else {
                report("Wrong.");
            }
        }
        this.report("You got " + score + " out of " + questions.length + ".");
    }

    public static void main(String args[]) {

        String qtext = "What color is the sky?";
        String[] aq2 = {"red", "yellow", "blue", "azure"};
        int[] correct = {2, 3};
        QuestionMultMult q2 = new QuestionMultMult(qtext, aq2, correct);

        q2.ask();


/*        String qtext = "What color is the sky?";
        Question q0 = new Question(qtext, "blue");
        String[] aq1 = {"red", "yellow", "blue", "green"};
        QuestionMult q1 = new QuestionMult(qtext, aq1, 2);
        String qnum = "What is 1 + 1?";
        Question q2 = new Question(qnum, "2");

        Question[] quizQuestions = {q0, q1, q2};

        Quiz myQuiz = new Quiz(quizQuestions);

        myQuiz.administer(quizQuestions);
*/

/*
        int score = 0;
        String userA0 = q0.ask();
        if(q0.checkAndTell(userA0)) {
            score++;
        }
        String userA1 = q1.ask();
        if(q1.checkAndTell(userA1)) {
            score++;
        }
        String userA2 = q2.ask();
        if(q2.checkAndTell(userA2)) {
            score++;
        }
        JOptionPane.showMessageDialog(null, "You got " + score + " out of 3 correct.");
*/

//        Question[] simpleQuestions = {q0, q1};
  //      Quiz simple = new Quiz(simpleQuestions);
    //    simple.getQuestion(1).ask();


/*
        String userAnswer = JOptionPane.showInputDialog(
                null, q2.getQuestionText());

        if (this.checkAnswer(q2, userAnswer)) {
            JOptionPane.showMessageDialog(null, "Correct!");
        } else {
            JOptionPane.showMessageDialog(null, "Wrong. The answer is: " + q2.getAnswer());
        }
*/
    }
}
