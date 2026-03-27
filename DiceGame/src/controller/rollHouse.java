package controller;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.appFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rollHouse implements ActionListener {
    private GameEngine gameEngine;
    private appFrame appFrame;

    public rollHouse(GameEngine gameEngine, appFrame appFrame)
    {
        this.gameEngine = gameEngine;
        this.appFrame = appFrame;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        boolean canRoll = false;

        // check if at least one player has already placed valid bet
        for(Player player : gameEngine.getAllPlayers())
        {
            if(player.getResult() != null)
            {
                canRoll = true;
            }
        }

        // check if we can roll house
        if(canRoll)
        {
            // update house message in the area of player details
            appFrame.getStatusBar().getPlayerDetail().setText("THIS IS HOUSE:)");
            new Thread()
            {
                public void run()
                {
                    // roll house in gameEngine and settle bet
                    gameEngine.rollHouse(100, 1000, 200, 50, 500, 25);

                    // update battle results
                    appFrame.getInfo().getCurrentPanel().getBattleResultPanel().update();

                    // reset all player bets to 0s after bet settled
                    for(Player player : gameEngine.getAllPlayers())
                    {
                        gameEngine.placeBet(player, 0);
                        player.setResult(null);
                    }
                }
            }.start();

            // update battle results
            appFrame.getInfo().getCurrentPanel().getBattleResultPanel().update();
        }
        else
        {
            System.out.println("*Warning*: You must roll at least one player before you can roll House.");
        }
    }
}
