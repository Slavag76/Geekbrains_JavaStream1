//Домашнее задание 1. Все входные данные для методов вводятся с клавиатуры.

package stream1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nСейчас мы вычислим целое значение вычисления функции  a * (b + (c / d)) ");
        System.out.println("Результат вычисления метода: " + calculateABC());

        System.out.println("\nСейчас мы проверим итог суммы чисел в пределах от 10 до 20");
        System.out.println("Результат вычисления метода: " + isTrueFalse());

        System.out.println("\nСейчас мы проверим число - положительное или отрицательное");
        System.out.println(checkNegative());

        System.out.println("\nА сейчас я с тобой поздороваюсь :) ");
        System.out.println("Привет, " + printHelloName() +"!");

        System.out.println("\nПроверим год на високосность");
        System.out.println("Этот год:  " + checkVisokos());


    }

    static int calculateABC() {
        Scanner value = new Scanner(System.in);
        int a, b, c, d;
        System.out.println("Enter int a: ");
        a = value.nextInt();
        System.out.println("Enter int b: ");
        b = value.nextInt();
        System.out.println("Enter int c: ");
        c = value.nextInt();
        System.out.println("Enter int d: ");
        d = value.nextInt();

        return (int) ( a * (b +  (1.0 * c / d)));
    }

    static boolean isTrueFalse() {
        Scanner number = new Scanner(System.in);
        int first, second, result;
        boolean isTrue = true;
        System.out.println("Enter first number: ");
        first = number.nextInt();
        System.out.println("Enter second number: ");
        second = number.nextInt();

        result = first + second;

        if (result >= 10 && result <= 20){
            return isTrue = true;
        } else {
            return isTrue = false;
        }
    }

    static String checkNegative() {
        Scanner param = new Scanner(System.in);
        int n;
        String checked;
        System.out.println("Введите число");
        n = param.nextInt();
        if (n < 0) {
            checked = "это отрицательное число";
        } else {
            checked = "это положительное число";
        }

        return checked;
    }

    static String printHelloName() {
        System.out.println("Enter you name: ");
        Scanner stringName = new Scanner(System.in);
        String name;
        name = stringName.nextLine();
        return name;
    }

    static String checkVisokos() {
        Scanner year = new Scanner(System.in);
        System.out.println("Введите год: ");
        int userYear;
        String visokos = "";
        userYear = year.nextInt();

        if  ((((userYear % 4) == 0) &&  ((userYear % 100) != 0)) || ((userYear % 400) == 0)){
            visokos = "високосный";

        } else {
            visokos = "не високосный";
        }

        return visokos;
    }


}
