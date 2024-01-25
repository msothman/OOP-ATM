package Login;

import Customer.*;
import java.util.Scanner;

public class Login
{
    private static final int maxAttempts = 3;

    public static boolean performLogin(Customer customer, Scanner scanner)
    {
        int attempts = 0;

        while (attempts < maxAttempts)
        {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.next();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.next();

            if (customer.getUsername().equals(enteredUsername) && customer.isValidPassword(enteredPassword))
            {
                System.out.println("Login successful!");
                return true;
            }
            else
            {
                System.out.println("Invalid username or password. Please try again.");
                attempts++;
            }
        }
        System.out.println("Exceeded maximum login attempts. Exiting the ATM system. Thank you for using Toro's services!");
        return false;
    }
}
