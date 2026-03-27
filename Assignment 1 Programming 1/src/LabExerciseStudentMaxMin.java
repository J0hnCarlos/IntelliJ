import java.util.Scanner;

public class LabExerciseStudentMaxMin {
    public static  void main(String[] args){
        double stud1, stud2, stud3, x, y, max, min, avg;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter student 1 mark: ");
        stud1 = keyboard.nextDouble();
        System.out.print("Enter student 2 mark: ");
        stud2 = keyboard.nextDouble();
        System.out.print("Enter student 3 mark: ");
        stud3 = keyboard.nextDouble();

        x = Math.max(stud1,stud2);
        max = Math.max(x, stud3);

        y = Math.min(stud1, stud2);
        min = Math.min(y, stud3);

        avg = (stud1 + stud2 + stud3) / 3;

        System.out.println("a) Average mark: " + avg);
        System.out.println("b) Maximum mark: " + max);
        System.out.println("c) Minimum mark: " + min);
        keyboard.close();
    }
}
