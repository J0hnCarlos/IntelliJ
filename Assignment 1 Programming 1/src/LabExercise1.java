import java.util.Scanner;

public class LabExercise1 {
    public static void main(String [] args){
        Scanner keyboard = new Scanner(System.in);
        double v, i, o;
        System.out.print("Enter V in Volt: ");
        v = keyboard.nextDouble();
        System.out.print("Enter I in amperes: ");
        i = keyboard.nextDouble();

        o = v/i;
        System.out.print("Resistance R is: " + o + " ohms");
        keyboard.close();
    }
}
