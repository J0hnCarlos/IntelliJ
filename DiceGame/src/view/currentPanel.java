package view;

import model.interfaces.GameEngine;

import javax.swing.*;
import java.awt.*;

public class currentPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private diceRolling diceRollingPanel;
    private result diceResult;
    private JSplitPane splitPane;

    public currentPanel(GameEngine gameEngine)
    {
        diceRollingPanel = new diceRolling();
        diceResult = new result(gameEngine);

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                diceRollingPanel, diceResult);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(info.YY / 2);

        // provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(info.XXX, info.YYY);
        diceRollingPanel.setMinimumSize(minimumSize);
        diceResult.setMinimumSize(minimumSize);
        splitPane.setPreferredSize(new Dimension(info.XX / 2, info.YY));
        add(splitPane);
    }

    public diceRolling getDiceRollingPanel()
    {
        return diceRollingPanel;
    }

    public result getBattleResultPanel()
    {
        return diceResult;
    }
}
