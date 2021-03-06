package arrays;

public class FindInArray {
    public static void main(String[] args) {
        int[][] intArray = new int[][]{
                {1, 2, 65, 3, 87, 7, 89},
                {5, 986, 3452, 23456, 34, 3436, 78765, 3446},
                {-1, 4, -675, -367, 5346, 34227, 3436},
                {-1, 4, -675, -367, 5346, 34227, 3436}
        };
//        whereIs(3436, intArray);
//        int sumOf = sumOf(new int[]{5, 6, 4, 7});//0
//        System.out.println("Сумма всех в массиве: " + sumOf);
        System.out.println("Сумма двумерного массива: " + sumOfDoubleArray(intArray));
    }

    /**
     * Метод ищет заданное число в массиве и выводит где,
     * по какому столбцу и по какой строке находится искомое число
     *
     * @param searchable - искомое число
     * @param array      - массив для поиска
     * @return
     */
    public static void whereIs(int searchable, int[][] array) {
        //алгоритм поиска
        boolean searchableFound = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == searchable) {
                    System.out.println("Этот элемент находится в " + i + ":" + j);
                    searchableFound = true;
                }
            }
        }
        if (!searchableFound)
            System.out.println(searchable + " не найден");
    }

    /**
     * Возвращает сумму всех элементов
     *
     * @param array
     */
    //                                       0  1  2  3
    public static int sumOf(int[] array) {//{5, 6, 4, 7} / 4
        int a = 0; // 15

        for (int i = 0; i < array.length; i++) {// i = 2; (0 < 4) false
            a += array[i];//array[2]
        }
        return a;
    }

    public static int sumOfForEach(int[] array) {//{5, 6, 4, 7} / 4
        int a = 0; // 15

        for (int element : array) {// element = 7
            a += element;//array[2]
        }
        return a;
    }

    public static int sumOfDoubleArray(int[][] array) {
        int a = 0;
        int length = 0;
        for (int[] element1 : array) {//
            length += element1.length;

            for (int element2 : element1) {
                a += element2;
            }
        }
        return a;
    }

}
