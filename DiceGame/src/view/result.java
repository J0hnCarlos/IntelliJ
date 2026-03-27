package view;

import model.interfaces.GameEngine;
import model.interfaces.Player;

import javax.swing.*;

public class result extends JPanel{
    private static final long serialVersionUID = 1L;

    private GameEngine gameEngine;

    private JLabel title = new JLabel("------------------RESULTS------------------");
    private JTextArea result = new JTextArea();
    private JScrollPane scrollPane;

    public result(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;

        // make title be in center
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        scrollPane = new JScrollPane(result, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    public void update()
    {
        // reset battle results
        result.setText("");

        for(Player player : gameEngine.getAllPlayers())
        {
            // check if the player rolled
            if(player.getResult() != null)
            {
                // print out all battle results including playerName, playerRollResult, points
                result.setText(result.getText() + player.getPlayerName() + "(" + player.getResult().toString() +") points: " + player.getPoints() + "\n");
            }
            else
            {
                result.setText(result.getText() + player.getPlayerName() + "(Hasn't roll for last round) points: " + player.getPoints() + "\n");
            }
        }
        add(scrollPane);
    }
}
