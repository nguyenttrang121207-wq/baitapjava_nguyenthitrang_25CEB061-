package Bai4_2;

public class Testmain {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St");
        System.out.println(person);

        Student student = new Student("Jane Smith", "456 Elm St", "Computer Science", 2, 15000.0);
        System.out.println(student);

        Staff staff = new Staff("Emily Johnson", "789 Oak St", "High School", 50000.0);
        System.out.println(staff);

    }
}
