import javax.swing.*;

public class Chatbotstage03 {

    public static void main(String[] args) {

        // Creating variables
        boolean stopper = true; // To stop the program
        int i;
        int numItem;
        int placeHolder = 1;
        int max;

        // Ask the user how big the size of array is
        String message;
        String number = JOptionPane.showInputDialog(null, "How big is the array size?");
        numItem = Integer.parseInt(number);

        // Create the array with desired size
        String userKey[] = new String[numItem];
        i = 0;

        // User enter keyword 1 by 1
        while (i < numItem && number != null) {
            number = JOptionPane.showInputDialog(null, "Enter name of your keyword " + placeHolder);
            if (number != null) {
                userKey[i] = number;
                i = i + 1;
                placeHolder++;
            }
        }

        message = "Hello there! What do you want to talk about?\n";
        i = 0;
        placeHolder = 1;

        // Display all the keywords from user
        while (i < numItem) {
            message = message + placeHolder + ". " + userKey[i] + "\n";
            i++;
            placeHolder++;
        }

        JOptionPane.showMessageDialog(null, "Keyword ready!");

        // loop until user quits
        while (stopper == true) {

            String topic = JOptionPane.showInputDialog(null, message);

            // Check for ? or empty textbox
            while (topic.equals("") || topic.contains("?")) {
                if (topic.equals("")) {
                    JOptionPane.showMessageDialog(null, "I could not find any word. Please enter your message");
                    topic = JOptionPane.showInputDialog(null, message);
                } else if (topic.contains("?")) {
                    JOptionPane.showMessageDialog(null, "I'm the one asking questions");
                    topic = JOptionPane.showInputDialog(null, message);
                }
            }

            i = 0;
            max = numItem + 1;

            // Talk to user about their chosen topics
            while (i < numItem) {
                if (topic.toLowerCase().contains(userKey[i])) {
                    JOptionPane.showMessageDialog(null, "Let's talk about " + userKey[i]);
                    i = max;
                }
                i++;
            }

            // If no keywords are found
            if (i == numItem) {
                JOptionPane.showMessageDialog(null, "No keyword found");
            }

            // Ask the user if they wanted to continue
            String choice[] = new String[2];
            choice[0] = "Yes";
            choice[1] = "No";

            int numAns = JOptionPane.showOptionDialog(null, "Do you want to continue?",
                    "Restart",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choice,
                    choice[0]);
            // Buttons
            if (numAns == 0) {
                stopper = true;
            } else {
                stopper = false;
            }
        }
    }
}
// Code end
// The error is if no keywords are found, it loops for no reason. But it has been fixed