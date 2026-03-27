import java.util.Scanner;

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
    private SavingsAccount[] clients;
    String id, name;
    double balance;
    int i = 0;
    int number = 1;

    public BankApp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many users?");
        int numArray = Integer.parseInt(scanner.nextLine());

        clients = new SavingsAccount[numArray];

        while (i < clients.length) {
            System.out.println("What is your id " + number + "?");
            id = scanner.nextLine();
            System.out.println("What is your name " + number + "?");
            name = scanner.nextLine();
            System.out.println("What is your balance " + number + "?");
            balance = Double.parseDouble(scanner.nextLine());
            addClients();
            i++;
            number++;
        }

        i = 0;
        while (i < clients.length){
            displayClients();
            i++;
        }
    }

    public void addClients() {
        clients[i] = new SavingsAccount(id, name, balance);
    }

    public void displayClients(){
        System.out.println("--------------\nid: " + clients[i].getID() + "\nname: " + clients[i].getName() + "\ninitialBalance: " + clients[i].getBalance() + "\n");
    }

    public static void main(String args[]) {
        BankApp ba = new BankApp();
    }
}