import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

// Java user input (Scanner Class)
// Reference: https://www.w3schools.com/java/java_user_input.asp
public class Week3Tute {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter full name, age and salary");

        // String input
        String fullname = myObj.nextLine();

        //String check
        String check;

        // Numerical input
        int age = myObj.nextInt();
        double salary = myObj.nextDouble();

        // Output input by user

        // This if statement is not case sensitive because of the toLowerCase() added before the contains.
        // It changes the string inside name to all lower case before checking it with if statement.
        // Now, as long as the string is marco even when it is typed (MaRcO), the if statement will convert it to marco(lowercase)
        // thus making sure that it is not case sensitive

        if (fullname.toLowerCase().contains("marco")){
            System.out.println("\nHello there Marco. Nice to meet you again\n");
        }

        System.out.println("Is there Marco in name: " + fullname.toLowerCase().contains("marco"));
        System.out.println("Name: " + fullname);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}
