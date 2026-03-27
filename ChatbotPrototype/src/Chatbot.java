import javax.swing.*;

//Start of the class
public class Chatbot {

    boolean stopper = true; // This is a variable to stop the system from continuing/stops the program fromm doing the while loop again

    int i = 0;

    //Array strings
    String keyword[] = new String[10];

    String intro; // This variable is for the pop up message from the very beginning. This takes the string and checks it with all possible options

    // Stage 1
    /*
    // This block of code is used to check the string from user input and run specific program.
    String subjectWork = "work"; // Done
    String subjectHobby = "hobby"; // Done
    String subjectFood = "food"; // Done
    String subjectCalculator = "calculate"; // Done
    String subjectMovie = "movie"; // Done
    String meaningOfLife = "meaning of life"; // Done
    String subjectBMI = "bmi"; // Done
    String subjectRng = "rng"; // Done
    String subjectPrint = "print"; // Done
    String subjectDisplayData = "display my data"; // Done
    */

    String msg = "Hello there! I'm a chatbot named Jimmy. What would you like to talk about??\n";

    // The code starts running here
    public static void main(String[] args) {
        Chatbot startActivity = new Chatbot();
        startActivity.show(); // This is the code that starts the entire program
        System.exit(0); // This is to exit the program
    }

    // As named, its where the show happens
    public void show() {

        // Setting all strings in the array
        keyword[0] = "work";
        keyword[1] = "hobby";
        keyword[2] = "food";
        keyword[3] = "calculate";
        keyword[4] = "movie";
        keyword[5] = "meaning of life";
        keyword[6] = "bmi";
        keyword[7] = "rng";
        keyword[8] = "print";
        keyword[9] = "display my data";

        // Fills variable msg with the array
        while (i < 10) {
            msg = msg + "--> " + keyword[i] + "\n";
            i++;
        }
        // This while loop either continues or stops the program depending on what the user choose
        while (stopper) {
            startChat();
            endScreen();
        }
    }

    // This is where the first panel comes from.
    public void startChat() {

        // This is the pop up message' block of code. It also display all the possible keyword from the variable set before
        intro = JOptionPane.showInputDialog(null, msg);
        separationPanel(); // The separation panel is where the variable is being tested before assigned to run what program
    }

    // The seperation panel is where the variable is being tested before assigned to run what program
    private void separationPanel() {
        int target;

        // This if statements check the variable with every possible keyword before giving the user an answer.
        // All those panel will be explained later on. :D

        /*
        if (intro.toLowerCase().contains(subjectHobby) | (intro.toLowerCase().contains("hobbies"))) {
            hobbyPanel();
        } else if (intro.toLowerCase().contains(meaningOfLife)) {
            meaningOfLife();
        } else if (intro.equals("")) {
            JOptionPane.showMessageDialog(null, "I could not find any word. Please enter your message");
            startChat();
        } else if (intro.contains("?")) {
            JOptionPane.showMessageDialog(null, "Hey, I'm the one asking the question here.");
            startChat();
        } else if (intro.toLowerCase().contains(subjectFood)) {
            food();
        } else if (intro.toLowerCase().contains(subjectWork) || (intro.toLowerCase().contains("working"))) {
            work();
        } else if (intro.toLowerCase().contains(subjectMovie) || (intro.toLowerCase().contains("movies"))) {
            movie();
        } else if (intro.toLowerCase().contains(subjectCalculator) || (intro.toLowerCase().contains("calculator"))) {
            calculator();
        } else if (intro.toLowerCase().contains(subjectBMI) || (intro.toLowerCase().contains("body mass index"))) {
            bmiCalculate();
        } else if (intro.toLowerCase().contains(subjectRng) || (intro.toLowerCase().contains("random number"))) {
            rng();
        } else if (intro.toLowerCase().contains(subjectPrint)) {
            print();
        } else if (intro.toLowerCase().contains(subjectDisplayData) || (intro.toLowerCase().contains("display some data"))) {
            displayData();
         */
        if (intro.equals("")) {
            JOptionPane.showMessageDialog(null, "I could not find any word. Please enter your message");
            startChat();
        } else if (intro.contains("?")) {
            JOptionPane.showMessageDialog(null, "Hey, I'm the one asking the question here.");
            startChat();
        } else if (intro.toLowerCase().contains("exit")) {
            System.exit(0);
        } else if (intro == null) {
            JOptionPane.showMessageDialog(null, "I still haven't gotten that subject programmed in to me yet");
            startChat();
        }

        i = 0;
        target = 0;

        // Looks for keyword and assign what program to run
        while (i < 10) {
            if (intro.toLowerCase().contains(keyword[i])) {
                i = 10;
                if (target == 0) {
                    work();
                } else if (target == 1) {
                    hobbyPanel();
                } else if (target == 2) {
                    food();
                } else if (target == 3) {
                    calculator();
                } else if (target == 4) {
                    movie();
                } else if (target == 5) {
                    meaningOfLife();
                } else if (target == 6) {
                    bmiCalculate();
                } else if (target == 7) {
                    rng();
                } else if (target == 8) {
                    print();
                } else if (target == 9) {
                    displayData();
                }
            } else {
                i++;
                target++;
            }
        }
    }

