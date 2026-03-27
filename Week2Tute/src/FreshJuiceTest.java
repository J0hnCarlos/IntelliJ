import javax.swing.*;

public class FreshJuiceTest {

    public static void main(String[]args){
        Scanner

        int number;
        String name;

        String names = JOptionPane.showInputDialog(null, "Please Enter Your Name");
        name = names;

        String Age = JOptionPane.showInputDialog(null,"Please enter your age");
        number = Integer.parseInt(Age);

        JOptionPane.showMessageDialog(null, "Hello there " + name + ". Your age is " + number);
    }
}
