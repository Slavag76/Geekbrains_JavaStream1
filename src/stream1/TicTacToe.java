/**
 * Порядок выполнения:
 * 1. main() -> initMap() - инициализация массива
 * -------------------------------------------
 * 2. main() -> printMap() - печать массива
 * 3. printMap() -> printMapHeader() - печать впервой строки вывода
 * 4. printMap() -> printMapRows() - печать остальной части массива
 * -------------------------------------------
 * 5. main() -> playGame() - запуск игры. 2 части: человек и машина
 * * -------------------------------------------
 * 6. playGame() -> humanTurn() - ввод числа в терминал
 * 7. humanTurn -> isCellValid - проверка на валидность введенного числа
 * 8. playGame() -> printMap (см п.3-4)
 * * -------------------------------------------
 * 9. playGame() -> checkEnd() - проверка на завершение
 * 10. checkEnd -> checkWin() - проверка на победу
 * 11. checkEnd -> isMapFull() - проверка на ничью
 * * -------------------------------------------
 * 12. п.6-11, но с aiTurn, вместо humanTurn
 * * -------------------------------------------
 * 13. повторение п.6-12
 */

/** 10. checkEnd -> checkWin() - проверка на победу*
 * В данном задании доработан метод checkWin
 * написаны методы проверки вертикалей, горизонталей, всех диагоналей
 * при любом размере массива.
 */






package stream1;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 7;


    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final String HEADER_FIRST_EMPTY = "♥";
    static final String EMPTY = " ";


    static char[][] map = new char[SIZE][SIZE];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        turnGame();

    }

    private static void turnGame() {
        initMap();
        printMap();
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapRow();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_EMPTY + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printMapRow() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }


    private static void playGame() {

        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);


            aiTurn();
            printMap();
            checkEnd(DOT_AI);
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод человека! Введите номер строки и столбца!");
        do {
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Столбец = ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_HUMAN;
    }

    private static boolean isCellValid(int rowNumber, int colNumber, boolean isAI) {

        if (!isAI && ((rowNumber < 1) || (rowNumber > SIZE) || (colNumber < 1) || (colNumber > SIZE))) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        }

        if (map[rowNumber - 1][colNumber - 1] != DOT_EMPTY) {
            if (!isAI) {
                System.out.println("\nВы выбрали занятую ячейку");
            }
            return false;
        }

        return true;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        return isCellValid(rowNumber, colNumber, false);
    }

    private static void checkEnd(char symbol) {

        boolean isEnd = false;

        if (checkWin(symbol)) {
            String winMessage;

            if (symbol == DOT_HUMAN) {
                winMessage = "УРА! Вы победили!";
            } else {
                winMessage = "Восстание близко! AI победил";
            }

            isEnd = true;
            System.out.println(winMessage);
        }

        if (!isEnd && isMapFull()) {
            System.out.println("Ничья!");
            isEnd = true;
        }

        if (isEnd) {
            System.exit(0);
        }
    }

    private static boolean checkWin(char symbol) {


        if (chekHorizontal(symbol)) return true;

        if (chekVertical(symbol)) return true;

        if (checkDiagonal_big(symbol)) return true;

        if (chekDiagonal_small(symbol)) return true;

        return false;
    }

    private static boolean chekDiagonal_small(char symbol) {
        int p= -1;
        for (int z = SIZE-2; z>1; z--) {
            int l = 1;
            p++;
            for (int i = 0; i < z ; i++) {

                if (map[i][i + p + 1] == symbol && map[i + 1][i + p + 2] == symbol) l++;

                if (map[i][z-i] == symbol && map[i + 1][z-i-1] == symbol) l++;

                if (map[SIZE-i-1][i+1+p] == symbol && map[SIZE-i-2][i+2+p] == symbol) l++;

                if (map[SIZE-i-1][z-i] == symbol && map[SIZE-i-2][z-i-1] == symbol) l++;

                if (l == 3) return true;

            }

        }
        return false;
    }

    private static boolean checkDiagonal_big(char symbol) {
        int m = 1;
        for (int i = 0; i < SIZE - 1; i++) {
            if (map[i][i] == symbol && map[i + 1][i + 1] == symbol) m++;

            if (map[i][SIZE - 1 - i] == symbol && map[i + 1][SIZE - i - 2] == symbol) m++;

            if (m == 3) return true;
        }
        return false;
    }

    private static boolean chekVertical(char symbol) {
        for (int j = 0; j < SIZE; j++) {
            int k = 1;
            for (int i = 0; i < SIZE - 1; i++) {
                if (map[i][j] == symbol && map[i + 1][j] == symbol) k++;
                if (k == 3) return true;

            }

        }
        return false;
    }

    private static boolean chekHorizontal(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int k = 1;
            for (int j = 0; j < SIZE - 1; j++) {
                if (map[i][j] == symbol && map[i][j + 1] == symbol) k++;
                if (k == 3) return true;

            }

        }
        return false;
    }

    private static boolean isMapFull() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void aiTurn() {
        int rowNumber;
        int colNumber;
        System.out.println("\nХод компьютера!\n");
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber, true));

        map[rowNumber - 1][colNumber - 1] = DOT_AI;
    }

}
