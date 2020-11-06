package stream1.lesson7;

public class Cat {


    private String name;
    private int appetite;
    private boolean puzo;

    //если кот ни разу не поел, значит он голоден (false). Если хотя бы раз, то сыт (true)
    private int count = 0;

    public int getAppetite() {
        return appetite;
    }

    public Cat(String name, int appetite) {
        this.appetite = appetite;
        this.name = name;
    }

    public void eat(Plate plate) {

        if (plate.getFood() < appetite) {

            //если КОНКРЕТНОМУ коту не хватает еды, он об этом сообщает, но другому коту еды может хватить
            if (count != 1 ) {
                puzo = false;
                System.out.println(name + " А мне не хватило еды, сытость " + puzo + "\n");
            }
        } else {
            doEat(plate);
            puzo = true;
            System.out.println("Кот " + name + " питается, сытость =  " + puzo + "\n");
            count = 1;

        }

    }

    private void doEat(Plate plate) {
        plate.decreaseFood(appetite);

    }


}
