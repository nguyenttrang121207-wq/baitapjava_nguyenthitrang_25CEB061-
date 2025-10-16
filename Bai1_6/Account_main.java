package Bai1_6;

public class Account_main {
        public static void main(String[] args) {
            Account a1 = new Account("A101", "Tan Ah Teck", 88);
            Account a2 = new Account("A102", "Kumar");
            System.out.println(a1);
            System.out.println(a2);
            System.out.println("ID: " + a1.getID());
            System.out.println("Name: " + a1.getName());
            System.out.println("Balance: " + a1.getBalance());
            a1.credit(100);
            System.out.println(a1);
            a1.debit(50);
            System.out.println(a1);
            a1.debit(200);
            System.out.println(a1);
            a1.debit(100);
            System.out.println(a1);
            a2.credit(100);
            System.out.println(a2);
        }
    }
