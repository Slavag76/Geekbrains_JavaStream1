package Lesson4ObjectsClasses;

public class Main {
    public static void main(String[] args) {

        Sotrudnik[] sotrudArray = new Sotrudnik[5];

        sotrudArray[0] = new Sotrudnik(
                "Петров Петр Петрович",
                "manager",
                "petrov@yandex.ru",
                150,
                35);

        System.out.println("Вывод первого объекта: " +"\n");
                sotrudArray[0].printSotrdnik();

        sotrudArray[1] = new Sotrudnik(
                "Иванов Иван Иванович",
                "security",
                "ivanov@yandex.ru",
                110,
                53);

        sotrudArray[2] = new Sotrudnik(
                "Дмитров Дмитрий Дмитриевич",
                "coucher",
                "dima@yandex.ru",
                180,
                30);

        sotrudArray[3] = new Sotrudnik(
                "Сидоров Сидор Сидорович",
                "security",
                "sidor@yandex.ru",
                110,
                48);

        sotrudArray[4] = new Sotrudnik(
                "Арутюнян Вазген Ашотович",
                "general manager",
                "vazgen@yandex.ru",
                250,
                50);

        System.out.println("\n" + "Сотрудники старше 40 лет: " + "\n" + "-------");

        for (int i = 0; i < sotrudArray.length; i++) {
            if (sotrudArray[i].getAge() > 40) sotrudArray[i].printSotrdnik();

        }
    }
}
