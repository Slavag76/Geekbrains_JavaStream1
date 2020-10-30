package stream1.lesson6;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {



        Animal cat = new Cat(10, 20, 1, "Кот", 200, 0, 2);
        Animal dog = new Dog(300, 5, 20, "Собака", 500, 10, 0.5f);


        Animal[] animals = {cat, dog};

        for (Animal pets : animals) {
            System.out.println(pets.typeAnimal + " " + pets.runrun(pets.run_distance));
            System.out.println(pets.typeAnimal + " " + pets.swimswim(pets.swim_distance));
            System.out.println(pets.typeAnimal + " " + pets.jumpjump(pets.jump_distance));

        }
    }
}