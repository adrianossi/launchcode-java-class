import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by adrian on 5/15/15.
 */
public class EncodableTest extends TestCase {

    public void testSpy() {

        Spy bond = new Spy(new Caesar(1));
        bond.setEncodedMsg("shaken");
        assertEquals("tiblfo", bond.getEncodedMsg());
        assertEquals("shaken", bond.getDecodedMsg());
        Spy white = new Spy(new Caesar(1));

        for (int i = 1; i <= 26; i++) {
            bond.setCryptStrategy(new Caesar(i));
            white.setCryptStrategy(new Caesar(i));
            bond.setEncodedMsg("abcdefghijklmnopqrstuvwxyz");
            assertEquals(true, bond.isAlpha(bond.getEncodedMsg()));
            white.setEncodedMsg(bond.getDecodedMsg());
            assertEquals(white.getEncodedMsg(), bond.getEncodedMsg());
        }

        bond.setCryptStrategy(new Vigenere("james"));
        bond.setEncodedMsg("doubleohseven");
        assertEquals("nphgeopuxxffa", bond.getEncodedMsg());
        assertEquals(true, bond.isAlpha("abcdefghijklmnopqrstuvwxyz"));
        assertEquals(false, bond.isAlpha("a1"));
        assertEquals(false, bond.isAlpha("a}"));

        for (char c = 'a'; c <= 'z'; c++) {
            bond.setCryptStrategy(new Vigenere("abcdefghijklmnopqrstuvwxyz"));
            white.setCryptStrategy(new Vigenere("abcdefghijklmnopqrstuvwxyz"));
            bond.setEncodedMsg("" + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c);
            assertEquals(true, bond.isAlpha(bond.getEncodedMsg()));
            assertEquals(true, bond.isAlpha(bond.getDecodedMsg()));
            white.setEncodedMsg(bond.getDecodedMsg());
            assertEquals(white.getEncodedMsg(), bond.getEncodedMsg());
        }
    }
}
