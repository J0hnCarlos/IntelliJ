import java.util.Scanner;

public class LabExerciseRectangle {
    public static void main(String[] args){
        double side1, side2, area, perimeter;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter side 1: ");
        side1 = keyboard.nextDouble();
        System.out.print("Enter side 2: ");
        side2 = keyboard.nextDouble();

        area = side1 * side2;
        perimeter = 2* (side1 + side2);
        System.out.printf("side1 = %8.2f, side2 = %8.2f, Area = %8.2f, Perimeter = %8.2f", side1, side2, area, perimeter);
        keyboard.close();
    }
}
