public class main {
    static int mark;
    static String grade;
    public static void main(String []args){
        mark = 100;

        if (mark < 50) {
            grade = "NN";
        } else if (mark > 49 && mark < 60){
            grade = "PA";
        } else if (mark > 59 && mark < 61){
            grade = "CR";
        } else if (mark > 60 && mark < 71){
            grade = "DI";
        } else {
            grade = "HD";
        }

        System.out.print(grade);
    }

    public String getGrade(int mark){


        return grade;
    }
}