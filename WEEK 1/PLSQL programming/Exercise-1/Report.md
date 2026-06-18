# Exercise 1: Control Structures - Week 1

## Problem Statement

### Scenario 1
The bank wants to apply a discount to loan interest rates for customers above 60 years old.

**Question:** Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

### Scenario 2
A customer can be promoted to VIP status based on their balance.

**Question:** Write a PL/SQL block that iterates through all customers and sets a flag `IsVIP` to TRUE for those with a balance over $10,000.

### Scenario 3
The bank wants to send reminders to customers whose loans are due within the next 30 days.

**Question:** Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

---

# Schema Overview

The schema consists of the following tables:

- Customers
- Accounts
- Transactions
- Loans
- Employees

For Scenario 2, an additional column `IsVIP VARCHAR2(5)` is added to the Customers table. Oracle SQL tables do not support BOOLEAN columns directly, so TRUE/FALSE values are stored as strings.

---

# Scenario 1: Loan Interest Rate Discount for Senior Citizens

## Description

A cursor loop iterates through all customers.

For each customer:

- Age is calculated using the Date of Birth.
- If age is greater than 60 years:
  - All associated loans receive a 1% reduction in interest rate.
- Otherwise no changes are made.

## Control Structure Used

- FOR LOOP
- IF-THEN-ELSE

## Expected Output

```text
No discount for: John Doe (Age: 40)
No discount for: Jane Smith (Age: 35)
Discount applied for: Ram Prasad (Age: 75) | Loans updated: 1
Discount applied for: Meera Joshi (Age: 77) | Loans updated: 1

--- Scenario 1 complete ---
```

---

# Scenario 2: VIP Flag Based on Balance

## Description

A cursor loop processes all customers.

For each customer:

- If balance is greater than 10000:
  - IsVIP is set to TRUE.
- Otherwise:
  - IsVIP is set to FALSE.

The customer record is then updated.

## Control Structure Used

- FOR LOOP
- IF-THEN-ELSE

## Expected Output

```text
John Doe | Balance: 1000 | IsVIP: FALSE
Jane Smith | Balance: 15000 | IsVIP: TRUE
Ram Prasad | Balance: 5000 | IsVIP: FALSE
Meera Joshi | Balance: 12000 | IsVIP: TRUE

--- Scenario 2 complete ---
```

---

# Scenario 3: Loan Due Reminders

## Description

The PL/SQL block fetches all loans whose due date falls within the next 30 days.

For each matching loan, a reminder message is displayed showing:

- Customer Name
- Loan ID
- Amount Due
- Due Date
- Remaining Days

## Control Structure Used

- FOR LOOP

## Expected Output

```text
REMINDER >> Customer: John Doe | Loan ID: 1 | Amount Due: 5000 | Days Left: 10
REMINDER >> Customer: Meera Joshi | Loan ID: 3 | Amount Due: 3000 | Days Left: 25

--- Scenario 3 complete ---
```

---

# Execution Steps

1. Open Oracle SQL Developer / Oracle Live SQL.
2. Run `schema_and_data.sql`.
3. Run `scenario1_loan_discount.sql`.
4. Run `scenario2_vip_flag.sql`.
5. Run `scenario3_loan_reminders.sql`.

---

# Outputs

## 1. Schema Creation Output

Screenshot:

![Schema Output](screenshots/schema_output.png)

---

## 2. Scenario 1 Output

Screenshot:

![Scenario 1 Output](screenshots/scenario1_output.png)

---

## 3. Scenario 2 Output

Screenshot:

![Scenario 2 Output](screenshots/scenario2_output.png)

---

## 4. Scenario 3 Output

Screenshot:

![Scenario 3 Output](screenshots/scenario3_output.png)

---

# Files Included

```text
Week1_Exercise1/
│
├── schema_and_data.sql
├── scenario1_loan_discount.sql
├── scenario2_vip_flag.sql
├── scenario3_loan_reminders.sql
├── README.md
└── screenshots/
    ├── schema_output.png
    ├── scenario1_output.png
    ├── scenario2_output.png
    └── scenario3_output.png
```

---

# Conclusion

This exercise demonstrates the use of PL/SQL control structures such as FOR loops and IF-THEN-ELSE statements to process banking data. The solution performs interest rate updates for senior citizens, identifies VIP customers based on account balance, and generates reminders for loans nearing their due dates.