package Bai1_4;

public class Employeemain {
        public static void main(String[] args) {
            Employee emp1 = new Employee(8, "Peter", "Tan", 2500);
            System.out.println(emp1);
            emp1.setSalary(999);
            System.out.println(emp1);
            System.out.println("id is: " + emp1.getId());
            System.out.println("firstname is: " + emp1.getFirstName());
            System.out.println("lastname is: " + emp1.getLastName());
            System.out.println("salary is: " + emp1.getSalary());
            System.out.println("name is: " + emp1.getName());
            System.out.println("annual salary is: " + emp1.getAnnualSalary());
            int newSalary = emp1.raiseSalary(10);
            System.out.println(newSalary);
            System.out.println(emp1);
        }
    }

