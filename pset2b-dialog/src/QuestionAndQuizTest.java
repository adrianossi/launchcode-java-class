import org.junit.Test;

import junit.framework.TestCase;

/**
 * Created by adrian on 5/5/15.
 */

public class QuestionAndQuizTest extends TestCase {
    @Test
    public void testQuestion() {
        String qtext = "What color is the sky?";
        Question q1 = new Question(qtext, "blue");
        assertEquals(qtext, q1.getQuestionText());
        String[] aq2 = {"red", "yellow", "blue", "green"};
        QuestionMult q2 = new QuestionMult(qtext, aq2, 2);
        assertEquals("blue", q2.getAnswerChoices()[q2.getCorrectAnswerIndex()]);
    }


}
