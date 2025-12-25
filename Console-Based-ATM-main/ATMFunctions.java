package miniProject;

public interface ATMFunctions {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
    void changePIN(String newPin);
    void viewTransactionHistory();
	boolean verifyPIN(String pin);
	
}

