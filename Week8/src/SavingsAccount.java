public class SavingsAccount {
    private String id, name;
    private double initialBalance;

    public SavingsAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.initialBalance = balance;
    }

    public double getBalance() {
        return this.initialBalance;
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean withdraw(double withdrawMoney) {
        boolean checker;
        if (initialBalance < withdrawMoney) {
            checker = false;
        } else {
            checker = true;
            initialBalance = initialBalance - withdrawMoney;
        }
        return checker;
    }

    public void deposit(double money) {
        if (money > 0) {
            this.initialBalance = this.initialBalance + money;
        }
    }

    public boolean transfer(SavingsAccount person0, double amount) {
        boolean check;
        if (amount > initialBalance) {
            check = false;
        } else {
            check = true;
            person0.initialBalance = person0.initialBalance + amount;
            this.initialBalance = this.initialBalance - amount;
        }

        return check;
    }
}
