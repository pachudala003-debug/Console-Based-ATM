package miniProject;

public class SimpleATM extends BaseATM {
    public SimpleATM(User user) {
        super(user);
    }

    @Override
    public boolean verifyPIN(String enteredPIN) {
        return user.getPin().equals(enteredPIN);
    }

    @Override
    public void checkBalance() {
        System.out.println("Balance: " + user.getBalance());
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            user.setBalance(user.getBalance() + amount);
            user.addTransaction("Deposited " + amount);
            System.out.println("Deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= user.getBalance()) {
            user.setBalance(user.getBalance() - amount);
            user.addTransaction("Withdrew " + amount);
            System.out.println("Withdrew " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    @Override
    public void changePIN(String newPin) {
        user.setPin(newPin);
        user.addTransaction("PIN Changed");
        System.out.println("PIN successfully changed.");
    }

    @Override
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String txn : user.getTransactions()) {
            if (txn != null) {
                System.out.println("- " + txn);
            }
        }
    }
}
