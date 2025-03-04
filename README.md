ATM Simulation Project
This is a Java-based ATM simulation application built using Servlets, JSP, and MySQL. It follows the MVC architecture and includes features like user authentication, deposit, withdrawal, balance checking, and language switching.

Prerequisites
Before running the project, ensure you have the following installed:

Java Development Kit (JDK): Version 11 or higher.

Apache Tomcat: Version 10 or higher.

MySQL: Version 8 or higher.

Maven: For dependency management.

Git: For cloning the repository.

Setup Instructions
1. Clone the Repository
Clone the project repository to your local machine:

bash
Copy
git clone https://github.com/your-username/atm-simulation.git
cd atm-simulation
2. Set Up MySQL Database
Start MySQL Server:

Ensure MySQL is running on your machine.

Create the Database:

Open MySQL shell or a MySQL client (e.g., MySQL Workbench).

Run the following SQL commands to create the database and table:

sql
Copy
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
Update Database Configuration:

Open the db.properties file in src/main/resources.

Update the database URL, username, and password:

properties
Copy
db.url=jdbc:mysql://localhost:3306/atm_db
db.user=your_mysql_username
db.password=your_mysql_password
3. Build the Project
Navigate to the Project Directory:

bash
Copy
cd atm-simulation
Build the Project Using Maven:

bash
Copy
mvn clean install
This will compile the project and package it into a .war file.

4. Deploy the Application
Copy the .war File:

Locate the generated .war file in the target directory.

Copy it to the webapps directory of your Tomcat installation.

Example:

bash
Copy
cp target/atm-simulation.war /path/to/tomcat/webapps/
Start Tomcat:

Navigate to the bin directory of your Tomcat installation.

Start Tomcat:

bash
Copy
./startup.sh  # On Linux/Mac
startup.bat    # On Windows
Access the Application:

Open your browser and go to:

Copy
http://localhost:8080/atm-simulation/
Using the Application
1. Login
Use the following credentials to log in:

Username: user1

Password: pass1

2. Features
Deposit Money: Navigate to the deposit page and enter the amount to deposit.

Withdraw Money: Navigate to the withdraw page and enter the amount to withdraw.

Check Balance: View your account balance on the balance page.

Change Language: Switch between English, Spanish, and French on the login page.

3. Logout
Click the Logout button on the dashboard to end your session.

Project Structure
Copy
atm-simulation/
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
Troubleshooting
Database Connection Issues:

Ensure MySQL is running and the db.properties file has the correct credentials.

Tomcat Deployment Issues:

Ensure Tomcat is running and the .war file is correctly placed in the webapps directory.

Empty Balance:

Verify the BalanceDAO.getBalance() method is correctly fetching the balance from the database.

Contributing
Feel free to contribute to this project by opening issues or submitting pull requests.

License
This project is licensed under the MIT License. See the LICENSE file for details.