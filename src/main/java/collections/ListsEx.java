package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListsEx {
    public static void main(String[] args) {
        List<String> phones = new ArrayList<>(
                Arrays.asList("+996707142842",//0
                        "0555123123",//1
                        "771390978"//2
                )
        );

        List<String> others = new ArrayList<>(Arrays.asList(
                "123123",
                "4565433"
        ));

        List<List<String>> listInList = new ArrayList<>();
        listInList.add(new ArrayList<>(Arrays.asList("", "")));

        print(phones);
        System.out.println("______ add at index______");
        phones.add(1, "0222432231");
        print(phones);
        System.out.println("______ add all ______");
        phones.addAll(others);
        print(phones);
        System.out.println("______ index of ______");
        System.out.println(phones.indexOf("771390978"));
        System.out.println("______ set ______");
        phones.set(0, "00000000");
        print(phones);
        System.out.println("______ remove ______");
        phones.remove("123123");
        phones.remove(0);
        print(phones);
        System.out.println("______sublist 1 3______");
        print(phones.subList(1, 3));
        System.out.println("______--------______");
        print(phones);
    }

    private static void print(List<String> array) {
        for (String phone : array) {
            System.out.println(phone);
        }
    }
}
