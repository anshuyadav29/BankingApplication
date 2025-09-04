import java.util.Scanner;

class Account {
    int accountNumber;
    String accountHolderName;
    double balance;
    String email;
    String phoneNumber;

    // constructor
    public Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful. New Balance: " + balance);
        } else {
            System.out.println("Amount must be positive!");
        }
    }

    // withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance = balance - amount;
                System.out.println("Withdrawal successful. New Balance: " + balance);
            } else {
                System.out.println("Not enough balance!");
            }
        } else {
            System.out.println("Amount must be positive!");
        }
    }

    // show account details
    public void displayAccountDetails() {
        System.out.println("----- Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    // update email and phone
    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated successfully!");
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Account[] accounts = new Account[100]; // can store 100 accounts
    static int accountCount = 0;
    static int nextAccountNumber = 1001; // starting account number

    // create new account
    public static void createAccount() {
        System.out.print("Enter account holder name: ");
        sc.nextLine(); // eat leftover newline
        String name = sc.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double balance = sc.nextDouble();

        System.out.print("Enter email address: ");
        String email = sc.next();

        System.out.print("Enter phone number: ");
        String phone = sc.next();

        accounts[accountCount] = new Account(nextAccountNumber, name, balance, email, phone);
        System.out.println("Account created successfully with Account Number: " + nextAccountNumber);

        accountCount++;
        nextAccountNumber++;
    }

    // find account by number
    public static Account findAccount(int accNum) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].accountNumber == accNum) {
                return accounts[i];
            }
        }
        return null; // not found
    }

    // deposit
    public static void performDeposit() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        Account acc = findAccount(accNum);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // withdraw
    public static void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        Account acc = findAccount(accNum);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account not found!");
        }
    }

    // show details
    public static void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        Account acc = findAccount(accNum);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    // update contact
    public static void updateContact() {
        System.out.print("Enter account number: ");
        int accNum = sc.nextInt();
        Account acc = findAccount(accNum);
        if (acc != null) {
            System.out.print("Enter new email: ");
            String email = sc.next();
            System.out.print("Enter new phone number: ");
            String phone = sc.next();
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found!");
        }
    }

    // menu
    public static void mainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {
                createAccount();
            } else if (choice == 2) {
                performDeposit();
            } else if (choice == 3) {
                performWithdrawal();
            } else if (choice == 4) {
                showAccountDetails();
            } else if (choice == 5) {
                updateContact();
            } else if (choice == 6) {
                System.out.println("Thank you for using Banking Application!");
            } else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    public static void main(String[] args) {
        mainMenu();
    }
}