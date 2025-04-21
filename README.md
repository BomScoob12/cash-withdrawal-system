# ATM Withdrawal Simulator

This is a Java-based simulation of an ATM cash dispenser. The program allows a user to input an amount to withdraw and returns the number of banknotes dispensed in various denominations based on predefined availability.

## Features

- Handles multiple banknote denominations (1000, 500, 100, 50, 20)
- Validates banknote availability before dispensing
- Displays remaining amount if withdrawal can't be completed exactly
- Uses `LinkedHashMap` to maintain banknote order
- Simple, console-based user interaction

## Technologies Used

- Java (JDK 8+)
- Standard Java libraries

## How to Run

1. Clone the repository: ``git clone https://github.com/your-username/atm-withdrawal-simulator.git``
2. Compile and run: ``javac Main.java && java com.bomscoob.Main``
