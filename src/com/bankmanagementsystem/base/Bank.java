package com.bankmanagementsystem.base;

public interface Bank {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
    boolean login(long accountNumber, String password);
    void printBankDetails();
    void printAccountDetails();

    // 🔹 Add these getters for login
    long getAccNo();           // returns account number
    String getPassword();      // returns password
    String getName();          // returns account holder name
}
