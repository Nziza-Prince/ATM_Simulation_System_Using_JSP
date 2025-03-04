# ATM Simulation Project

This is a Java-based ATM simulation application built using **Servlets**, **JSP**, and **MySQL**. It follows the **MVC architecture** and includes features like user authentication, deposit, withdrawal, balance checking, and language switching.

---

## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 11 or higher.
2. **Apache Tomcat**: Version 10 or higher.
3. **MySQL**: Version 8 or higher.
4. **Maven**: For dependency management.
5. **Git**: For cloning the repository.

---

## 2.Setup Instructions

### 1. Clone the Repository
Clone the project repository to your local machine:

```bash
git clone https://github.com/Nziza-Prince/ATM_Simulation_System_Using_JSP.git
cd ATM_Simulation_System_Using_JSP
```
## 2. Set Up MySQL Database

### 1.Start MySQL Server:
1.Ensure MySQL is running on your machine.

### 2.Create the Database:

Open MySQL shell or a MySQL client (e.g., MySQL Workbench).
Run the following SQL commands to create the database and table:

```bash
CREATE DATABASE atm_db;
USE atm_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    balance DECIMAL(10, 2) DEFAULT 0.00
);

INSERT INTO users (username, password, balance) VALUES
('user1', 'pass1', 1000.00),
('user2', 'pass2', 500.00);
```

### 3.Update Database Configuration:

Open the db.properties file in src/main/resources.
Update the database URL, username, and password:

```bash
db.url=jdbc:mysql://localhost:3306/atm_db
db.user=your_mysql_username
db.password=your_mysql_password
```
---
## 3. Build the Project


### 1.Navigate to the Project Directory:

```bash
cd ATM_Simulation_System_Using_JSP
```

### 2.Build the Project Using Maven:x

```bash
mvn clean install
```

This will compile the project and package it into a .war file.

---

## 4. Deploy the Application

### 1.Copy the .war File:

Locate the generated .war file in the target directory.
Copy it to the webapps directory of your Tomcat installation.

Example:

```bash
cp target/ATM_Simulation_System_Using_JSP.war /path/to/tomcat/webapps/
```

### 2.Start Tomcat:

Navigate to the bin directory of your Tomcat installation.
Start Tomcat:

```bash

./startup.sh  # On Linux/Mac
startup.bat    # On Windows
```

### 3.Access the Application:
Open your browser and go to:


http://localhost:8080/ATM_Simulation_System_Using_JSP/

---
## Using the Application


### 1. Login

Use the following credentials to log in:

    Username: user1
    Password: pass1


### 2. Features:
1. **Deposit Money** : Navigate to the deposit page and enter the amount to deposit.

2. **Withdraw Money**: Navigate to the withdraw page and enter the amount to withdraw.

3.**Check Balance**: View your account balance on the balance page.

4.**Change Language**: Switch between English, Spanish, and French on the login page.

### 3. Logout
Click the Logout button on the dashboard to end your session.

---
## Project Structure
```bash
ATM_Simulation_System_Using_JSP/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/atm/
│   │   │       ├── controller/  # Servlets (Controller)
│   │   │       ├── dao/         # Data Access Objects (DAO)
│   │   │       ├── model/       # Model Classes
│   │   │       └── util/        # Utility Classes
│   │   ├── resources/           # Configuration Files
│   │   └── webapp/              # JSP Files and Static Resources
│   └── test/                    # Unit Tests
├── pom.xml                      # Maven Configuration
└── README.md                    # Project Documentation
```
---
### Troubleshooting

1.**Database Connection Issues**:
Ensure MySQL is running and the db.properties file has the correct credentials.

2.**Tomcat Deployment Issues**:
Ensure Tomcat is running and the .war file is correctly placed in the webapps directory.

3.**Empty Balance**:
Verify the BalanceDAO.getBalance() method is correctly fetching the balance from the database.
---
## Contributing
Feel free to contribute to this project by opening issues or submitting pull requests.
---
## License
This project is licensed under the MIT License. See the LICENSE file for details.

Copy

---

### **How to Use This**
1. Copy the above Markdown content.
2. Open your `README.md` file in your project.
3. Replace the existing content with the copied Markdown content.
4. Save the file and commit it to your repository:

   ```bash
   git add README.md
   git commit -m "Updated README with proper formatting"
   git push origin main
   ```

---