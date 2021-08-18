package random;

import arrays.ConsoleColors;

import java.util.Random;

public class RandomEx {
    public static void main(String[] args) {
        //stringArrayRandom();
        generateString();
    }

    private static void stringArrayRandom() {
//        Random random = new Random();
//        String[] strings = new String[5];
//
//        String[] words1 = new String[]{"Я", "Ты", "Он", "Она", "Они", "Вы"};
//        String[] words2 = new String[]{"уйти", "придти", "отдать", "забрать", "выкинуть", "прыгнуть"};
//        String[] words3 = new String[]{"на", "от", "за", "к", "там", "здесь", "оттуда"};
//        String[] words4 = new String[]{"дерево", "телефон", "луна", "книга", "одежда", "корова", "трактор"};
//        String[] words5 = new String[]{"хорошо.", "далеко.", "круто.", "весело.", "ярко.", "тепло.", "жидко."};

//        for (int i = 0; i < strings.length; i++)
//            strings[random.nextInt(strings.length)] = words[random.nextInt(words.length)];
//
//        for (String element : strings) {
//            System.out.print(element + "  ");
//        }
    }

    private static void generateString() {
        Random random = new Random();
        String[] strings = new String[6];
        String[] words1 = new String[]{"Я", "Ты", "Он", "Она", "Они", "Вы"};
        String[] words2 = new String[]{"уйти", "придти", "отдать", "забрать", "выкинуть", "прыгнуть"};
        String[] words3 = new String[]{"на", "от", "за", "к", "там", "здесь", "оттуда"};
        String[] words4 = new String[]{"дерево", "телефон", "луна", "книга", "одежда", "корова", "трактор"};
        String[] words5 = new String[]{"хорошо", "далеко", "круто", "весело", "ярко", "тепло", "жидко"};
        String[] words6 = new String[]{".", "!", "?", "!?"};
        // TODO generate random string from words1-5

        strings[0] = words1[random.nextInt(words1.length)];
        strings[1] = words2[random.nextInt(words2.length)];
        strings[2] = words3[random.nextInt(words3.length)];
        strings[3] = words4[random.nextInt(words4.length)];
        strings[4] = words5[random.nextInt(words5.length)];
        strings[5] = words6[random.nextInt(words6.length)];

        System.out.println();
        for (String randomString : strings) {
            System.out.print(ConsoleColors.RED + randomString + " " + ConsoleColors.BLACK);
        }
        System.out.println();
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
