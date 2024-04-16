package Hashtables;

import java.util.Hashtable;
import java.util.Set;

public class Hashtable_example {
    public static void main(String[] args) {
        Hashtable<String, Integer> myData = new Hashtable<>();
        myData.put("NC", 200000);
        myData.put("GA", 98000);
        myData.put("TN", 765123);
        myData.put("NY", 7655555);

        System.out.println("Whole hash table data: " + myData);

        Set<String> keys = myData.keySet();
        for (String key : keys) {
            System.out.printf("%s %s \n", key, myData.get(key));
        }
    }
}
