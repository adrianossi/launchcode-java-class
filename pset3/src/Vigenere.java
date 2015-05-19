/**
 * Created by adrian on 5/15/15.
 */


public class Vigenere implements Encodable {

    private int[] codecArray;

    public Vigenere(String key) {
        this.codecArray = this.createCodecArray(key);
    }

    public int[] createCodecArray(String key) {
        char[] keyAsArray = key.toCharArray();
        int[] keyAsInts = new int[keyAsArray.length];
        for (int i = 0; i < keyAsArray.length; i++) {
            keyAsInts[i] = (int)keyAsArray[i] - 'a' + 1;
        }
        return keyAsInts;
    }

    @Override
    public String encodeString(String input) {
        char[] inputAsArray = input.toCharArray();
        int keySlot = 0;
        for (int i = 0; i < input.length(); i++) {
            if (inputAsArray[i] + this.codecArray[keySlot] > 'z') {
                inputAsArray[i] = (char)(inputAsArray[i] + this.codecArray[keySlot] - 26);
                if (keySlot == this.codecArray.length - 1) {
                    keySlot = 0;
                } else {
                    keySlot++;
                }
            } else {
                inputAsArray[i] = (char)(inputAsArray[i] + this.codecArray[keySlot]);
                if (keySlot == this.codecArray.length - 1) {
                    keySlot = 0;
                } else {
                    keySlot++;
                }
            }
        }
        return new String(inputAsArray);
    }

    @Override
    public String decodeString(String input) {
        char[] inputAsArray = input.toCharArray();
        int keySlot = 0;
        for (int i = 0; i < input.length(); i++) {
            if (inputAsArray[i] - this.codecArray[keySlot] < 'a') {
                inputAsArray[i] = (char) (inputAsArray[i] - this.codecArray[keySlot] + 26);
                if (keySlot == this.codecArray.length - 1) {
                    keySlot = 0;
                } else {
                    keySlot++;
                }
            } else {
                inputAsArray[i] = (char) (inputAsArray[i] - this.codecArray[keySlot]);
                if (keySlot == this.codecArray.length - 1) {
                    keySlot = 0;
                } else {
                    keySlot++;
                }
            }
        }
        return new String(inputAsArray);
    }
}
