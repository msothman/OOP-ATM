package Customer;

import Account_infos.*;
public class Customer
{
    private String username;
    private String password;
    private AccountType accountType;

    public Customer(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isValidPassword(String enteredPassword)
    {
        return password.equals(enteredPassword);
    }

    public void setAccountType(AccountType accountType)
    {
        this.accountType = accountType;
    }
    public AccountType getAccountType()
    {
        return accountType;
    }
}
