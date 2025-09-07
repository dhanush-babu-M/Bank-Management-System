package com.bankmanagementsystem.impl;

import com.bankmanagementsystem.base.Account;

public class SBI extends Account {
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String location;

    // Parameterized constructor
    public SBI(long accountNumber, String accountHolderName, double balance, long phone,
               String email, String password, String status, String accountType,
               String bankName, String branchName, String ifscCode, String location) {
        super(accountNumber, accountHolderName, balance, phone, email, password, status, accountType);
        this.bankName = bankName;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.location = location;
    }

    // Default constructor
    public SBI() {}

    // Getters and Setters
    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getIfscCode() { return ifscCode; }
    public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    // 🔹 Implement methods from Bank interface
    @Override
    public void deposit(double amount) {
        if (amount > 0 && amount % 100 == 0) { // SBI rule: multiples of 100
            setBalance(getBalance() + amount);
            System.out.println("Deposited successfully in SBI.");
        } else {
            System.out.println("Invalid amount. Enter multiples of 100.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount % 100 == 0) {
            if (getBalance() >= amount) {
                setBalance(getBalance() - amount);
                System.out.println("Withdraw successful from SBI.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Amount must be a multiple of 100.");
        }
    }

    @Override
    public double checkBalance() {
        // Ensure it always returns the current balance
        return getBalance();
    }

    @Override
    public boolean login(long accountNumber, String password) {
        return accountNumber == getAccountNumber() && password.equals(getPassword());
    }

    @Override
    public void printBankDetails() {
        System.out.println("===== SBI Bank Details =====");
        System.out.println("Bank Name   : " + bankName);
        System.out.println("Branch Name : " + branchName);
        System.out.println("IFSC Code   : " + ifscCode);
        System.out.println("Location    : " + location);
        System.out.println("============================");
    }

    @Override
    public void printAccountDetails() {
        System.out.println("===== SBI Account Details =====");
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Holder Name    : " + getAccountHolderName());
        System.out.printf("Balance        : ₹%.2f\n", getBalance());
        System.out.println("Phone          : " + getPhone());
        System.out.println("Email          : " + getEmail());
        System.out.println("Status         : " + getStatus());
        System.out.println("Account Type   : " + getAccountType());
        System.out.println("================================");
    }
}
