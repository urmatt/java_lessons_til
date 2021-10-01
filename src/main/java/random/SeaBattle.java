package random;
import arrays.ConsoleColors;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SeaBattle {
    static Random random = new Random();
    static int EMPTY = 0;
    static int SHIP = 1;
    static int DESTROYED = 2;
    static int MISSED = 3;

    static List<String> colNames = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

    public static void main(String[] args) {
        int[][] map = new int[10][10];
        int[][] mapComputer = new int[10][10];

        fillMap(map);
        fillMap(mapComputer);
        System.out.println();
        System.out.println(ConsoleColors.BLUE + "               Ваша карта: " + ConsoleColors.WHITE);
        printMap(map);
        System.out.println();
        System.out.println(ConsoleColors.RED + "            Карта компьютера: " + ConsoleColors.WHITE);
        printHiddenMap(mapComputer);

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        boolean gameOver = false;
        while (!gameOver) {
            int rowIndex = 0;
            int colIndex = 0;
            System.out.println();
            System.out.println(ConsoleColors.RED + "Ваш ход: " + ConsoleColors.WHITE);
            String str = scanner.nextLine();
            boolean isOk = str.matches("[0-9]{1,2}[A-J]");
            if (isOk) {
                if (str.trim().length() > 2) {
                    rowIndex = Integer.parseInt(str.substring(0, 2)) - 1;
                    colIndex = colNameToIndex(str.substring(2, 3));
                } else {
                    rowIndex = Integer.parseInt(str.substring(0, 1)) - 1;
                    colIndex = colNameToIndex(str.substring(1, 2));
                }

                if (mapComputer[rowIndex][colIndex] == EMPTY) {
                    mapComputer[rowIndex][colIndex] = MISSED;
                } else if (mapComputer[rowIndex][colIndex] == SHIP) {
                    mapComputer[rowIndex][colIndex] = DESTROYED;
                    System.out.println(ConsoleColors.RED + "            Карта компьютера: " + ConsoleColors.WHITE);
                    printHiddenMap(mapComputer);
                    System.out.println("Попадание");
                    if (isGameOver(mapComputer)) {
                        System.out.println("Вы выиграли!!!!");
                        System.out.println(ConsoleColors.RED + "            Карта компьютера: " + ConsoleColors.WHITE);
                        printMap(mapComputer);
                        break;
                    } else {
                        continue;
                    }
                }
                System.out.println(ConsoleColors.RED + "            Карта компьютера: " + ConsoleColors.WHITE);
                printHiddenMap(mapComputer);
                System.out.println(ConsoleColors.GREEN_BRIGHT + "Ход компьютера: " + ConsoleColors.WHITE);
                computerGame(map);
                System.out.println(ConsoleColors.BLUE + "               Ваша карта: " + ConsoleColors.WHITE);
                printMap(map);
                if (isGameOver(map)) {
                    System.out.println("Вы проиграли!");
                    System.out.println(ConsoleColors.BLUE + "               Ваша карта: " + ConsoleColors.WHITE);
                    printMap(map);
                    gameOver = true;
                }
            }
        }
    }

    private static int colNameToIndex(String name) {
        return colNames.indexOf(name);
    }

    private static void computerGame(int[][] gamerMap) {
        boolean isEmptyOrShip = false;
        while (!isEmptyOrShip) {
            int randomRow = random.nextInt(gamerMap.length);
            int randomCol = random.nextInt(gamerMap[randomRow].length);
            if (gamerMap[randomRow][randomCol] == EMPTY
                    || gamerMap[randomRow][randomCol] == SHIP) {
                isEmptyOrShip = true;
                if (isEmptyOrShip) {
                    String step = (randomRow + 1) + colNames.get(randomCol);
                    if (gamerMap[randomRow][randomCol] == EMPTY) {
                        gamerMap[randomRow][randomCol] = MISSED;
                        System.out.println(ConsoleColors.GREEN_BOLD + step + ConsoleColors.WHITE);
                    } else if (gamerMap[randomRow][randomCol] == SHIP) {
                        gamerMap[randomRow][randomCol] = DESTROYED;
                        System.out.println(ConsoleColors.RED + step + ConsoleColors.WHITE);
                    }

                }
                if (gamerMap[randomRow][randomCol] == DESTROYED) {
                    isEmptyOrShip = false;
                }
            }
        }
    }

    private static boolean isGameOver(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void println(String string) {
        System.out.println(string + ConsoleColors.RESET);
    }

    private static void fillMap(int[][] map) {
        fillOne(map);
        fillOne(map);
        fillOne(map);
        fillOne(map);

        if (random.nextBoolean()) {
            fill4Horizontal(map);
        } else {
            fill4Vertical(map);
        }
        for (int i = 0; i < 2; i++) {
            if (random.nextBoolean()) {
                fill3Horizontal(map);
            } else {
                fill3Vertical(map);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (random.nextBoolean()) {
                fill2Horizontal(map);
            } else {
                fill2Vertical(map);
            }
        }


    }

    private static void printHiddenMap(int[][] map) {
        System.out.print("    |");
        for (String cName : colNames) {
            System.out.print(" " + cName + " |");
        }
        System.out.println("\n---------------------------------------------");
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) < 10 ? (i + 1 + "   | ") : (i + 1 + "  | "));
            for (int item : map[i]) {
                if (item == DESTROYED)
                    System.out.print(ConsoleColors.RED + "▓" + ConsoleColors.WHITE + " | ");
                else if (item == MISSED)
                    System.out.print(ConsoleColors.YELLOW + "*" + ConsoleColors.WHITE + " | ");
                else System.out.print("  | ");
            }
            System.out.println();
        }
    }

    private static void printMap(int[][] map) {
        System.out.print("    |");
        for (String cName : colNames) {
            System.out.print(" " + cName + " |");
        }
        System.out.println("\n---------------------------------------------");
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) < 10 ? (i + 1 + "   | ") : (i + 1 + "  | "));
            for (int item : map[i]) {
                if (item == SHIP)
                    System.out.print(ConsoleColors.BLUE + "▓" + ConsoleColors.WHITE + " | ");
                else if (item == DESTROYED)
                    System.out.print(ConsoleColors.RED + "▓" + ConsoleColors.WHITE + " | ");
                else if (item == MISSED)
                    System.out.print(ConsoleColors.YELLOW + "*" + ConsoleColors.WHITE + " | ");
                else System.out.print("  | ");
            }
            System.out.println();
        }
    }

    private static void fillOne(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);
            int randomCol = random.nextInt(map[randomRow].length);
            isNotExists = map[randomRow][randomCol] == 1;
            if (!isNotExists) {
                if (isLeftEmpty(map, randomRow, randomCol)
                        && isRightEmpty(map, randomRow, randomCol)
                        && isTopEmpty(map, randomRow, randomCol)
                        && isBottomEmpty(map, randomRow, randomCol)
                        && isDiagonalsEmpty(map, randomRow, randomCol)) {
                    map[randomRow][randomCol] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }

    private static void fill2Horizontal(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);
            int randomCol = random.nextInt(map[randomRow].length);
            isNotExists = map[randomRow][randomCol] == 1;
            if (!isNotExists) {
                if (isLeftEmpty(map, randomRow, randomCol)
                        && isRightEmpty(map, randomRow, randomCol)
                        && isRightEmpty(map, randomRow, randomCol + 1)
                        && (randomRow > 0 ? isTopEmpty(map, randomRow, randomCol) : true)
                        && (randomRow < map.length - 1 ? isBottomEmpty(map, randomRow, randomCol) : true)
                        && isDiagonalsEmpty(map, randomRow, randomCol)) {
                    map[randomRow][randomCol] = 1;
                    map[randomRow][randomCol + 1] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }

    private static void fill2Vertical(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);
            int randomCol = random.nextInt(map[randomRow].length);
            isNotExists = map[randomRow][randomCol] == 1
                    && randomRow > 0;
            if (!isNotExists) {
                if (isBottomEmpty(map, randomRow, randomCol)
                        && isTopEmpty(map, randomRow, randomCol)
                        && (randomRow >= 2 ? isTopEmpty(map, randomRow - 1, randomCol) : true)
                        && (randomCol > 0 ? isLeftEmpty(map, randomRow, randomCol) : true)
                        && (randomCol < map.length - 1 ? isRightEmpty(map, randomRow, randomCol) : true)
                        && isDiagonalsEmpty(map, randomRow, randomCol)) {
                    map[randomRow][randomCol] = 1;
                    map[randomRow - 1][randomCol] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }

    private static void fill3Horizontal(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);
            int randomCol = random.nextInt(map[randomRow].length - 3);
            isNotExists = map[randomRow][randomCol] == 1;
            if (!isNotExists) {
                if (isLeftEmpty(map, randomRow, randomCol)
                        && isRightEmpty(map, randomRow, randomCol)
                        && (randomCol <= 7 ? isRightEmpty(map, randomRow, randomCol + 1) : true)
                        && (randomCol <= 7 ? isRightEmpty(map, randomRow, randomCol + 2) : true)
                        && (randomRow > 0 ? isTopEmpty(map, randomRow, randomCol) : true)
                        && (randomRow < map.length - 1 ? isBottomEmpty(map, randomRow, randomCol) : true)
                        && isDiagonalsEmpty(map, randomRow, randomCol)
                        && is2DiagonalsEmptyFor3Horizontal(map, randomRow, randomCol)) {
                    map[randomRow][randomCol] = 1;
                    map[randomRow][randomCol + 1] = 1;
                    map[randomRow][randomCol + 2] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }

    private static void fill3Vertical(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);
            int randomCol = random.nextInt(map[randomRow].length);
            isNotExists = map[randomRow][randomCol] == 1
                    && randomRow >= 2;
            if (!isNotExists) {
                if (isBottomEmpty(map, randomRow, randomCol)
                        && isTopEmpty(map, randomRow, randomCol)
                        && isTopEmpty(map, randomRow - 1, randomCol)
                        && isTopEmpty(map, randomRow - 2, randomCol)
                        && (randomCol > 0 ? isLeftEmpty(map, randomRow, randomCol) : true)
                        && (randomCol < map.length - 1 ? isRightEmpty(map, randomRow, randomCol) : true)
                        && isDiagonalsEmpty(map, randomRow, randomCol)
                        && is2DiagonalsEmptyFor3Vertical(map, randomRow, randomCol)) {
                    map[randomRow][randomCol] = 1;
                    map[randomRow - 1][randomCol] = 1;
                    map[randomRow - 2][randomCol] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }

    private static void fill4Horizontal(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);
            int randomCol = random.nextInt(map[randomRow].length - 3);
            isNotExists = map[randomRow][randomCol] == 1;
            if (!isNotExists) {
                if (isLeftEmpty(map, randomRow, randomCol)
                        && isRightEmpty(map, randomRow, randomCol)
                        && isRightEmpty(map, randomRow, randomCol + 1)
                        && isRightEmpty(map, randomRow, randomCol + 2)
                        && isRightEmpty(map, randomRow, randomCol + 3)
                        && (randomRow > 0 ? isTopEmpty(map, randomRow, randomCol) : true)
                        && (randomRow < map.length - 1 ? isBottomEmpty(map, randomRow, randomCol) : true)
                        && isDiagonalsEmpty(map, randomRow, randomCol)
                        && is2DiagonalsEmptyFor4Horizontal(map, randomRow, randomCol)) {
                    map[randomRow][randomCol] = 1;
                    map[randomRow][randomCol + 1] = 1;
                    map[randomRow][randomCol + 2] = 1;
                    map[randomRow][randomCol + 3] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }

    private static void fill4Vertical(int[][] map) {
        boolean isNotExists = true;
        while (isNotExists) {
            int randomRow = random.nextInt(map.length);
            int randomCol = random.nextInt(map[randomRow].length);
            isNotExists = map[randomRow][randomCol] == 1
                    && randomRow >= 3;
            if (!isNotExists) {
                if (isBottomEmpty(map, randomRow, randomCol)
                        && isTopEmpty(map, randomRow, randomCol)
                        && isTopEmpty(map, randomRow - 1, randomCol)
                        && isTopEmpty(map, randomRow - 2, randomCol)
                        && isTopEmpty(map, randomRow - 3, randomCol)
                        && (randomCol > 0 ? isLeftEmpty(map, randomRow, randomCol) : true)
                        && (randomCol < map.length - 1 ? isRightEmpty(map, randomRow, randomCol) : true)
                        && isDiagonalsEmpty(map, randomRow, randomCol)
                        && is2DiagonalsEmptyFor4Vertical(map, randomRow, randomCol)) {
                    map[randomRow][randomCol] = 1;
                    map[randomRow - 1][randomCol] = 1;
                    map[randomRow - 2][randomCol] = 1;
                    map[randomRow - 3][randomCol] = 1;
                } else {
                    isNotExists = true;
                }
            }
        }
    }


    private static boolean isRightEmpty(int[][] map, int row, int column) {
        if (map[row].length > column && map[column].length > (column + 1))
            return map[row][column + 1] == 0;
        return false;
    }

    private static boolean isLeftEmpty(int[][] map, int row, int column) {
        if (column > 0)
            return map[row][column - 1] == 0;
        return false;
    }

    private static boolean isTopEmpty(int[][] map, int row, int column) {
        if (row > 0)
            return map[row - 1][column] == 0;
        return false;
    }

    private static boolean isBottomEmpty(int[][] map, int row, int column) {
        if (map.length - 1 > row)
            return map[row + 1][column] == 0;
        return false;
    }

    private static boolean isDiagonalsEmpty(int[][] map, int row, int column) {
        return isNotExistsOrEmpty(map, row + 1, column - 1)
                && isNotExistsOrEmpty(map, row + 1, column + 1)
                && isNotExistsOrEmpty(map, row - 1, column + 1)
                && isNotExistsOrEmpty(map, row - 1, column - 1);
    }

    private static boolean is2DiagonalsEmptyFor3Horizontal(int[][] map, int row, int column) {
        return isNotExistsOrEmpty(map, row - 1, column + 2)
                && isNotExistsOrEmpty(map, row + 1, column + 2);
    }

    private static boolean is2DiagonalsEmptyFor3Vertical(int[][] map, int row, int column) {
        return isNotExistsOrEmpty(map, row - 2, column + 1)
                && isNotExistsOrEmpty(map, row - 2, column - 1);
    }

    private static boolean is2DiagonalsEmptyFor4Horizontal(int[][] map, int row, int column) {
        return isNotExistsOrEmpty(map, row - 1, column + 2)
                && isNotExistsOrEmpty(map, row + 1, column + 2)
                && isNotExistsOrEmpty(map, row + 1, column + 3)
                && isNotExistsOrEmpty(map, row - 1, column + 3);
    }

    private static boolean is2DiagonalsEmptyFor4Vertical(int[][] map, int row, int column) {
        return isNotExistsOrEmpty(map, row - 2, column + 1)
                && isNotExistsOrEmpty(map, row - 2, column - 1)
                && isNotExistsOrEmpty(map, row - 3, column - 1)
                && isNotExistsOrEmpty(map, row - 3, column + 1);
    }

    private static boolean isNotExistsOrEmpty(int[][] map, int row, int col) {
        if (isExists(map, row, col)) {
            return map[row][col] == 0;
        }
        return true;
    }

    private static boolean isExists(int[][] map, int row, int col) {
        return map.length > row
                && row >= 0
                && map[row].length > col
                && col >= 0;
    }
}