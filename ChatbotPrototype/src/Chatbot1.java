import javax.swing.*;

public class Chatbot1 {

    public static boolean stopper = true;

    public static void main(String[]args){
        while (stopper){
            Chatbot1 startActivity = new Chatbot1();
            //startActivity.endScreen();
        }
        System.exit(0);
    }

    /*private void endScreen() {

        String[] start = new String[]{"Yes", "No"};

        int choice = JOptionPane.showOptionDialog(null, "Would you like to talk to me again??",
                "Restart?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                start,
                start[1]);

        if (choice == 0){
            stopper = true;
        } else {
            stopper = false;
        }
    }*/
}
