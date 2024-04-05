//THE INTITAL BALANCE ,PIN OF THE USER ARE PREDEFINED AND GIVEN FROM OWNER OF THE PROGRAMAND CANNOT BE CHANGED ONCE PROGRAM IS DONE 
//                                       ATM INTERFACE 

import java.util.Scanner;

public class task2 {
    private static Scanner scanner = new Scanner(System.in);
    private static int balance = 100000;
    private static StringBuilder transactionHistory = new StringBuilder();

    public static void main(String[] args) {
        int pin = 12345;
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("enter your pin to proceed");
        int checkpin = scanner.nextInt();
        if (checkpin == pin) {
            while (true) {
                System.out.println("");
                System.out.println("Choose 1 for Withdraw");
                System.out.println("Choose 2 for Deposit");
                System.out.println("Choose 3 for Check Balance");
                System.out.println("Choose 4 for Transaction History");
                System.out.println("Choose 5 for Transfer");
                System.out.println("Choose 6 for EXIT");
                System.out.print("Choose the operation you want to perform:");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        withdraw();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        displayTransactionHistory();
                        break;
                    case 5:
                        transfer();
                        break;
                    case 6:
                        System.out.println("Exiting...and thank you using ATM");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("the entered pin is incorrect please try again");
        }
    }

    private static void withdraw() {
        System.out.print("Enter amount to be withdrawn:");
        int withdrawAmount = scanner.nextInt();
        if (withdrawAmount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }
        balance -= withdrawAmount;
        transactionHistory.append("Withdrawal: -").append(withdrawAmount).append("\n");
        System.out.println("Please collect your money");
    }

    private static void deposit() {
        System.out.print("Enter amount to be deposited:");
        int depositAmount = scanner.nextInt();
        balance += depositAmount;
        transactionHistory.append("Deposit: +").append(depositAmount).append("\n");
        System.out.println("Your money has been successfully deposited");
    }

    private static void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    private static void displayTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);
    }

    private static void transfer() {
        System.out.print("Enter recipient's account number:");
        String recipientAccount = scanner.next();
        System.out.print("Enter amount to transfer:");
        int transferAmount = scanner.nextInt();
        if (transferAmount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }
        balance -= transferAmount;
        transactionHistory.append("Transfer: -").append(transferAmount).append("\n");
        System.out.println("Transfer successful to account: " + recipientAccount);
    }
}
