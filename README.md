# 💳 Digital Financial Hub

A full-fledged desktop banking simulation system built using **Java Swing**, integrated with **MySQL** via **JDBC**, designed to provide essential banking operations like signup, login, deposits, withdrawals, transfers, PIN change, and more — all through a user-friendly GUI.

---

## 🚀 Key Features

- 🔐 **Secure Login & Signup Flow**
  - Multi-step signup with forms (`Signup`, `SignupTwo`, `SignupThree`)
  - System-generated **User ID & PIN**
  - Secure login with ID and PIN validation (`Login.java`)

- 💼 **Banking Operations**
  - **Deposit**: Add money to account (`Deposit.java`)
  - **Withdraw**: Cash withdrawal with balance check (`Withdrawl.java`)
  - **Balance Enquiry**: View available balance (`BalanceEnquiry.java`)
  - **Mini Statement**: View last transactions (`MiniStatement.java`)
  - **Fast Cash**: Quick fixed-amount withdrawals (`FastCash.java`)
  - **Fund Transfer**: Transfer funds between accounts (`Transfer.java`, `Maintranfer.java`)
  - **PIN Change**: Update ATM PIN securely (`PinChange.java`)

- 🧩 **Backend Integration**
  - MySQL database (`bankmanegementsystem.sql`)
  - JDBC connection handler (`Conn.java`)
  - Transaction management (`Trans.java`)

- 🎨 **Graphical User Interface**
  - Built using `Java Swing` with event-driven logic in `NewJFrame.java`

---

## 🧰 Technologies Used

| Tool           | Purpose                         |
|----------------|----------------------------------|
| Java           | Core logic & business rules      |
| Java Swing     | GUI framework                    |
| MySQL          | Backend relational database      |
| JDBC           | Java–Database connector          |

---



   
