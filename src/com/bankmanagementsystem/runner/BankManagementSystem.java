package com.bankmanagementsystem.runner;

import com.bankmanagementsystem.impl.SBI;
import com.bankmanagementsystem.impl.ICICI;
import com.bankmanagementsystem.impl.HDFC;
import com.bankmanagementsystem.base.Bank;

import java.util.*;

public class BankManagementSystem {
    private static List<Bank> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int mainChoice;
        do {
            System.out.println("\n===== Welcome to Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Account Summary by Bank");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> accountSummary();
                case 4 -> System.out.println("Thank you for using Bank Management System!");
                default -> System.out.println("Invalid choice.");
            }
        } while (mainChoice != 4);
    }

    // 🔹 Create new account
    private static void createAccount() {
        System.out.println("\nChoose Bank:");
        System.out.println("1. SBI");
        System.out.println("2. ICICI");
        System.out.println("3. HDFC");
        int bankChoice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Phone: ");
        long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Status (Active/Inactive): ");
        String status = sc.nextLine();

        System.out.print("Enter Account Type (Savings/Current): ");
        String accountType = sc.nextLine();

        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();

        System.out.print("Enter IFSC Code: ");
        String ifsc = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        Bank account = switch (bankChoice) {
            case 1 -> new SBI(accNo, name, balance, phone, email, password, status, accountType,
                    "SBI Bank", branchName, ifsc, location);
            case 2 -> new ICICI(accNo, name, balance, phone, email, password, status, accountType,
                    "ICICI Bank", branchName, ifsc, location);
            case 3 -> new HDFC(accNo, name, balance, phone, email, password, status, accountType,
                    "HDFC Bank", branchName, ifsc, location);
            default -> {
                System.out.println("Invalid bank choice.");
                yield null;
            }
        };

        if (account != null) {
            accounts.add(account);
            System.out.println("✅ Account created successfully!");
        }
    }

    // 🔹 Login method
    private static void login() {
        System.out.print("\nEnter Account Number: ");
        long accNo = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Bank loggedAccount = null;
        for (Bank account : accounts) {
            if (account.getAccNo() == accNo && account.getPassword().equals(password)) {
                loggedAccount = account;
                break;
            }
        }

        if (loggedAccount != null) {
            System.out.println("✅ Login Successful! Welcome " + loggedAccount.getName());
            accountMenu(loggedAccount);
        } else {
            System.out.println("❌ Invalid Account Number or Password.");
        }
    }

    // 🔹 After-login menu
    private static void accountMenu(Bank account) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Account Menu ---");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Bank Details");
            System.out.println("5. Account Details");
            System.out.println("6. Apply for Credit Card");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    account.deposit(amount);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    account.withdraw(amount);
                }
                case 3 -> {
                    double balance = account.checkBalance();
                    System.out.printf("✅ Current Balance: ₹%.2f\n", balance);
                }
                case 4 -> account.printBankDetails();
                case 5 -> account.printAccountDetails();
                case 6 -> System.out.println("✅ Credit Card application submitted successfully!");
                case 7 -> {
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    // 🔹 Account Summary by Bank
    private static void accountSummary() {
        int sbiCount = 0, iciciCount = 0, hdfcCount = 0;

        for (Bank account : accounts) {
            if (account instanceof SBI) sbiCount++;
            else if (account instanceof ICICI) iciciCount++;
            else if (account instanceof HDFC) hdfcCount++;
        }

        System.out.println("\n===== Account Summary =====");
        System.out.println("SBI Accounts   : " + sbiCount);
        System.out.println("ICICI Accounts : " + iciciCount);
        System.out.println("HDFC Accounts  : " + hdfcCount);
        System.out.println("============================");
    }
}
