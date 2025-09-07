package com.bankmanagementsystem.base;

public abstract class Account implements Bank {
    private long accountNumber;
    private String accountHolderName;
    private double balance;
    private long phone;
    private String email;
    private String password;
    private String status;
    private String accountType;

    // Constructor
    public Account(long accountNumber, String accountHolderName, double balance,
                   long phone, String email, String password,
                   String status, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.status = status;
        this.accountType = accountType;
    }

    // Default constructor
    public Account() {}

    // Original getters and setters
    public long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(long accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) { this.accountHolderName = accountHolderName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public long getPhone() { return phone; }
    public void setPhone(long phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    // 🔹 Implement getters required by Bank interface for login
    @Override
    public long getAccNo() {
        return getAccountNumber();
    }

    @Override
    public String getName() {
        return getAccountHolderName();
    }
}
