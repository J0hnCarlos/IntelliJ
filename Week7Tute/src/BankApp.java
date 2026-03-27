// Instructions:
// * The code in this class must not be changed. Doing so will make your work invalid.
// * Fix the compilation/syntax errors (red dots) by adding the necessary classes and their components
//   as suggested by Eclipse.
// * You must use descriptive and sensible identifier names when possible (I.e. avoid variables named i, j, string2, etc.)
// * In the classes that you create, all member variables must be private and non-static; they must also be initialised in the constructor.
// * Must use this. when referring to member variables (see examples below).
// * You must not create any more classes or their components than what's needed by BankApp class.
public class BankApp {
    private SavingsAccount person0;
    private SavingsAccount person1;

    public BankApp() {
        // A SavingsAccount object cannot be created without an ID, name and an initial balance.
        this.person0 = new SavingsAccount("AL01", "Luis Alvarez", 1.00);
        this.person1 = new SavingsAccount("BE01", "Elizabeth Blackwell", 2000.00);
        // The get... methods are accessors for various private member variables of that object
        // Their return types must match the types of the member variables being returned.
        System.out.println(person0.getBalance() + " " + person0.getID() + " " + person0.getName());
        // The withdraw method takes an amount to withdraw as its parameter.
        // Return values:
        // true when there are sufficient funds (and when the withdrawal is performed).
        // false when there are insufficient funds.
        if (this.person0.withdraw(1000))
            System.out.println("Done");
        else
            System.out.println("Insufficient funds");
        //The deposit method takes an amount to deposit as its parameter. It does not perform
        // the deposit if the value is negative.
        this.person1.deposit(1500);
        //The transfer method takes a beneficiary SavingsAccount object and an amount as its parameters
        // then transfers that amount if sufficient funds are present in the "from" account object.
        // Return values: Similar to the withdraw method above.
        if (this.person1.transfer(this.person0, 50000))
            System.out.println("Done");
        else
            System.out.println("Insufficient funds");
        System.out.println("Balance for " + this.person0.getID() + " = " + this.person0.getBalance());
        System.out.println("Balance for " + this.person1.getID() + " = " + this.person1.getBalance());
    }

    public static void main(String args[]) {
        BankApp ba = new BankApp();
    }
}