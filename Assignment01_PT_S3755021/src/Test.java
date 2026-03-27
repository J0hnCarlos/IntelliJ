import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        String input;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input 5 letter seperated by spaces:");
        input = scanner.nextLine();

        String[] split = input.trim().split("\\s+");

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        int i = 0;
        String message = "";
        String otherMessage = "";

        while (i < 5) {
            message = message + split[i] + " ";
            i++;
        }

        System.out.println("Hello " + name + " you said: " + message);

        i = 0;
        while (i < 5) {
            if (split[i].toLowerCase().contains("l")){
                otherMessage = otherMessage + split[i] + " ";
            }

            i++;
        }

        System.out.println("Only words starting with 'l': " + otherMessage);

        scanner.close();
    }
}
