package miniProject;

public class User {
    private String cardNumber;
    private String pin;
    private double balance;
    private String phoneNumber;
    private String[] transactions = new String[10];
    private int index = 0;

    public User(String cardNumber, String pin, double balance, String phoneNumber) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
    }

    public String getCardNumber() { return cardNumber; }
    public String getPin() { return pin; }
    public double getBalance() { return balance; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setPin(String pin) { this.pin = pin; }
    public void setBalance(double balance) { this.balance = balance; }

    public void addTransaction(String txn) {
        if (index < transactions.length) {
            transactions[index++] = txn;
        } else {
            for (int i = 1; i < transactions.length; i++) {
                transactions[i - 1] = transactions[i];
            }
            transactions[transactions.length - 1] = txn;
        }
    }

    public String[] getTransactions() {
        return transactions;
    }
}
