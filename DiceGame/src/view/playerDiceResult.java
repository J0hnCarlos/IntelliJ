package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.diceFace.diceFace;
import view.dieGraphics;

import java.awt.*;

public class playerDiceResult extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel title = new JLabel("-------------------PLAYER DICE-------------------");
    private JLabel result;
    private JLabel die1;
    private JLabel die2;
    private dieGraphics diePic;
    private Graphics g;

    public playerDiceResult()
    {
        result = new JLabel();
        die1 = new diceLabel(0);
        die2 = new diceLabel(0);
        die1.setSize(diceLabel.DICE_SIZE, diceLabel.DICE_SIZE);
        die2.setSize(diceLabel.DICE_SIZE, diceLabel.DICE_SIZE);

        // add components
        add(title);
        add(die1);
        add(die2);
        add(result);
    }

    public JLabel getResult()
    {
        return result;
    }

    // update dices faces
    public void update(int dice1, int dice2)
    {
        dieGraphics.
    (this.die1.setIcon(diceFace.getImageIcon(dice1)));
        this.die2.setIcon(diceFace.getImageIcon(dice2));
    }
}
