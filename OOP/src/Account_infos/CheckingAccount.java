package Account_infos;
public class CheckingAccount extends Account
{
    private final double overdraftLimit;
    
    public CheckingAccount(double balance, AccountType accountType, double overdraftLimit)
    {
        super(balance, accountType);
        this.balance=balance;
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public boolean withdraw(double amount)
    {
        double availableBalance = this.balance + overdraftLimit;
        if (amount > availableBalance)
        {
            System.out.println("Insufficient balance! (including overdraft)");
            return false;
        }
        else
        {
            this.balance -= amount;
            return true;
        }
    }
}
