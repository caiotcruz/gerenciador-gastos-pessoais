📊 Personal Expense Manager

A simple and efficient desktop system for personal finance management, built in Java.
This project serves as a portfolio piece, showcasing skills in Java development, layered software architecture, and local data persistence.

✨ Features

Full CRUD for Transactions
Add, list, update, and delete incomes and expenses.

Local Data Persistence (JSON)
All data is stored in JSON files, with no external database required.

Command Line Interface (CLI)
Fully functional console interface for using and testing the core logic.

Graphical User Interface (JavaFX) – In development
A modern and intuitive user interface for easier interaction.

Reports & Export – Planned

Monthly and category-based reports

Export data to Excel (.xlsx)

Data Visualization – Planned
Charts to analyze expense distribution over time.

🛠️ Technologies

Java 21

Apache Maven (dependency management)

Google Gson (JSON handling)

JavaFX (GUI – in development)

Git & GitHub (version control)

🚀 Running the Project
Requirements

JDK 21 or higher installed

Apache Maven configured in your system environment variables

Steps
# Clone the repository
git clone https://github.com/caiotcruz/personal-expense-manager.git

# Navigate to project directory
cd personal-expense-manager

# Compile the project
mvn clean compile

# Run the console version
mvn exec:java

🏛️ Project Structure
src/main/java/
├── Main.java          # Application entry point (CLI)
├── model/             # Data classes (POJOs) - e.g. Lancamento
├── repository/        # Data access layer (JSON)
├── service/           # Business logic (planned)
├── ui/                # JavaFX user interface (in development)
└── util/              # Utility classes (e.g. JsonHelper)

👨‍💻 Author

Caio T. Cruz

LinkedIn: https://www.linkedin.com/in/caio-teixeira-da-cruz

📧 Email: caiotcruz@gmail.com

📄 License

This project is licensed under the MIT License. See the LICENSE file for details.