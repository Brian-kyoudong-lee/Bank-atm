package coe528.project;

import java.util.Vector;

/**
 *
 * @author Brian
 */
public class Customer {
    //OVERVIEW: Customers are mutable class, different Strings,
    //different doubles, and instantiation of Customerlevel
    private String username;
    private String password;
    private String level;
    private double fee;
    private double balance;
    private Customerlevel customerlevel;
    //constructors
    //REQUIRES: username, password, level, balance
    //MODIFIES: username, password, level, balance
    //EFFECTS: Sets new values to username, password, level, balance
    public Customer(String u, String p, String level, double b)
    {
        this.setCustomer(u, p, level, b);
    }
    //methods
    //MODIFIES: fee
    //EFFECTS: if balance is less than 10000 level is silver and fee is 50,
    //if balance is greater or equal to 10000 but less than 20000
    //level is gold and fee is 10, if balance is greater or equal
    //to 20000 than level is platinum and there is no fee
    public void level()
    {
        this.fee = customerlevel.level();
    }
    //REQUIRES: username, password, level, balance
    //MODIFIES: username, password, level, balance
    //EFFECTS: Sets new values to username, password, level, balance
    public void setCustomer(String u, String p, String level, double b)
    {
        this.username = u;
        this.password = p;
        this.balance = b;
        if(balance < 10000)
            customerlevel = new silver();
        else if(10000 <= balance && balance < 20000)
            customerlevel = new gold();
        else
            customerlevel = new platinum();
    }
    //REQUIRES: balance
    //MODIFIES: balance
    //EFFECTS: Sets new value to balance
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    //EFFECTS: returns level
    public String getLevel()
    {
        return level;
    }
    //EFFECTS: returns fee
    public double getFee()
    {
        return fee;
    }
    //EFFECTS: returns balance
    public double getBalance()
    {
        return balance;
    }
    //EFFECTS: returns username
    public String getuser()
    {
        return username;
    }
    //EFFECTS: returns password
    public String getpw()
    {
        return password;
    }
    //EFFECTS: returns all information
    public String toString()
    {
        if(repOk() == true)
            return ("Username: " + getuser() + "\n Password: " + getpw()
                    + "\nBalance: " + getBalance() + "\nlevel: " + getLevel());
        else
            return "does not exist";
    }
    //rep invariant
    //if(username == null)
    //    return false;
    //if(password == null)
    //    return false;
    private boolean repOk() {
        if(username == null)
            return false;
        if(password == null)
            return false;
        return true;
    }
}
