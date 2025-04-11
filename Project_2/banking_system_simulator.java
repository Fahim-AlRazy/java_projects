/*Java Basics Mastery Problem Banking System Simulator
This problem is more advanced and structured than the Student Management System,
 covering all essential Java concepts in a practical, real-world scenario.

Problem Statement
Create a Banking System Simulator that allows users to:
Create an account (Name, Account Number, Balance).
Deposit money into an account.
Withdraw money from an account (with insufficient balance check).
Transfer money between accounts.
View account details.
Save transactions to a file and load them on restart.
 **/

public class banking_system_simulator {
    public static void main(String[] args) {
System.out.println("hello");
    }
}

/*// Chat GPT Solution 
 * import java.io.*;
import java.util.*;

class BankAccount {
    String name;
    int accountNo;
    double balance;

    BankAccount(String name, int accountNo, double balance) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    void displayDetails() {
        System.out.println("Account No: " + accountNo + " | Name: " + name + " | Balance: $" + balance);
    }

    public String toString() {
        return accountNo + ", " + name + ", " + balance;
    }
}

 * 
 * 
 * class BankingSystem {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static final String FILE_NAME = "bank_accounts.txt";

    // Create a new account
    static void createAccount(String name, int accountNo, double balance) {
        accounts.add(new BankAccount(name, accountNo, balance));
        System.out.println("Account created successfully!");
    }

    // Search for an account by number
    static BankAccount getAccount(int accountNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNo == accountNo) {
                return acc;
            }
        }
        return null;
    }

    // Transfer money between accounts
    static void transferMoney(int fromAcc, int toAcc, double amount) {
        BankAccount sender = getAccount(fromAcc);
        BankAccount receiver = getAccount(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (amount > 0 && sender.balance >= amount) {
            sender.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Save accounts to file
    static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (BankAccount acc : accounts) {
                writer.write(acc.toString());
                writer.newLine();
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // Load accounts from file
    static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                accounts.add(new BankAccount(parts[1], Integer.parseInt(parts[0]), Double.parseDouble(parts[2])));
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFromFile();

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. View Account");
            System.out.println("6. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    createAccount(name, accNo, balance);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depAmt = sc.nextDouble();
                    BankAccount depAccount = getAccount(depAcc);
                    if (depAccount != null) depAccount.deposit(depAmt);
                    else System.out.println("Account not found.");
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withAcc = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withAmt = sc.nextDouble();
                    BankAccount withAccount = getAccount(withAcc);
                    if (withAccount != null) withAccount.withdraw(withAmt);
                    else System.out.println("Account not found.");
                    break;

                case 4:
                    System.out.print("Enter Sender Account Number: ");
                    int senderAcc = sc.nextInt();
                    System.out.print("Enter Receiver Account Number: ");
                    int receiverAcc = sc.nextInt();
                    System.out.print("Enter Amount to Transfer: ");
                    double transAmt = sc.nextDouble();
                    transferMoney(senderAcc, receiverAcc, transAmt);
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int viewAcc = sc.nextInt();
                    BankAccount acc = getAccount(viewAcc);
                    if (acc != null) acc.displayDetails();
                    else System.out.println("Account not found.");
                    break;

                case 6:
                    saveToFile();
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

 * 
 * 
 * 
 * 
 */
