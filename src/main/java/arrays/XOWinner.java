package arrays;

import javax.sound.midi.Soundbank;
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
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            int rowIndex = 0;
            System.out.println("Укажите индекс строки:");
            String rowInStr = scanner.nextLine();
            rowIndex = Integer.parseInt(rowInStr);


            int colIndex = 0;
            System.out.println("Укажите индекс сторлбца:");
            String colInStr = scanner.nextLine();
            colIndex = Integer.parseInt(colInStr);

            System.out.println("Задайте значение:");
            String value = scanner.nextLine();
            xo[colIndex][rowIndex] = value;
            GameState gameState = check2DArrayForWinner(xo);
            if (gameState == GameState.X_WINS) {
                System.out.println("Выиграл: X");
                gameOver = true;
            } else if (gameState == GameState.O_WINS) {
                System.out.println("Выиграл: O");
                gameOver = true;
            }
            print2DArray(xo);
        }
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

        String[] aDioganal = {
                game[0][0],
                game[1][1],
                game[2][2],
        };
        GameState aDioState = checkWinner(aDioganal);
        if (aDioState == GameState.O_WINS || aDioState == GameState.X_WINS) {
            return aDioState;
        }

        String[] bDioganal = {
                game[2][0],
                game[1][1],
                game[0][2],
        };
        GameState bDioState = checkWinner(bDioganal);
        if (bDioState == GameState.O_WINS || bDioState == GameState.X_WINS) {
            return bDioState;
        }

        return GameState.NO_WINNER;
    }

    private static void print2DArray(String[][] array) {
        System.out.println("  -----------");
        for (String[] subArray : array) {
            System.out.print(" | ");
            for (String value : subArray) {
                if (value == null || value.isEmpty())
                    System.out.print("  | ");
                else
                    System.out.print(value + " | ");
            }
            System.out.println();
        }
        System.out.println("  -----------");
    }

    private static GameState checkWinner(String[] array) {
        if (getWinner(array) != null) {
            if (getWinner(array).equals("X"))
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
