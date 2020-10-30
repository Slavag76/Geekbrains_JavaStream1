package stream1.lesson6;

public class Animal {

    public int run_distance;
    public int swim_distance;
    public int jump_distance;
    public String typeAnimal;
    public int maxRun;
    public int maxSwim;
    public float maxJump;

    public Animal(int run_distance, int swim_distance, int jump_distance, String typeAnimal, int maxRun, int maxSwim, float maxJump) {
        this.run_distance = run_distance;
        this.swim_distance = swim_distance;
        this.jump_distance = jump_distance;
        this.typeAnimal = typeAnimal;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }



    public boolean runrun(int run_distance) {
        if (run_distance < maxRun) {
            return true;
        } else {
            return false;
        }
    }

    public boolean swimswim(int swim_distance) {
        if (swim_distance < maxSwim) {
            return true;
        } else {
            return false;
        }
    }

    public boolean jumpjump(int jump_distance) {
        if (jump_distance < maxJump) {
            return true;
        } else {
            return false;
        }
    }

}
