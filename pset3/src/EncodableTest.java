import org.junit.Test;
import junit.framework.TestCase;

/**
 * Created by adrian on 5/15/15.
 */
public class EncodableTest extends TestCase {

    public void testSpy() {

        Spy bond = SpyFactory.getSpy(EncodableFactory.getCaesar(1));
        bond.setEncodedMsg("shaken");
        assertEquals("tiblfo", bond.getEncodedMsg());
        assertEquals("shaken", bond.getDecodedMsg());
        Spy white = SpyFactory.getSpy(EncodableFactory.getCaesar(1));

        for (int i = 1; i <= 26; i++) {
            bond.setCryptStrategy(EncodableFactory.getCaesar(i));
            white.setCryptStrategy(EncodableFactory.getCaesar(i));
            bond.setEncodedMsg("abcdefghijklmnopqrstuvwxyz");
            assertEquals(true, bond.isAlpha(bond.getEncodedMsg()));
            white.setEncodedMsg(bond.getDecodedMsg());
            assertEquals(white.getEncodedMsg(), bond.getEncodedMsg());
        }

        bond.setCryptStrategy(EncodableFactory.getVigenere("james"));
        bond.setEncodedMsg("doubleohseven");
        assertEquals("nphgeopuxxffa", bond.getEncodedMsg());
        assertEquals(true, bond.isAlpha("abcdefghijklmnopqrstuvwxyz"));
        assertEquals(false, bond.isAlpha("a1"));
        assertEquals(false, bond.isAlpha("a}"));

        for (char c = 'a'; c <= 'z'; c++) {
            bond.setCryptStrategy(EncodableFactory.getVigenere("abcdefghijklmnopqrstuvwxyz"));
            white.setCryptStrategy(EncodableFactory.getVigenere("abcdefghijklmnopqrstuvwxyz"));
            bond.setEncodedMsg("" + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c + c);
            assertEquals(true, bond.isAlpha(bond.getEncodedMsg()));
            assertEquals(true, bond.isAlpha(bond.getDecodedMsg()));
            white.setEncodedMsg(bond.getDecodedMsg());
            assertEquals(white.getEncodedMsg(), bond.getEncodedMsg());
        }
    }
}
