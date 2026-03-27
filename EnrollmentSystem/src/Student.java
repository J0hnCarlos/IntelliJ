public class Student {
    private String studNum;
    private String studName;

    public Student(String ID, String name){
        this.studNum = ID;
        this.studName = name;
    }

    public String getNum(){
        return this.studNum;
    }

    public String getName(){
        return this.studName;
    }

    public String toString(){
        return String.format("Student Number: %s\nStudent Name: %s", this.studNum, this.studName);
    }
}
