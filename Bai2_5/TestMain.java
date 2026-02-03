package Bai2_5;
public class TestMain {
    public static void main(String[] args) {
        Customer c1 = new Customer(88, "Tan Ah Teck",  (char) 10);

        Account a1 = new Account(101, c1, 888.8);
        System.out.println(a1);

        a1.deposit(111.2);
        System.out.println(a1);

        a1.withdraw(200.0);
        System.out.println(a1);

        a1.withdraw(2000.0);
        System.out.println(a1);

        System.out.println("Customer name: " + a1.getCustomerName());
    }
}