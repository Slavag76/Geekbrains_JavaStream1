package stream1.lesson7;

import java.util.Scanner;

public class MainDZ_7 {

    public static void main(String[] args) {

        Scanner userAnswer = new Scanner(System.in);
        Scanner userAnswer_food = new Scanner(System.in);
        Scanner userAnswer_capacity = new Scanner(System.in);

        System.out.println("Введите размер тарелки");
        int capacity = userAnswer_capacity.nextInt();



        Cat[] catArray = new Cat[3];

        //суммарное значение аппетитов всех котов, чтобы определить количество подходов к тарелке
        int porog = 0;


        catArray[0] = new Cat("Борис Николаевич", 4);
        catArray[1] = new Cat("Барсик", 3);
        catArray[2] = new Cat("Васька", 5);
        Plate plate = new Plate(capacity);

        while (true) {
            int food = getFood(userAnswer_food);
            plate.addFood(food);
            plate.printInfo();
            start_cat_eating(catArray, porog, plate);
            plate.printInfo();
            askAgain(userAnswer, plate);

        }

    }

    //************************************************************************

    public static int getFood(Scanner userAnswer_food) {
        System.out.println("Насыпьте в тарелку еду (не больше размера тарелки)");
        return userAnswer_food.nextInt();
    }

    public static void askAgain(Scanner userAnswer, Plate plate) {
        System.out.println("Подсыпать еще еды котикам? Введите 1 если да или 0 если нет\n");
        if (userAnswer.nextInt() != 1)
            System.exit(0);
    }



    //Коты по очереди начинают делать подходы к терелкам
    public static void start_cat_eating(Cat[] catArray, int porog, Plate plate) {
        for (int i = 0; i < catArray.length; i++) {
            porog = porog + catArray[i].getAppetite();
        }

//        Определяем размер цикла - количество подходов котов к терелкам
//                коты должны есть, пока в тарелке не будет мало еды для любого кота
          int numbereat = (plate.getFood() / porog);
        for (int j = 0; j <= numbereat + 1; j++) {
            for (int i = 0; i < catArray.length; i++) {
                catArray[i].eat(plate);

            }
        }

    }
}
