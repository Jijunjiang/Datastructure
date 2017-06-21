package OOD;

/**
 * Created by apple on 23/05/2017.
 */
public class main {
    public static void main(String[] agrs) {
        Employee e = new Employee("Aaron");
        e.setCompany("Apple");
        e.setName("Aaron");
        System.out.println(e.getName());
        String name = e.getName();
        System.out.println(name);
        String company = e.getCompany();
        System.out.println(company);
    }
}
