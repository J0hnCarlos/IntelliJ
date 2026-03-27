package view;

import javax.swing.JComboBox;

import model.PlayerDecorator;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class comboBox extends JComboBox<PlayerDecorator>{

    private static final long serialVersionUID = 1L;

    private GameEngine gameEngine;

    public comboBox(GameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
        update();
    }

    public void update()
    {
        // reset playerBox
        removeAllItems();

        // add player name to playerBox
        for(Player player : gameEngine.getAllPlayers())
        {
//            SimplePlayer x = new SimplePlayer(player.getPlayerId(), player.getPlayerName(), player.getPoints());
//            addItem(x);
            gameEngine.addPlayer(player);
            addItem(new PlayerDecorator(player));
        }
    }
}
