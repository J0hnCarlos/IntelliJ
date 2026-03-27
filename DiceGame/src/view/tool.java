package view;

import controller.playerBet;
import controller.rollHouse;
import controller.rollPlayer;
import controller.selectPlayer;
import model.interfaces.GameEngine;

import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class tool extends JToolBar {
    private static final long serialVersionUID = 1L;

    private AbstractButton rollPlayer = new JButton("Roll Selected Player");
    private AbstractButton rollHouse = new JButton("Roll House");
    private AbstractButton placeBet = new JButton("Place Bet");
    private JTextField betAmount = new JTextField(10);
    private comboBox playerBox;

    public tool(GameEngine gameEngine, appFrame appFrame)
    {
        setLayout(new FlowLayout());

        playerBox = new comboBox(gameEngine);

        // add components
        add(rollPlayer);
        add(rollHouse);
        add(playerBox);
        add(placeBet);
        add(betAmount);

        // add action listener to buttons
        placeBet.addActionListener(new playerBet(gameEngine, appFrame, betAmount));
        rollPlayer.addActionListener(new rollPlayer(gameEngine, appFrame));
        rollHouse.addActionListener(new rollHouse(gameEngine, appFrame));
        playerBox.addActionListener(new selectPlayer(gameEngine, appFrame));
    }

    public comboBox getPlayerBox()
    {
        return playerBox;
    }
}
