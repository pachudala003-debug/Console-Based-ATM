package miniProject;

import java.util.Scanner;

public class ATMApp {
    public void start() {
        Scanner sc = new Scanner(System.in);

        User user = new User("1111-2222-3333", "1234", 5000.0, "9999999999");
        ATMFunctions atm = new SimpleATM(user);

        System.out.println("Welcome to Simple ATM!");

        while (true) { 
            int attempts = 0;
            boolean authenticated = false;

           
            while (attempts < 3) {
                System.out.print("Enter your PIN (" + (3 - attempts) + " attempts left): ");
                String pin = sc.next();
                if (atm.verifyPIN(pin)) {
                    authenticated = true;
                    break;
                } else {
                    System.out.println("Wrong PIN.");
                    attempts++;
                }
            }

            
            if (!authenticated) {
                System.out.println("\nYou entered the wrong PIN 3 times!");
                System.out.println("Forgot your PIN? Reset using your registered phone number.");
                System.out.print("Enter your registered phone number: ");
                String enteredPhone = sc.next();

                if (enteredPhone.equals(user.getPhoneNumber())) {
                    System.out.print("Phone verified! Enter your new PIN: ");
                    String newPIN = sc.next();
                    atm.changePIN(newPIN);
                    System.out.println("Your PIN has been reset successfully.\nPlease login again.");
                    continue; 
                } else {
                    System.out.println("Incorrect phone number. Card blocked.");
                    return;
                }
            }

           
            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Change PIN");
                System.out.println("5. View Transaction History");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> atm.checkBalance();
                    case 2 -> {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        atm.deposit(amt);
                    }
                    case 3 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        atm.withdraw(amt);
                    }
                    case 4 -> {
                        System.out.print("Enter new PIN: ");
                        String newPIN = sc.next();
                        atm.changePIN(newPIN);
                    }
                    case 5 -> atm.viewTransactionHistory();
                    case 6 -> {
                        System.out.println("Thank you! Visit again.");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }
}
