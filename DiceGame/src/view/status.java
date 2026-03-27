package view;

import javax.swing.*;
import java.awt.*;

public class status extends JPanel {
    private static final long serialVersionUID = 1L;

    private static final int GRID_X = 1;
    private static final int GRID_Y = 2;

    private JLabel gameStatus = new JLabel("", JLabel.LEFT);
    private JLabel playerDetail = new JLabel("", JLabel.RIGHT);

    public status ()
    {

        setLayout(new GridLayout(GRID_X, GRID_Y));

        // initialise game status as welcome message
        gameStatus.setText("WELCOME!!!");
        add(gameStatus);

        // initialise player details
        playerDetail.setText("NO PLAYER YET.");
        add(playerDetail);
    }

    public JLabel getGameStatus()
    {
        return gameStatus;
    }

    public JLabel getPlayerDetail()
    {
        return playerDetail;
    }
}