    // Hobby panel. This panel ask the user to input what hobby the like. Once the user enters their hobby,
    // the computer will answer back with what the user typed in
    private void hobbyPanel() {
        // This string is for the user input
        String hobbymessage = JOptionPane.showInputDialog(null, "What kind of hobby that you enjoy?");

        // This makes sure the user can't just leave it blank
        if (hobbymessage.equals("")) {
            JOptionPane.showMessageDialog(null, "Umm you left it blank and I can't analyze it");
            hobbyPanel();
        } else {
            JOptionPane.showMessageDialog(null, "I like " + hobbymessage +
                    " too! Its a really great way to spend your free time ");
        }
    }

    // This panel gives the user a choice. Different answer leads to another answer
    private void meaningOfLife() {

        // This string is what makes the button. Well its something similar to array but it can be used as button from JOptionPane
        String start[] = new String[2];
        start[0] = "I think its right";
        start[1] = "I think its wrong";

        // This is user input but for buttons
        int lifemessage = JOptionPane.showOptionDialog(null,
                "I heard its a really hard topic but some say its 42 which doesn't make sense dont you think?",
                "Tell me your opinion",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                start,
                start[0]);

        // Buttons has a number assigned to them. For this panel, the left button is 0 (I think its right) and 1 is the right button
        // (I think its wrong) and so on for the other similar multiple choice questions
        if (lifemessage == 0) {
            JOptionPane.showMessageDialog(null, "Well I cant argue with that");
        } else if (lifemessage == 1) {
            JOptionPane.showMessageDialog(null, "Hmm well if you say so");
        }
    }

    // This one gives user 4 choice of answers although they ended up in the same place except the variables.
    // The variable changes based on the choice
    public void food() {

        String prefer[] = new String[4];
        prefer[0] = "Steak";
        prefer[1] = "Soup";
        prefer[2] = "Toast";
        prefer[3] = "Cake";

        int number = JOptionPane.showOptionDialog(null,
                "Ohh I have a selection of food. Can you tell me which do you like most?",
                "Choose which one you like the most",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                prefer,
                prefer[0]);

        if (number == 0) {
            JOptionPane.showMessageDialog(null, "Ohh you like steak more than anything else?\nInteresting");
        } else if (number == 1) {
            JOptionPane.showMessageDialog(null, "Ohh you like soup more than anything else?\nInteresting");
        } else if (number == 2) {
            JOptionPane.showMessageDialog(null, "Ohh you like toast more than anything else?\nInteresting");
        } else if (number == 3) {
            JOptionPane.showMessageDialog(null, "Ohh you like cake more than anything else?\nInteresting");
        }
    }

    // This one also give the user a choice answer. but instead of clicking buttons, The users will have to input to by typing it to the text box
    private void work() {
        String answer = JOptionPane.showInputDialog(null, "Do you enjoy your work?");

        // Possible answers are (yes, yea, no and nah). If user gave a blank response, the computer will ask them to write something
        if (answer.toLowerCase().contains("yes") || answer.toLowerCase().contains("yea")) {
            JOptionPane.showMessageDialog(null, "Glad to hear that");
        } else if (answer.toLowerCase().contains("no") || answer.toLowerCase().contains("nah")) {
            JOptionPane.showMessageDialog(null, "Hope it gets better for you");
        } else if (answer.toLowerCase().contains("aye")) {
            String creatorAns[] = new String[2];
            creatorAns[0] = "Yes, its me";
            creatorAns[1] = "No, I'm not";
            int ans = JOptionPane.showOptionDialog(null, "John, is that you??",
                    "Keyword detected",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    creatorAns,
                    creatorAns[0]);

            if (ans == 0) {
                creatorCheck();
            } else {
                JOptionPane.showMessageDialog(null, "Ohh okay.");
            }
        } else if (answer.toLowerCase().contains("")) {
            JOptionPane.showMessageDialog(null, "I can't find any word. Please enter your response");
            work();
        } else {
            JOptionPane.showMessageDialog(null, "I don't think you answered my question");
            work();
        }
    }

    // This is similar to others. Some options for users and the reply will change depending on the user's choice
    private void movie() {
        String choice[] = new String[2];
        choice[0] = "Yes";
        choice[1] = "No";

        int number = JOptionPane.showOptionDialog(null, "Are you hyping about Avengers: EndGame?",
                "Movie",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                choice,
                choice[0]);

        if (number == 0) {
            JOptionPane.showMessageDialog(null, "So you are also waiting Avengers: Endgame :D \n" +
                    "Well I'm waiting for that + John Wick 3: Parabellum");
        } else {
            String forReal[] = new String[2];
            forReal[0] = "Yes";
            forReal[1] = "No, I'm joking";
            int answer = JOptionPane.showOptionDialog(null, "Wait for real?",
                    "Really?!?",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    forReal,
                    forReal[0]);

            if (answer == 0) {
                String whatMovie = JOptionPane.showInputDialog(null, "So what kind of movie do you like? Give me a title");

                System.out.println("System console ready..." +
                        "\nStarting up auto saver system..." +
                        "\nUser input detected..." +
                        "\nAdding information to database" +
                        "\nData saved!" + whatMovie);
                JOptionPane.showMessageDialog(null, "Hmm okay, that's in my list now.");
            } else {
                JOptionPane.showMessageDialog(null, "Ohh I thought so. How can you not be interested in that movie");
            }
        }
    }

