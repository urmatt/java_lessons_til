package arrays;

import java.util.Scanner;

public class XOWinner {
    enum GameState {
        X_WINS,
        O_WINS,
        GAME_NOT_STARTED,
        GAME_NOT_ENDED,
        NO_WINNER
    }

    public static void main(String[] args) {
        String xo[][] = new String[3][3];
        print2DArray(xo);
        String currentGamer = "0";
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            int rowIndex = 0;
            int colIndex = 0;
            println(ConsoleColors.YELLOW_BOLD_BRIGHT +  "Ход игрока: " + currentGamer);
            println(ConsoleColors.CYAN_BOLD_BRIGHT + "Укажите индекс строки и столбца: ");
            String str = scanner.nextLine();
            boolean isOk = str.matches("[0-2],[0-2]");
            if (isOk) {
                rowIndex = Integer.parseInt(str.substring(0, 1));
                colIndex = Integer.parseInt(str.substring(2, 3));
                if (xo[colIndex][rowIndex] == null || xo[colIndex][rowIndex].isEmpty()) {
                    xo[colIndex][rowIndex] = currentGamer;
                    if (currentGamer.equals("X"))
                        currentGamer = "0";
                    else
                        currentGamer = "X";
                } else {
                    println(ConsoleColors.RED_BOLD_BRIGHT + "Значение уже задано в данной ячейке");
                }


                GameState gameState = check2DArrayForWinner(xo);
                if (gameState == GameState.X_WINS || gameState == GameState.O_WINS) {
                    // boolean ? true->A : false->B
                    String winner = (gameState == GameState.X_WINS) ? "X" : "0";

                    System.out.println("Выиграл: " + winner);
                    gameOver = isGameOver(scanner);
                    if (!gameOver) {
                        xo = new String[3][3];
                    }
                } else if (is2DArrayFull(xo) && gameState == GameState.NO_WINNER) {
                    xo = new String[3][3];
                    System.out.println("Новая игра:");
                }
                print2DArray(xo);
            } else {
                System.err.println("Значение задано в неверном формате");
            }
        }
    }

    private static void println(String string){
        System.out.println(string + ConsoleColors.RESET);
    }

    private static void print(String string){
        System.out.print(string + ConsoleColors.RESET);
    }

    // Как тернарный оператор работает
    private static String ternary(boolean bool, String a, String b) {
        if (bool) return a;
        else return b;
    }

    private static boolean isGameOver(Scanner scanner) {
        println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Хотите продолжить? yes or no");
        String answer = scanner.nextLine();
        if (answer.equals("yes")) {
            println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Новая игра:");
            return false;
        } else
            return true;
    }

    private static boolean is2DArrayFull(String[][] array) {
        for (String[] row : array) {
            for (String val : row) {
                if (isEmptyOrNull(val))
                    return false;
            }
        }
        return true;
    }

    private static GameState check2DArrayForWinner(String[][] game) {
        for (String[] row : game) {
            GameState rowState = checkWinner(row);
            if (rowState == GameState.O_WINS || rowState == GameState.X_WINS) {
                return rowState;
            }
        }

        for (int i = 0; i < 3; i++) {
            String[] column = {
                    game[0][i],
                    game[1][i],
                    game[2][i],
            };
            GameState colState = checkWinner(column);
            if (colState == GameState.O_WINS || colState == GameState.X_WINS) {
                return colState;
            }
        }

        String[] aDiagonal = {
                game[0][0],
                game[1][1],
                game[2][2],
        };
        GameState aDioState = checkWinner(aDiagonal);
        if (aDioState == GameState.O_WINS || aDioState == GameState.X_WINS) {
            return aDioState;
        }

        String[] bDiagonal = {
                game[2][0],
                game[1][1],
                game[0][2],
        };
        GameState bDioState = checkWinner(bDiagonal);
        if (bDioState == GameState.O_WINS || bDioState == GameState.X_WINS) {
            return bDioState;
        }

        return GameState.NO_WINNER;
    }

    private static void print2DArray(String[][] array) {
        println(ConsoleColors.PURPLE_BOLD_BRIGHT + " -------------");
        for (String[] subArray : array) {
            print(ConsoleColors.PURPLE_BOLD_BRIGHT + " | ");
            for (String value : subArray) {
                if (value == null || value.isEmpty())
                    print(ConsoleColors.PURPLE_BOLD_BRIGHT + "  | ");
                else if(value.equals("X"))
                    print(ConsoleColors.YELLOW_BOLD_BRIGHT + value + ConsoleColors.PURPLE_BOLD_BRIGHT + " | ");
                else if(value.equals("0"))
                    print(ConsoleColors.RED_BOLD_BRIGHT + value + ConsoleColors.PURPLE_BOLD_BRIGHT + " | ");
            }
            System.out.println();
        }
        println(ConsoleColors.PURPLE_BOLD_BRIGHT + " -------------");
    }

    private static GameState checkWinner(String[] array) {
        if (getWinner(array) != null) {
            if (getWinner(array).toUpperCase().equals("X"))
                return GameState.X_WINS;
            if (getWinner(array).equals("0"))
                return GameState.O_WINS;
        } else {
            if (isEmpty(array)) {
                return GameState.GAME_NOT_STARTED;
            } else if (hasEmpty(array)) {
                return GameState.GAME_NOT_ENDED;
            } else
                return GameState.NO_WINNER;
        }
        return GameState.GAME_NOT_STARTED;
    }

    /**
     * Проверяет все ли ячейки равны друг к другу
     *
     * @param array
     * @return Если все равны то общее значение или null
     */
    private static String getWinner(String[] array) {
        if (isEquals(array[0], array[1]) && isEquals(array[1], array[2]))
            return array[0];
        return null;
    }

    /**
     * Проверяет заполнены ли все ячейки массива
     *
     * @param row массив из String
     * @return boolean - true если хотя бы одна пустая и false если все заполнены
     */
    private static boolean isEmpty(String[] row) {
        return isEmptyOrNull(row[0]) && isEmptyOrNull(row[1]) && isEmptyOrNull(row[2]);
    }

    private static boolean isEmptyOrNull(String val) {
        return val == null || val.isEmpty();
    }

    private static boolean isEquals(String a, String b) {
        if (!isEmptyOrNull(a) && !isEmptyOrNull(b)) {
            return a.equals(b);
        }
        return false;
    }

    /**
     * Проверяет имеет ли массив хотя бы одну пустую ячейку
     *
     * @param row
     * @return
     */
    private static boolean hasEmpty(String[] row) {
        return isEmptyOrNull(row[0]) || isEmptyOrNull(row[1]) || isEmptyOrNull(row[2]);
    }
}
