import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by dshook on 5/6/15.
 */
public class CollectionsPractice {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.get(0);
        list.size();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Doug", 30);
        map.put("Jesse", -4);
        map.put("Chris", 100000000);
        map.put("Doug", 100);

        System.out.println(map.get("Doug"));

        Set<String> s = map.keySet();
        for(String key : s) {
            System.out.println(key);
            //map.get(key);
        }
    }
}
