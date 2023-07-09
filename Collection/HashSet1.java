package Collection;

import java.util.HashSet;
import java.util.Set;

public class HashSet1 {
    public static void main(String[] args){

        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Java");
        set.add("Spring");

        int size = set.size();
        System.out.println(size);
    }

}
