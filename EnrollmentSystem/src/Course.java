public class Course {
    private String courseNum;
    private String courseName;
    private String studID;
    private int numOfStud = 5;
    private int programmingStud;
    private String[] student = new String[numOfStud];

    public void newCourse(String ID, String name){
        this.courseNum = ID;
        this.courseName = name;
    }

    public String enrol(String studentID){
        if (programmingStud < numOfStud) {
            this.studID = studentID;
            programmingStud++;
            student[programmingStud] = studID;
            return String.format("Student: %s has been successfully enrolled in %s %s", this.studID, this.courseNum, this.courseName);
        } else {
            return String.format("Class is full");
        }
    }

    public String toString(){
        return String.format("Course Number: %s\nCourse Name: %s", this.courseNum, this.courseName);
    }

    public void print(){
        for (int i = 0; i < numOfStud; i++){
            System.out.println(student[i]);
        }
    }
}
