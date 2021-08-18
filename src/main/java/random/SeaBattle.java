package random;

import java.util.Random;

public class SeaBattle {

    static Random random = new Random();

    public static void main(String[] args) {
        int[][] map = new int[10][10];

        fillSinge(map);
        fillSinge(map);
        fillSinge(map);
        fillSinge(map);

        fillTwo(map);
        fillTwo(map);
        fillTwo(map);

        printMap(map);
    }

    private static void printMap(int[][] map) {
        System.out.println("    | A | B | C | D | E | F | G | H | I | G |");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) < 10 ? (i + 1 + "   | ") : (i + 1 + "  | "));
            for (int item : map[i]) {
                System.out.print(item + " | ");
            }
            System.out.println();
        }
    }

    private static void fillTwo(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);// 0
            int randomCol = random.nextInt(map[randomRow].length);// 7
            isNotExists = map[randomRow][randomCol] == 1;// true
            if (!isNotExists) { //true
                if (isRightEmpty(map, randomRow, randomCol)) { // true
                    map[randomRow][randomCol] = 1;
                    map[randomRow][randomCol + 1] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }

    private static boolean isRightEmpty(int[][] map, int row, int column) {
        if (map[row].length > column + 1)
            return map[row][column + 1] == 0;
        return false;
    }

    private static void fillSinge(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);// 4
            int randomCol = random.nextInt(map[randomRow].length); // 1
            isNotExists = map[randomRow][randomCol] == 1;//false
            if (!isNotExists)
                map[randomRow][randomCol] = 1;
        }
    }
}
