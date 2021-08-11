package collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetEx {
    public static void main(String[] args) {
        Set<String> sets = new HashSet<>();

        sets.add("Auto");
        sets.add("Auto");

        print(sets);
    }

    static void print(Set<String> set) {
        for (String val :
                set) {
            System.out.println(val);
        }
    }
}
