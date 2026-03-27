public class EnrollmentSystem {
    public static void main(String[] args) {
//        Student stud0 = new Student();
//        Student stud1 = new Student();
        boolean check = true;
        Student[] stud = new Student[2];

        stud[0] = new Student("s1234567", "Chucky");
        stud[1] = new Student("s2345678", "Robinson");

//        stud0.newStudent("s1234567", "Chucky");
//        stud1.newStudent("s2345678", "Robinson");

        System.out.println(stud[0] + "\n");
        System.out.println(stud[1] + "\n");

        Course programming = new Course();
        programming.newCourse("COSC 2173", "Programming 1");

        String studNum = "s1234567";

        System.out.println(programming.enrol(studNum));
        int i = 0;

        studNum = "s2345678";
        while (i < stud.length) {
            if (studNum == stud[i].getNum()) {
                System.out.println(programming.enrol(studNum));
                check = false;
                break;
            } else {
                check = true;
                i++;
            }
        }

        if (check){
            System.out.println(studNum + " is not recognised");
        }

        programming.print();
    }
}
