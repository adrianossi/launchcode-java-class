/**
 * Created by adrian on 5/20/15.
 */
public class EncodableFactory {

    public static Encodable getCaesar(int key) {
        return new Caesar(key);
    }

    public static Encodable getVigenere(String key) {
        return new Vigenere(key);
    }
}
