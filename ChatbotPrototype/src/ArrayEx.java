import javax.swing.*;

public class ArrayEx {
    private String name;
    private String gender;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String g) {
        gender = g;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String p){
        phone = p;
    }

    public String toString(){
        JOptionPane.showMessageDialog(null, "Name: " + name + "\n Gender: " + gender + "\n Phone: " + phone);
        return toString();
    }
}

/*private void array() {
        ArrayEx array1 = new ArrayEx();

        String name = JOptionPane.showInputDialog(null, "Please enter your name");
        array1.setName(name);

        String[] choice = new String[]{"Male", "Female"};


        int gender = JOptionPane.showOptionDialog(null, "Please enter your gender",
                "Gender",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                choice,
                choice[0]);

        if (gender == 0) {
            genderWord = "Male";
        } else if (gender == 1) {
            genderWord = "Female";
        }

        array1.setGender(genderWord);

        String phone = JOptionPane.showInputDialog(null, "What is your phone number?");

        array1.setPhone(phone);

        String[] stop = new String[]{"Exit", "Continue reading"};

        int exitProgram = JOptionPane.showOptionDialog(null, "DO you want to exit?", "Exit?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                stop,
                stop[0]);

        if (exitProgram == 0){
            endScreen();
        } else {

        }
    }
   */
