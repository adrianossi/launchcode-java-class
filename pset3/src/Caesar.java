import java.util.HashMap;

/**
 * Created by adrian on 5/15/15.
 */
public class Caesar implements Encodable {
    private HashMap<Character, Character> encodeMap;
    private HashMap<Character, Character> decodeMap;

    public Caesar(int key) {
        this.encodeMap = this.createEncodeMap(key);
        this.decodeMap = this.createDecodeMap(key);
    }

    @Override
    public String encodeString(String input) {
        char[] inputAsArray = input.toCharArray();
        for (int i = 0; i < inputAsArray.length; i++) {
            inputAsArray[i] = this.encodeMap.get(inputAsArray[i]);
        }
        String output = new String(inputAsArray);
        return output;
    }

    @Override
    public String decodeString(String input) {
        char[] inputAsArray = input.toCharArray();
        for (int i = 0; i < inputAsArray.length; i++) {
            inputAsArray[i] = this.decodeMap.get(inputAsArray[i]);
        }
        String output = new String(inputAsArray);
        return output;
    }

    public HashMap<Character, Character> createEncodeMap(int key) {
        HashMap<Character, Character> newEncodeMap = new HashMap<Character, Character>();

        for (char activeChar = 'a'; activeChar <= 'z'; activeChar++) {
            if (activeChar + key > 'z') {
                newEncodeMap.put(activeChar, (char)(activeChar + key - 26));
            } else {
                newEncodeMap.put(activeChar, (char)(activeChar + key));
            }
        }
        return newEncodeMap;
    }

    public HashMap<Character, Character> createDecodeMap(int key) {
        HashMap<Character, Character> newDecodeMap = new HashMap<Character, Character>();
        for (char activeChar = 'a'; activeChar <= 'z'; activeChar++) {
            if (activeChar - key < 'a') {
                newDecodeMap.put(activeChar, (char)(activeChar - key + 26));
            } else {
                newDecodeMap.put(activeChar, (char)(activeChar - key));
            }
        }
        return newDecodeMap;
    }
}
