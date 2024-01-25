package App;

import Account_infos.*;
import Customer.Customer;
import Login.Login;
import java.util.Scanner;

public class Main
{
    private static Account checkingAccount = new CheckingAccount(1000, new AccountType("Checking Account"), 500);
    private static Account savingsAccount = new SavingsAccount(1000, new AccountType("Savings Account"));
    public static void main(String[] args)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            
            // Create a customer
            Customer customer = new Customer("admin", "admin");
            // Perform login
            if (Login.performLogin(customer, scanner))
            {
                // Display menu and perform banking operations
                Account currentAccount = chooseAccountType(scanner);
                displayMenu();
                performBankingOperations(customer, currentAccount, scanner);
            }
            else
            {
                System.out.println("Exiting the ATM system. Thank you for using Toro's Services!");
            }
        }
        catch (Exception e)
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    private static Account chooseAccountType(Scanner scanner)
    {
        while (true)
        {
            try
            {
                System.out.println("Select your account type:");
                System.out.println("1. Checking Account");
                System.out.println("2. Savings Account");

                int choice = scanner.nextInt();
                
                if (choice == 1)
                {
                    return checkingAccount;
                }
                else if (choice == 2)
                {
                    return savingsAccount;
                }
                else
                {
                    System.out.println("Invalid choice. Defaulting to Checking Account.");
                    return checkingAccount;
                }
            }
            catch (Exception e)
            {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void displayMenu()
    {
        System.out.println("\nBanking System Menu:");
        System.out.println("1. Switch Account");
        System.out.println("2. Display Account Information");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void performBankingOperations(Customer customer, Account currentAccount, Scanner scanner)
    {
        while (true)
        {
            try
            {
                int choice = scanner.nextInt();

                switch (choice)
                {
                    case 1:
                        currentAccount = switchAccount(currentAccount, scanner);
                        break;
                    case 2:
                        displayAccountInfo(customer, currentAccount);
                        break;
                    case 3:
                        deposit(customer, currentAccount, scanner);
                        break;
                    case 4:
                        withdraw(customer, currentAccount, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting the banking system. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

                displayMenu();
            }
            catch (Exception e)
            {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static Account switchAccount(Account currentAccount, Scanner scanner)
    {
        try
        {
            // Switch between Checking and Savings accounts
            if (currentAccount instanceof CheckingAccount)
            {
                System.out.println("Switched to Savings Account.");
                return chooseAccountType(scanner);
            }
            else if (currentAccount instanceof SavingsAccount)
            {
                System.out.println("Switched to Checking Account.");
                return chooseAccountType(scanner);
            }
            return currentAccount;
        }
        catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
            return currentAccount;
        }
    }

    private static void displayAccountInfo(Customer customer, Account currentAccount)
    {
        System.out.println("Customer: " + customer.getUsername());
        currentAccount.displayAccountInfo();
    }

    private static void deposit(Customer customer, Account currentAccount, Scanner scanner)
    {
        try
        {
            System.out.print("Enter the deposit amount: $");
            double depositAmount = scanner.nextDouble();
            currentAccount.deposit(depositAmount);
            System.out.println("Deposit successful!");
            displayAccountInfo(customer, currentAccount);
        }
        catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void withdraw(Customer customer, Account currentAccount, Scanner scanner)
    {
        try
        {
            System.out.print("Enter the withdrawal amount: $");
            double withdrawAmount = scanner.nextDouble();
            if (currentAccount.withdraw(withdrawAmount)) {
                System.out.println("Withdrawal successful!");
                displayAccountInfo(customer, currentAccount);
            }
        }
        catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
            scanner.nextLine();
        }
    }
}
