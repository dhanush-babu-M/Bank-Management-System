package com.bankmanagementsystem.impl;

import com.bankmanagementsystem.base.Account;

public class HDFC extends Account {
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String location;

    public HDFC(long accountNumber, String accountHolderName, double balance, long phone,
                String email, String password, String status, String accountType,
                String bankName, String branchName, String ifscCode, String location) {
        super(accountNumber, accountHolderName, balance, phone, email, password, status, accountType);
        this.bankName = bankName;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.location = location;
    }

    public HDFC() {}

    @Override
    public void deposit(double amount) {
        if (amount >= 500) { // HDFC rule: min deposit 500
            setBalance(getBalance() + amount);
            System.out.println("Deposited successfully in HDFC.");
        } else {
            System.out.println("Minimum deposit is 500 in HDFC.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= 1000) { // HDFC rule: min balance 1000
            setBalance(getBalance() - amount);
            System.out.println("Withdraw successful from HDFC.");
        } else {
            System.out.println("Maintain minimum balance of 1000 in HDFC.");
        }
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }

    @Override
    public boolean login(long accountNumber, String password) {
        return accountNumber == this.getAccountNumber() && password.equals(this.getPassword());
    }

    @Override
    public void printBankDetails() {
        System.out.println("===== HDFC Bank Details =====");
        System.out.println("Bank Name     : " + bankName);
        System.out.println("Branch Name   : " + branchName);
        System.out.println("IFSC Code     : " + ifscCode);
        System.out.println("Location      : " + location);
        System.out.println("=============================");
    }

    @Override
    public void printAccountDetails() {
        System.out.println("===== HDFC Account Details =====");
        System.out.println("Account Number   : " + getAccountNumber());
        System.out.println("Holder Name      : " + getAccountHolderName());
        System.out.println("Balance          : " + getBalance());
        System.out.println("Phone            : " + getPhone());
        System.out.println("Email            : " + getEmail());
        System.out.println("Status           : " + getStatus());
        System.out.println("Account Type     : " + getAccountType());
        System.out.println("================================");
    }
}
