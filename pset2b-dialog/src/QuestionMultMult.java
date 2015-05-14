import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by adrian on 5/6/15.
 */
public class QuestionMultMult extends Question implements ItemListener{
    private String[] answerChoices;
    private int[] correctAnswerIndices;

    public QuestionMultMult(String questionText, String[] answerChoices, int[] correctAnswerIndices) {
        super(questionText, null);
        this.answerChoices = answerChoices;
        this.correctAnswerIndices = correctAnswerIndices;
    }

    public boolean check(String userAnswer) {
        return true;
    }

    public String[] getAnswerChoices() {
        return this.answerChoices;
    }

    public String handOffString(String s) {
        return s;
    }

    public String ask() {

        // make a blank dialog box, add a layout
        JFrame frame = new JFrame("Question");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make a panel within the frame
        JPanel background = new JPanel(new BorderLayout());

        // create a label
        JLabel question = new JLabel("What color is the sky?");

        // create checkboxes in a new panel and add them to the background
        JPanel boxes = new JPanel(new GridLayout(0, 1));
        JCheckBox[] choices = new JCheckBox[4];
        choices[0] = new JCheckBox("Blue");

        choices[1] = new JCheckBox("Red");
        choices[2] = new JCheckBox("Purple");
        choices[3] = new JCheckBox("Maroon");

        for (int i = 0; i < 4; i++) {
            boxes.add(choices[i]);
        }

        // create submit button
        JButton submitButton = new JButton("Submit");

        // add everything to dialog
        background.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        background.add(question, BorderLayout.LINE_START);
        background.add(boxes, BorderLayout.CENTER);
        background.add(submitButton, BorderLayout.LINE_END);
        question.setAlignmentX(background.CENTER_ALIGNMENT);
        frame.getContentPane().add(background);

        // show the dialog
        frame.pack();
        frame.setVisible(true);

        return "an answer";

    }


/*    public String ask() {
        JCheckBox[] boxOptions = new JCheckBox[answerChoices.length];
        for (int i = 0; i < answerChoices.length; i++) {
            boxOptions[i] = new JCheckBox(this.getAnswerChoices()[i]);
            boxOptions[i].addItemListener();
        }
        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add( )
*/
/*
        Object dialogDisplay = new Object();
        dialogDisplay = this.getQuestionText(), boxOptions;
        String userAnswer = (String) JOptionPane.showInputDialog(
                null,
                dialogDisplay,
                "Question",
                JOptionPane.OK_CANCEL_OPTION
        );
        return userAnswer;

    }
*/
}
