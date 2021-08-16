package collections;

import java.util.*;

public class HashMapEx {
    public static void main(String[] args) {
        Map<Integer, String> mountNames = new HashMap<>();
        mountNames.put(1, "Январь");
        mountNames.put(2, "Февраль");
        mountNames.put(3, "Март");
        mountNames.put(4, "Апрель");
//
//        System.out.println(mountNames.keySet());
//        System.out.println(mountNames.values());
        System.out.println(mountNames.get(1));

        print(mountNames);
    }

    private static void print(Map<Integer, String> map) {
        for (Integer key : map.keySet()) {// {1,2,3,4}
            System.out.println(key + " : " + map.get(key));
        }
    }
}
