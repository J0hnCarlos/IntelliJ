package view;

import model.interfaces.GameEngine;

import javax.swing.*;
import java.awt.*;

public class rolledDice extends JPanel {
    private static final long serialVersionUID = 1L;

    private playerDiceResult playerDiceResultPanel;
    private houseResultPanel houseDiceResultPanel;
    private JSplitPane splitPane;

    public rolledDice(GameEngine gameEngine, appFrame appFrame)
    {
        playerDiceResultPanel = new playerDiceResult();
        houseDiceResultPanel = new houseResultPanel();

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                playerDiceResultPanel, houseDiceResultPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(info.YY / 2);

        // provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(info.XXX, info.YYY);
        playerDiceResultPanel.setMinimumSize(minimumSize);
        houseDiceResultPanel.setMinimumSize(minimumSize);
        splitPane.setPreferredSize(new Dimension(info.XX / 2, info.YY));
        add(splitPane);
    }

    public playerDiceResult getPlayerDiceResultPanel()
    {
        return playerDiceResultPanel;
    }

    public houseResultPanel getHouseDiceResultPanel()
    {
        return houseDiceResultPanel;
    }
}
