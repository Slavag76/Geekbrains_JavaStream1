package stream1.lesson7;

public class Plate {
    private int capacity;
    public int food;

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public int getCapacity() {
        return capacity;
    }

    public Plate(int capacity) {
        this.capacity = capacity;

    }

    public void addFood(int food) {
        this.food += food;

    }

    @Override
    public String toString() {
        return "Plate{" + "capacity=" + capacity + ", food=" + food + '}';
    }

    public void printInfo() {
        System.out.println(this);
    }


    public void decreaseFood(int appetite) {
        this.food -= appetite;

    }

}
