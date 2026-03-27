package view;

import model.interfaces.GameEngine;

import javax.swing.*;
import java.awt.*;

public class info extends JPanel {
    private static final long serialVersionUID = 1L;

    private rolledDice diceResultPanel;
    private currentPanel currentPanel;
    private JSplitPane splitPane;

    // constants of components
    public static final int XX = 660;
    public static final int YY = 400;
    public static final int XXX = 165;
    public static final int YYY = 160;
    private static final int MIN_XX = 290;

    public info(GameEngine gameEngine, appFrame appFrame)
    {
        diceResultPanel = new rolledDice(gameEngine, appFrame);
        currentPanel = new currentPanel(gameEngine);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                diceResultPanel, currentPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(XX / 2);

        // provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(MIN_XX, YY / 2);
        diceResultPanel.setMinimumSize(minimumSize);
        currentPanel.setMinimumSize(minimumSize);
        splitPane.setPreferredSize(new Dimension(XX, YY));
        add(splitPane);
    }

    public currentPanel getCurrentPanel()
    {
        return currentPanel;
    }

    public rolledDice getDiceResultPanel()
    {
        return diceResultPanel;
    }
}
