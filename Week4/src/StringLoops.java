import java.util.Scanner;

public class StringLoops {

    public static void main(String[] args) {
        String str[]; // This is a String array but it has nothing in it at this
        // stage, not even an array
        Scanner console = new Scanner(System.in);

        str = new String[5]; // Creating an array to store up to
        // 5 String objects

        for (int i = 0; i < 5; i++)
        {
            System.out.print("Enter string " + i + ": ");
            str[i] = console.nextLine(); // Read another string
        }

        // Tute exercises:
        // (a) Rewrite the for-loop as a while
        // (b) Rewrite the for-loop as a do-while
        // (c) Print the array str after the inout loop to make sure
        //     that the input was entered correctly
        // (d) Write a new program to repeatedly read a string entered
        //     by the user and to print the length of the string entered;
        //     stop when the user enters a sentinel; a sentinel is a special
        //     terminating string like "exit" or "quit" or "goodbye", etc.

    }

}
