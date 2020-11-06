package stream1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class lesson3 {

    static Scanner userAnswer = new Scanner(System.in);

    public static void main(String[] args) {

        Task1();
        Task2();

    }


    public static void Task1() {
        while (true) {

            System.out.println("Вам надо угадать число от 1 до 9");
            int randomComputer = (int) (Math.random() * 10);
            System.out.println("Для целей проверки кода, подсказка: компьютер загадал  " + randomComputer);


            for (int i = 0; i < 3; i++) {
                System.out.println("Введите число:  ");
                int answer = userAnswer.nextInt();

                if (randomComputer == answer) {
                    System.out.println("Поздравляю, Вы угадали!  ");
                    break;
                } else if (answer < randomComputer) {
                    System.out.println("Загаданное число больше, попробуйте еще раз");
                } else if (answer > randomComputer) {
                    System.out.println("Загаданное число меньше, попробуйте еще раз");
                }

            }

            System.out.println("Попыток больше нет.\nСыграем еще раз? Введите 0 - нет, 1 - да ");
            int doAction = userAnswer.nextInt();
            if (doAction == 0) break;
        }


    }


//****************************Задание номер 2. *********************************

    public static void Task2() {

        /*Вывод на экран исходного массива*/
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(words));
        System.out.println("Вам надо угадать одно из слов: " + arrayList);


        /*Определение случайно загаданного слова компьютером*/
        int randomComputer = (int) (Math.random() * words.length);
        System.out.println("Для целей проверки кода, подсказка: компьютер загадал\n  " + words[randomComputer]);


        /*Определение самого длинного слова в массиве. На будущее, в случае изменений условий игры.*/
        int maxLengthWord = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > maxLengthWord) maxLengthWord = words[i].length();
        }
        System.out.println("Длина самого большого слова в массиве: " + maxLengthWord + " символов (для справки)");


        System.out.println("Длина загаданного слова: " + words[randomComputer].length() + " символов\n(но Вы этого не знаете)");


        while (true) {
            System.out.println("Введите слово");
            String answer = userAnswer.next();
            if (answer.contains(words[randomComputer])) {
                System.out.println("Вы угадали!");
                break;
            }

/*            Определяем длину цикла для сравнения слов.
            Длина цикла = меньшему из слов, загаданному и введеному пользователем*/
            int lenghtIF;
            if (answer.length() < words[randomComputer].length()) {
                lenghtIF = answer.length();
            } else if (answer.length() > words[randomComputer].length()) {
                lenghtIF = words[randomComputer].length();
            } else {
                lenghtIF = answer.length();
            }

            /* Инициирование символьного массива, в него будем записывать угаданные буквы и символы ### */
            char[] answerWord = new char[maxLengthWord];

            /*Сравниваем посимвольно оба слова. Длина цикла = меньшему слову.*/
            for (int i = 0; i < lenghtIF; i++) {
                if (answer.charAt(i) == words[randomComputer].charAt(i)) {
                    answerWord[i] = words[randomComputer].charAt(i);
                } else {
                    answerWord[i] = '#';
                }

            }
            System.out.println("Угаданные Вами буквы: ");
            /*Перевод символьного массива в строчный для конкатенации с символами ####*/
            String newStringAnswer = new String(answerWord);
            System.out.println(newStringAnswer + "#####");

            System.out.println("Введите 1 для продолжения игры, 0 - для выхода из игры");
            int doAction = userAnswer.nextInt();
            if (doAction == 0) break;
        }

        System.out.println("Игра окончена");

    }
}


