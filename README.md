# 🏦 Bank Management System

A console-based banking application built with Java to demonstrate **Object-Oriented Programming (OOP)** and **SOLID** design principles. The system simulates core banking operations across multiple banks like **SBI, ICICI, and HDFC**.

---

## 🌟 Key Features

* **Multi-Bank Support** – Create and manage accounts in three banks (SBI, ICICI, HDFC).
* **Secure Authentication** – Login using a unique **Account Number & Password**.
* **Core Banking Operations**

  * 💰 **Deposit** – Add funds with instant balance update.
  * 💸 **Withdraw** – Withdraw only in denominations (₹500, ₹1000, ₹2000) with validation.
  * ✅ **Check Balance** – View your real-time account balance.
* **Account & Bank Information**

  * Access detailed **bank info** (Branch, IFSC, Location).
  * View **personal account details** (Holder Info, Contact, Balance).
* **Additional Services** – Placeholder to apply for a **Credit Card**.
* **Admin Feature** – View an **account summary**: number of accounts in each bank.

---

## 🛠️ Tech Stack

* **Language**: Java
* **Concepts**: OOP, SOLID Principles

---

## 📂 Project Structure

```
com.bankmanagementsystem
│
├── base
│   ├── Bank.java       // Interface for bank operations
│   └── Account.java    // Abstract class for account properties
│
├── impl
│   ├── SBI.java        // SBI Implementation
│   ├── ICICI.java      // ICICI Implementation
│   └── HDFC.java       // HDFC Implementation
│
└── runner
    └── BankManagementSystem.java  // Main class with CLI menu
```

---

## 🚀 Getting Started

### Prerequisites

* Java Development Kit (JDK) 8 or higher

### Run Locally

```sh
# Clone repository
git clone https://github.com/your-username/BankManagementSystem.git

# Navigate to source
cd BankManagementSystem/src

# Compile
javac com/bankmanagementsystem/runner/BankManagementSystem.java

# Run
java com.bankmanagementsystem.runner.BankManagementSystem
```

---

## 🧠 Core Concepts Demonstrated

### Object-Oriented Programming (OOP)

* **Abstraction** – `Bank` interface & `Account` abstract class hide implementation details.
* **Encapsulation** – Private fields with getters & setters ensure data integrity.
* **Inheritance** – `SBI`, `ICICI`, `HDFC` extend `Account`.
* **Polymorphism** – Each bank overrides `deposit()`, `withdraw()` etc.

### SOLID Principles

* **S – Single Responsibility** – Each class has one responsibility (e.g., `Account` = data, `SBI` = SBI logic).
* **O – Open/Closed** – New banks can be added without modifying existing code.
* **L – Liskov Substitution** – Subclasses (`SBI`, `ICICI`, `HDFC`) can replace their parent type (`Bank` or `Account`).
* **I – Interface Segregation** – `Bank` interface contains only essential banking methods.
* **D – Dependency Inversion** – The main runner depends on the **`Bank` interface (abstraction)**, not specific implementations.

---

## 📌 Note

This project is for **learning purposes**, showcasing practical application of Java **OOP & SOLID principles** in a real-world inspired system.

---
