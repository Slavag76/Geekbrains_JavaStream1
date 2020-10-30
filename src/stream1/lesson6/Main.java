package stream1.lesson6;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Animal cat = new Cat(10, 20, 1, "Кот", 200, 0, 2);
        Animal dog = new Dog(300, 5, 20, "Собака", 500, 10, 0.5f);
        Animal dog1 = new Dog(20,20,20,"Другая собака", 10, 10, 30 );

        Animal[] animals = {cat, dog, dog1};

        for (Animal pets : animals) {
            System.out.println(pets.typeAnimal + " " + pets.runrun(pets.run_distance) + "\n");
            System.out.println(pets.typeAnimal + " " + pets.swimswim(pets.swim_distance) + "\n");
            System.out.println(pets.typeAnimal + " " + pets.jumpjump(pets.jump_distance) + "\n");

        }
    }
}