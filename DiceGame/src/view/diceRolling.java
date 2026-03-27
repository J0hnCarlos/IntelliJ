package view;

import model.diceFace.diceFace;

import javax.swing.*;

public class diceRolling extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel title = new JLabel("-------------------ROLLING DICES-------------------");
    private JLabel result;
    private JLabel dice1;
    private JLabel dice2;

    public diceRolling()
    {
        result = new JLabel();
        dice1 = new diceLabel(0);
        dice2 = new diceLabel(0);
        dice1.setSize(diceLabel.DICE_SIZE, diceLabel.DICE_SIZE);
        dice2.setSize(diceLabel.DICE_SIZE, diceLabel.DICE_SIZE);

        // add components
        add(title);
        add(dice1);
        add(dice2);
        add(result);
    }

    public JLabel getResult()
    {
        return result;
    }

    // update dices faces
    public void update(int dice1, int dice2)
    {
        this.dice1.setIcon(diceFace.getImageIcon(dice1));
        this.dice2.setIcon(diceFace.getImageIcon(dice2));
    }
}
