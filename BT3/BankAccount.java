package BT3;

public abstract class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
}
