import java.util.*;
public class Monster {

    // instance variables to represent properties
    private int numEyes;
    private String colour;
    private double value;
    private int code; // use of code for colour, perhaps?
    // See Part (g) for the following two instance variables
    // Ignore until we discuss in the lecture
    // private MonsterBaby bm[];
    // private int maxBabies;

    // constructor ctor
    Monster() { // default ctor but all ctors have the same name as the class; no parameters
        this.colour = "WHITE"; // default case
        this.code = 0;
        this.value = 0.0;
        Scanner kb = new Scanner(System.in);

        // Replace the above with ctor use to read in the properties
        System.out.print("Enter #eyes: ");
        this.numEyes = kb.nextInt();
        kb.nextLine();
        System.out.print("Enter colour: ");
        this.colour = kb.nextLine();
        System.out.print("Enter $value: ");
        this.value = kb.nextDouble();
        kb.nextLine();
    }

    Monster(int n, String c) // n, c are called parameters
    {
        numEyes = n;
        colour = c;
        // ignore numeric code for now
    }

    // Getters or Accessors
    public String getColour()
    {
        return colour;

    }

    public int getNumEyes()
    {
        return numEyes;

    }

    // Setters or Mutators
    int changeColour(String c)
    {
        // Normally, c would just be used to update the colour instance
        // variable, but this illustrates what could be done if c is not
        // a valid colour; the manager can check the return value and act
        // accordingly
        int retValue = 0; // local variable
        if (c.equals("WHITE")) code = 0;
        else
        if (c.equals("ORANGE")) code = 1;
        else
            retValue = -1;
        return retValue;
    }


    void changeNumEyes(int ne)
    {
        numEyes = ne;
    } //void version; code a version to return an error value if ne is negative
    // or too large, as per changeColour method above??

    void displayAttributes() {

    }
}