package OOD;

/**
 * Created by apple on 23/05/2017.
 */
public class Employee {
    static double bonusRate = 0.1;
    // for final class, would not duplicate
    final String name;
    final String id;
    int age;
    int salary;
    int level;

    Employee(String name, int age, String id, int level){
        this.name = name;
        this.id = id;
        this.age = age;
        this.level = level;
    }

    void printInfo() {
        System.out.println("Name:" + "name" + "Age:" + age + "ID" + id);
    }

    void setAge(int age) {
        this.age = age;
    }

    public int calculateSalary(double performanceScore) {
        return level * 1000 + age * 500;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Shifu Li", 30, "222-22-2222",3);
        e1.printInfo();

        Employee e2 = new Employee("Shifu Lv", 29, "111-11-1111", 2);
        e2.printInfo();

        System.out.println("bonus rate:" + Employee.bonusRate);
    }
}

