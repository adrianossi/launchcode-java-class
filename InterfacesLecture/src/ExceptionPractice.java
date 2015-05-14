import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Created by dshook on 5/6/15.
 */
public class ExceptionPractice {

    public static void main(String[] args) {

        File f = new File("/home/dshook/Documents/launchcode-java-class/InterfacesLecture/src/file.txt");

        try {
            Scanner s = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("This file doesn't exist, dummy");
        }
        System.out.println("Found the file");
        //Do scanner stuff

    }
}
