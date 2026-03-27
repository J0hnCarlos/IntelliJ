import java.util.*;

public class MonsterGameManager {

    private Monster monster[];

    MonsterGameManager(int n)
    {
        monster = new Monster[n];

        // Old code, pre 29/4/2019 lecture
        // Scanner keyboard = new Scanner(System.in);
        // System.out.println(m1.getNumEyes() + " " + m1.getColour());
        // System.out.println(m1.getNumEyes() + " " + m2.getColour());
        // if (m1.changeColour("PINK") == -1)
        // System.out.println("Bad colour");
        // System.out.println(m1.getNumEyes() + " " + m1.getColour());

        // Tasks for Lecture 29/4/2019
        // (a) Develop three more ctors as follows:
        //     (i) default ctor to enter monster attributes
        //    (ii) new ctor with one parameter n to convey #eyes;
        //         colour defaults to "WHITE"/code=0
        //   (iii) new ctor with one parameter c to convey colour;
        //         numEyes defaults to 2
        // The following examples should work
        monster[0] = new Monster(); // properties are input
        monster[1] = new Monster(); // Colour defaults to "WHITE"
        monster[2] = new Monster(); // Num eyes default to 2
        //
        // (b) Write setters/mutators to be able to change for all
        //     properties/attributes (aka instance variables)
        // (c) Write a method to display instance variable values
        // (d) Write a query loop to list all monsters from the array,
        //     replacing the following code to use the solution for (c)
        int i = 0;
        while (i < 3) {
            monster[i].displayAttributes();
            // System.out.println("Monster #" + i + ": " + monster[i].getNumEyes() + " " + monster[i].getColour());
            i++;
        }
        // (e) Add a unique IDs for monsters and repeat (a) (b) making sure that no new
        // monster is created with an already existing ID; ask for the ID, check if the ID is not
        // already used in monsters already in the array, then add a new monster if ID is unique,
        // by invoking an appropriate ctor

        // (f) Search on ID, colour, number of eyes, and list value if found
        // (g) Add a property (instance variable) that represents
        //     an array of monster babies (each of type MonsterBaby);
        //     the maximum number of babies will be specified via
        //     a ctor parameter, to allow for the baby monster array
        //     to be created

    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many monsters: ");
        int n = keyboard.nextInt();
        MonsterGameManager mgm = new MonsterGameManager(n);
    }

}
