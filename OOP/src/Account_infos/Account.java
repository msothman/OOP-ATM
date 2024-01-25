package Account_infos;
public class Account
{
    double balance;
    private AccountType accountType;

    public Account(double balance, AccountType accountType)
    {
        this.balance = balance;
        this.accountType = accountType;
    }
    public double getBalance()
    {
        return balance;
    }
    public AccountType getAccountType()
    {
        return accountType;
    }
    public void deposit(double amount)
    {
        balance += amount;
    }
    public boolean withdraw(double amount)
    {
        if (amount > balance)
        {
            System.out.println("Insufficient balance!");
            return false;
        } else
        {
            balance -= amount;
            return true;
        }
    }
    public void displayAccountInfo()
    {
        System.out.println("Account Type: " + accountType.getType());
        System.out.println("Balance: $" + balance);
    }
}
