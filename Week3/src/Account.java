
public class Account {
	// Any self-contained (stand-alone) class represents a class of objects
	// where each object has the same properties. In Java classes these are
	// called instance variables
	private double balance; // balance in account
	private String accID; // Account ID
	private String accName; // Account Name

	public Account() // default constructor
	{
		balance = 0;
		accID = "DEFAULT";
		accName = "DEFAULTNAME";
	}
	
	public Account(String accountID, String accountName, double amount) 
	{
	
		accID = accountID;
		accountName = accName;
		balance = amount;
	}

	public Account(String accountID, String accountName) {
		accID = accountID;
		accName = accountName;
		balance = 10000;
	}

	// methods
	public double getBalance() { // accessor/getter method for balance
		return balance;
	}

	public String getID() { // accessor for account ID
		return accID;
	}

	public String getName() {
		return accName;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public boolean withdraw(double amount) {
		boolean result = false;
		if (balance >= amount) {
			balance = balance - amount;
			result = true;
		}
		return result;
	}

	public boolean transfer(Account account, double amount) {
		if (balance >= amount) {
			balance = balance - amount;
			account.balance = account.balance + amount;
			return true;
		} else
			return false;
	}
}
