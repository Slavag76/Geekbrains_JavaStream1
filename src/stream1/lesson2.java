package stream1;


import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Scanner;

public class lesson2 {

    public static void main(String[] args) {

        Array_number1();
        Array_number2();
        Array_number3();
        Array_number4();
        Array_number5();
        Array_number6();
        Array_number7();
    }

    /*********Задание номер 1. Инверсия массива с 0 на 1 .********/
    private static void Array_number1() {
        Scanner valueArray = new Scanner(System.in);
        int sizeArray;
        System.out.println("Задание1. Введите размер массива:  ");
        sizeArray = valueArray.nextInt();

        int[] userArray = new int[sizeArray];
        int[] mirrorUserArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            int number = (int) (Math.random() * 2);
            userArray[i] = number;

            if (number == 0) {
                mirrorUserArray[i] = 1;
            } else {
                mirrorUserArray[i] = 0;
            }
        }
        System.out.println("Наш исходный массив: " + Arrays.toString(userArray));
        System.out.println("Зеркальный   массив: " + Arrays.toString(mirrorUserArray));
    }


    /*********Задание номер 2. Задать 0,3,...21.********/
    private static void Array_number2() {
        int[] userArray = new int[8];
        int number = 0;
        for (int i = 0; i < 8; i++) {
            userArray[i] = number;
            number += 3;
        }
        System.out.println("\nЗадание 2\nЗаполнили массив числами от 0 до 21: " + Arrays.toString(userArray));

    }

    /*********Задание номер 3. Умножение чисел меньше 6.********/
    private static void Array_number3() {
        int[] userArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\nЗадание 3. Исходный массив   " + Arrays.toString(userArray));
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] < 6)
                userArray[i] *= 2;
        }

        System.out.println("Числа меньше 6 умножили на 2 " + Arrays.toString(userArray));
    }


    /*********Задание номер 4. Диагонали в квадратной матрице.********/
    private static void Array_number4() {
        Scanner valueArray = new Scanner(System.in);
        int sizeArray;
        System.out.println("\nЗадание 4\nВведите размер квадратного двумерного массива:  ");
        sizeArray = valueArray.nextInt();

        int[][] userArray = new int[sizeArray][sizeArray];

        for (int i = 0; i < sizeArray; i++) {
            for (int j = 0; j < sizeArray; j++) {
                if (i == j) {
                    userArray[i][j] = 1;
                }

                userArray[i][sizeArray - i - 1] = 1;
                System.out.print(userArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /*********Задание номер 5. Максимальный и минимальный элементы.********/
    private static void Array_number5() {
        Scanner valueArray = new Scanner(System.in);
        int sizeArray;
        System.out.println("\nЗадание 5.\nВведите размер массива мы его заполним случайными числами:  ");
        sizeArray = valueArray.nextInt();
        int[] userArray = new int[sizeArray];

        for (int i = 0; i < sizeArray; i++) {
            int number = (int) (Math.random() * sizeArray);
            userArray[i] = number;
        }

        int min = sizeArray;
        int max = 0;

        for (int i = 0; i < sizeArray; i++) {
            if (userArray[i] < min)
                min = userArray[i];

            if (userArray[i] > max)
                max = userArray[i];
        }

        System.out.println("Исходный массив:  " + Arrays.toString(userArray));
        System.out.println("Минимальное значение:  " + min);
        System.out.println("Максимальное значение: " + max);
    }


    /*********Задание номер 6. суммы двух частей массива.********/
    private static void Array_number6() {
        Scanner valueArray = new Scanner(System.in);
        int sizeArray;
        int summ1 = 0;
        int summ2 = 0;
        System.out.println("\nЗадание 6.\nВведите размер массива мы его заполним случайными числами\nлучше указывать не больше 5, иначе шанс попасть по суммам будет небольшой");
        sizeArray = valueArray.nextInt();
        int[] userArray = new int[sizeArray];


        for (int i = 0; i < sizeArray; i++) {
            int number = (int) (Math.random() * sizeArray);
            userArray[i] = number;
        }

        System.out.println("Исходный массив:  " + Arrays.toString(userArray));

        for (int i = 0; i < sizeArray; i++) {
            summ1 = summ1 + userArray[i];
            summ2 = 0;
            for (int j = i + 1; j < sizeArray; j++) {
                summ2 = userArray[j] + summ2;
            }

            System.out.println("Пары сумм: " + summ1 + " " + summ2);

            if (summ1 == summ2) {
                System.out.println("Бинго! Первые " + (i + 1) + " Элементов равны остальным " + (sizeArray - i - 1));
            } else {
                System.out.println("Равных сумм нет");
            }
        }

    }


    /*********Задание номер 7. Сдвинуть элементы массива.********/
    private static void Array_number7() {
        ArrayList<Integer> userArray = new ArrayList<>();
        Scanner valueArray = new Scanner(System.in);
        int sizeArray, sizeMove;
        System.out.println("\nЗадание 7.\nВведите размер массива:  ");
        sizeArray = valueArray.nextInt();

//        Заполняем массив числами от 0 до sizeArray
        for (int i = 0; i < sizeArray; i++) {
            userArray.add(i);
        }
        System.out.println("Ваш массив: " + userArray);

        System.out.println("Введите число, на сколько позиций сдвинем массив: от 0 до " + sizeArray);
        sizeMove = valueArray.nextInt();

        for (int i = 0; i < (sizeArray - sizeMove); i++) {
            //      Добавляем в конец массива элементы из начала массива на количество sizeMove
            userArray.add(sizeArray + i, userArray.get(i));
        }


        for (int i = 0; i < (sizeArray - sizeMove); i++) {
            //            Зачищаем "хвост", удаляем первые элементы массива в количестве sizeMove
            userArray.remove(0);
        }

        System.out.println("Массив после сдвига: " + userArray);
    }


}