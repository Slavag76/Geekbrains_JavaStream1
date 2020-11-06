package Lesson4ObjectsClasses;

public class Sotrudnik {

    protected String f_i_o;
    protected String position;
    protected String email;
    protected int salary;
    protected int age;

    public Sotrudnik(String f_i_o, String position, String email, int salary, int age) {
        this.f_i_o = f_i_o;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    public void printSotrdnik(){
        System.out.println(f_i_o + "\n" + position + "\n" + email + "\n" + "Salary: " + salary + "\n" + "Age: " + age + "\n" + "*****************************" );
    }

    public int getAge() {
        return age;
    }
}
