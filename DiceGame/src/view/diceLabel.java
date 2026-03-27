package view;

import model.diceFace.diceFace;

import javax.swing.*;

public class diceLabel extends JLabel {
    private static final long serialVersionUID = 1L;

    public static final int DICE_SIZE = 30;

    public diceLabel(int i)
    {
        setIcon(diceFace.getImageIcon(i));
    }
}
