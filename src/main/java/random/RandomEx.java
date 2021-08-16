package random;

import java.util.Random;

public class RandomEx {
    public static void main(String[] args) {
        stringArrayRandom();
    }

    private static void stringArrayRandom() {
        Random random = new Random();
        String[] strings = new String[5];

        String[] words1 = new String[]{"Я", "Ты", "Он", "Она", "Они", "Вы"};
        String[] words2 = new String[]{"уйти", "придти", "отдать", "забрать", "выкинуть", "прыгнуть"};
        String[] words3 = new String[]{"на", "от", "за", "к", "там", "здесь", "оттуда"};
        String[] words4 = new String[]{"дерево", "телефон", "луна", "книга", "одежда", "корова", "трактор"};
        String[] words5 = new String[]{"хорошо.", "далеко.", "круто.", "весело.", "ярко.", "тепло.", "жидко."};

//        for (int i = 0; i < strings.length; i++)
//            strings[random.nextInt(strings.length)] = words[random.nextInt(words.length)];
//
//        for (String element : strings) {
//            System.out.print(element + "  ");
//        }
    }

    private static void generateString() {
        String str = "";
        // TODO generate random string from words1-5
        System.out.println(str);
    }


    private static void intArrayRandom() {
        Random random = new Random();
        // 0  1  2  3  4  5
        int[] array = new int[6];//[0, 0, 0, 0, 0, 0]

        array[random.nextInt(array.length)] = random.nextInt(10);

        for (int i = 0; i < array.length; i++) {// array.length = 6
            int randomIndex = random.nextInt(array.length);// 5
            int randomIntValue = random.nextInt(10);// 7

            array[randomIndex] = randomIntValue;
        }
//
        for (int a : array) {
            System.out.print(a + " | ");
        }
    }
}