    // Simple maths. This program asks the user to input the first number, second number, calculate it and display it to the users.
    // This calculator only does + - * /
    private void calculator() {

        // This is a variable to assign the numbers. X is for the first number, y is for the second number,
        // sum is the result of adding both numbers, minus is substraction, * is times, / is divide
        double x, y, sum, minus, div, times;
        int number1;

        // Integer.parseInt is to convert String to int
        number1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your first number"));
        x = number1;

        // Similar method
        int number2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your second number"));
        y = number2;

        // This is where all the calculation are being done
        sum = x + y;
        minus = x - y;
        div = x / y;
        times = x * y;

        // This is where all the results are displayed
        JOptionPane.showMessageDialog(null, "Here's your calculation boss\n" +
                x + " + " + y + " = " + sum +
                "\n" +
                x + " x " + y + " = " + times +
                "\n" +
                x + " / " + y + " = " + div +
                "\n" +
                x + " - " + y + " = " + minus);
    }

    // This is to calculate the user's BMI (Body Mass Index) similar to the calculator but has some formula in it
    private void bmiCalculate() {

        double BMI;
        String condition;

        double weight = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter your weight (in kg)"));
        double height = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter your height (in meters)"));

        BMI = weight / (height * height);

        double result = Math.round(BMI * 100D) / 100D;

        // This is to know if user is underweight, normal or overweight
        if (BMI < 18.5) {
            condition = "Underweight";
        } else if (BMI > 18.5 && BMI < 24.9) {
            condition = "Normal";
        } else if (BMI > 25 && BMI < 29.9) {
            condition = "Overweight grade I";
        } else if (BMI > 30 && BMI < 34.9) {
            condition = "Overweight grade II";
        } else if (BMI > 35 && BMI < 39.9) {
            condition = "Overweight grade III";
        } else {
            condition = "Severe Overweight";
        }

        // This is to display the message
        JOptionPane.showMessageDialog(null, "Your BMI is " + result + " and you are " + condition);
    }

    // This is an rng program. It gives the user a random number from 1 to X where X is what the user sets
    private void rng() {
        double random;

        int number = Integer.parseInt(JOptionPane.showInputDialog(null, "What is your number limit? (0 - x)"));

        // This assigns a random number to variable named random
        random = Math.round(Math.random() * number);

        // Shows the number
        JOptionPane.showMessageDialog(null, "Got it. Your random number is :" + random);
    }

    // User can print as many copies of a text/sentences as they want
    private void print() {
        int i = Integer.parseInt(JOptionPane.showInputDialog(null, "How many times you want me to enter this sentence?"));
        int start = 1;

        String sentence = JOptionPane.showInputDialog(null, "What sentence/text you want to duplicate?");

        // while loop to keep doing until it reaches false statement
        while (start <= i) {
            System.out.println(start + ". " + sentence);
            start++;
        }

        // Tells the user to look at the console
        JOptionPane.showMessageDialog(null, "Please look at the console :D");
    }

    // This saves the message from user input and display it all at once
    private void displayData() {

        // Declaring all the variables needed
        String name;
        String age;
        String phone;
        String address;

        JOptionPane.showMessageDialog(null, "Sure, please enter your data as instruction :D");

        // Assigning all variable with values
        name = JOptionPane.showInputDialog(null, "Please enter your name");
        age = JOptionPane.showInputDialog(null, "Please enter your age");
        address = JOptionPane.showInputDialog(null, "Please enter your address");
        phone = JOptionPane.showInputDialog(null, "Please enter your phone number");

        // Code to display the data
        JOptionPane.showMessageDialog(null, "Here is your data displayed:" +
                "\n Your name is: " + name +
                "\n You are: " + age + " years old" +
                "\n You currently live at: " + address +
                "\n Your phone number is: " + phone);
    }

    private void creatorCheck() {
        String password = JOptionPane.showInputDialog(null, "Please enter your password");
        if (password.equals("12740")) {
            JOptionPane.showMessageDialog(null, "Hello there John");
        } else {
            JOptionPane.showMessageDialog(null, "Wrong password");
        }
    }

    // This is the code that stops the program
    private void endScreen() {

        // The buttons are assigned by using String variable
        String start[] = new String[2];
        start[0] = "Yes";
        start[1] = "No";

        // Ask the user if they want to restart or not
        int choice = JOptionPane.showOptionDialog(null, "Would you like to talk to me again??",
                "Restart?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                start,
                start[1]);

        if (choice == 0) {
            // This means yes in the button. It sets the stopper as true, letting the while loop from before to continue running the program
            stopper = true;
        } else {
            // This means no in the button. It sets the stopper to false, stopping the while loop from redo-ing the code and lets the program to exit
            stopper = false;
        }
    }
    // Code fully completed
}