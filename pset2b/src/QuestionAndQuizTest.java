import org.junit.Test;
import junit.framework.TestCase;


/**
 * Test class that applies to Question and Quiz classes.
 *
 * @author Adrian Ossi
 *
 * Created by adrian on 5/7/15.
 */

public class QuestionAndQuizTest extends TestCase {

    public void testQuestion() {
        String qtext = "What color is the sky?";

        // test fill-in-the-blank question (via Question)
        Question q1 = new Question(qtext, "blue");
        assertEquals(qtext, q1.getQuestionText());
        assertEquals(true, q1.check("BLUE"));
        assertEquals(true, q1.check("Blue"));
        assertEquals(true, q1.check("blue"));
        assertEquals(false, q1.check("bleu"));
        assertEquals(false, q1.check("azure"));

        // test multiple choice question (via QuestionMult)
        String[] aq2 = {"red", "yellow", "blue", "green"};
        QuestionMult q2 = new QuestionMult(qtext, aq2, 2);
        assertEquals(qtext, q2.getQuestionText());
        assertEquals("blue", q2.getAnswerChoices()[q2.getCorrectAnswerIndex()]);
        assertEquals(true, q2.check("C"));
        assertEquals(true, q2.check("c"));
        assertEquals(false, q2.check("B"));
        assertEquals(false, q2.check("Blue"));

        // test numerical question (via Question)
        Question q3 = new Question("What is 1 + 1?", "2");
        assertEquals("What is 1 + 1?", q3.getQuestionText());
        assertEquals("2", q3.getAnswer());
        assertEquals(true, q3.check("2"));
        assertEquals(false, q3.check("3"));

        // test multiple choice, multiple answer (via QuestionPoly)
        String[] q4options = {"cake", "ice cream", "spaghetti", "broccoli", "cookie"};
        Question q4 = new QuestionPoly("Which of these is a dessert?", "abe", q4options);
        assertEquals("Which of these is a dessert?", q4.getQuestionText());
        assertEquals(true, q4.check("abe"));
        assertEquals(true, q4.check("AbE"));
        assertEquals(false, q4.check("abd"));
    }
}
