/**
 * Created by adrian on 5/15/15.
 */


public class Vigenere implements Encodable {

    private String key;

    public Vigenere(String key) {
        this.key = key;
    }

    @Override
    public String encodeString(String input) {
        char[] inputAsArray = input.toCharArray();
        for (int i = 0; i < inputAsArray.length; i++) {

        }
    }

    @Override
    public String decodeString(String input) {
        return null;
    }
}
  //  @Override
    //public String encodeString(String key, String input) {

      //  int keyLength = key.length();
        //key = key.toLowerCase();



        // Convert the chars in argv[1] to equivalent of ints Aa = 0, Bb = 1, etc.
        for (int i = 0; i < keyLength; i++)
        {
            argv[1][i] = argv[1][i] - 'A';
        }

        // Get text from the user to encrypt.
        string text = GetString();

        // Create variables needed for encryption.
        int textLength = strlen(text);
        int activeKeyChar = keyLength;

        for (int i = 0; i < textLength; i++)
        {
            // Character check: if not alphabetic, print as is.
            if ((isalpha (text[i])) == 0)
            {
                printf ("%c", text[i]);
            }

            // Character is confirmed alphabetic, so encrypt it.
            else
            {
                // Modulates the active key character to the key length,
                // in case we've wrapped through the key
                int k = activeKeyChar % keyLength;

                // Character check: runs this encryption if it is uppercase.
                if ((text[i] >= 'A') && (text[i] <= 'Z'))
                {
                    // Encrypted char check: if it's beyond Z, wrap and print.
                    if ((text[i] + argv[1][k]) > 'Z')
                    {
                        printf ("%c", ((text[i] + argv[1][k]) - 26));
                    }

                    // Encrypted character check: if it's not beyond Z, print it.
                    else
                    {
                        printf ("%c", (text[i] + argv[1][k]));
                    }
                }

                // Character check: runs this encryption if it is lowercase.
                else if ((text[i] >= 'a') && (text[i] <= 'z'))
                {
                    // Encrypted character check: if it's beyond z, wrap and print.
                    if ((text[i] + argv[1][k]) > 'z')
                    {
                        printf ("%c", ((text[i] + argv[1][k]) - 26));
                    }

                    // Encrypted character check: if it's not beyond z, print it.
                    else
                    {
                        printf ("%c", (text[i] + argv[1][k]));
                    }
                }

                activeKeyChar = activeKeyChar + 1;
            }
        }




//        return null;
  //  }

    //@Override
    //public String decodeString(String input) {
      //  return null;
    //}
//}
