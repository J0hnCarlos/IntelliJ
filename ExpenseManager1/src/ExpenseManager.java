
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpenseManager {
    public static void main(String[] args) {
        int numItems;
        String inp = JOptionPane.showInputDialog("How many expenses you want to write?");
        if (inp == null) {
            return; // Stop running the program (method main)
        }
        numItems = Integer.parseInt(inp);// System.out.println(numItems);
        double[] expensePriceList = new double[numItems];
        double[] priceList;
        String[] expenseNameList = new String[numItems];

        // Get inputs in to the array
        int i = 0;
        while (i < numItems && inp != null) {
            inp = JOptionPane.showInputDialog(null, "Enter name of your expense " + i);
            if (inp != null) {
                expenseNameList[i] = inp;
                inp = JOptionPane.showInputDialog(null, "Enter cost of " + expenseNameList[i]);
                if (inp != null) {
                    expensePriceList[i] = Double.parseDouble(inp);
                }
            }
            i = i + 1;
        }

        if (inp == null) {
            return;
        }
        // calculate total cost of expenses (can be combined with the input taking step)
        double total = 0;
        i = 0;
        while (i < numItems) {
            total = total + expensePriceList[i];
            i = i + 1;
        }

        // JOptionPane.showMessageDialog(null, "Total cost of expenses: " + total);

        // calculating the average
        double average = total / numItems;
        // JOptionPane.showMessageDialog(null, "Average cost of expenses: "+average);

        String msg = "Total Cost of expenses: " + total + "\n" + "Average cost of expenses: " + average;
        JOptionPane.showMessageDialog(null, msg);
        // JOptionPane.showMessageDialog(null, "Average cost of expenses: "+average);

        //Compare the prices of each expenses against the average price
        msg = "";
        i = 0;
        while (i < numItems) {
            if ((average - expensePriceList[i]) > 0) {
                msg = msg + "Price of " + expenseNameList[i] + " is " + (average - expensePriceList[i]) + " cheaper than the average. \n";
            } else if ((average - expensePriceList[i]) < 0) {
                msg = msg + "Price of " + expenseNameList[i] + " is " + (expensePriceList[i] - average) + " more than the average.\n";
            } else {
                msg = msg + expenseNameList[i] + " is the same price as the average \n";
            }
            i = i + 1;
        }

        // Finding the minimum and the maximum
        double min = expensePriceList[0];
        double max = expensePriceList[0];
        int minIndex = 0;
        int maxIndex = 0;
        i = 0;
        while (i < numItems) {
            if (expensePriceList[i] < expensePriceList[minIndex]) {
                minIndex = i;
            }
            if (expensePriceList[i] > expensePriceList[maxIndex]) {
                maxIndex = i;
            }
            i = i + 1;
        }

        msg = msg + "\nCheapest expense is " + expenseNameList[minIndex] + "( " + expensePriceList[minIndex]
                + ") and the maximum is " + expensePriceList[maxIndex] + ").";
        JOptionPane.showMessageDialog(null, msg);

        //searching for an expense
        String target = "";
        msg = "";
        while (msg.length() == 0 && target != null) {
            target = JOptionPane.showInputDialog("Which expense did you want to search for...");
            if (target != null) {
                i = 0;
                while (i < numItems) {
                    if (expenseNameList[i].contains(target)) {
                        msg = msg + expenseNameList[i] + ": " + expensePriceList[i] + "\n";
                    }
                    i = i + 1;
                }
            }
            if (msg.length() > 0) {
                JOptionPane.showMessageDialog(null, "Results found ...\n" + msg);
            } else {
                JOptionPane.showMessageDialog(null, "No such expense found!");
            }

            String[] button = new String[]{"Yes", "No"};

            int choice = JOptionPane.showOptionDialog(null, "Do you want to delete an expense?",
                    "",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    button,
                    button[0]);

            if (choice == 0) {
                String answer = "";
                msg = "";
                while (msg.length() == 0 && target != null) {
                    answer = JOptionPane.showInputDialog("Which expense did you want to search for...");
                    if (answer != null) {
                        i = 0;
                        while (i < numItems) {
                            if (expenseNameList[i].contains(answer)) {
                                msg = msg + expenseNameList[i] + ": " + expensePriceList[i] + "\n";
                            }
                            i = i + 1;
                        }
                    }
                    if (msg.length() > 0) {
                        JOptionPane.showMessageDialog(null, "Results found ...\n" + msg);
                        String[] choiceNum = new String[]{"Yes", "No"};
                        int num = JOptionPane.showOptionDialog(null, "Do you want to delete this record?",
                                "",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                choiceNum,
                                choiceNum[0]);

                        if (num == 0) {
                            List<String> list = new ArrayList<>(Arrays.asList(expenseNameList));
                            list.remove(answer);

                            expenseNameList = list.toArray(new String[0]);

                            priceList = new double[expensePriceList.length - 1];



                            for (int j = i; j < expensePriceList.length - 1; j++) {
                                priceList[j] = expensePriceList[j + 1];
                            }

                            JOptionPane.showMessageDialog(null,"Deleted");

                            msg = "";
                            i = 0;
                            while (i < (numItems - 1)) {
                                msg = msg + "Price of " + expenseNameList[i] + " is " + expensePriceList[i] + "\n";
                                i = i + 1;
                            }

                            JOptionPane.showMessageDialog(null, msg);
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No such expense found!");
                    }
                }
            }

        }
    }
}


