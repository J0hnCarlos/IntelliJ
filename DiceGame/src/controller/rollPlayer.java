package controller;

import model.interfaces.GameEngine;
import view.appFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rollPlayer implements ActionListener {
    private GameEngine gameEngine;
    private appFrame appFrame;

    public rollPlayer(GameEngine gameEngine, appFrame appFrame)
    {
        this.gameEngine = gameEngine;
        this.appFrame = appFrame;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        // check if a valid player has been selected
        try
        {
            // check if it is a valid player
            gameEngine.getPlayer(appFrame.getPlayerID());

            // check if the player has rolled for current round
            if(gameEngine.getPlayer(appFrame.getPlayerID()).getResult() == null)
            {
                // check if valid bet has already been placed
                if(gameEngine.getPlayer(appFrame.getPlayerID()).getBet() != 0)
                {
                    // update player details
                    appFrame.getStatusBar().getPlayerDetail().setText("PLAYER ID: " + gameEngine.getPlayer(appFrame.getPlayerID()).getPlayerId() + " POINTS: " + gameEngine.getPlayer(appFrame.getPlayerID()).getPoints() + " BET: " + gameEngine.getPlayer(appFrame.getPlayerID()).getBet());

                    new Thread()
                    {
                        public void run()
                        {
                            // roll player in gameEngine
                            gameEngine.rollPlayer(gameEngine.getPlayer(appFrame.getPlayerID()), 100, 1000, 100, 50, 500, 50);
                        }
                    }.start();

                    // update player details
                    appFrame.getStatusBar().getPlayerDetail().setText("PLAYER ID: " + gameEngine.getPlayer(appFrame.getPlayerID()).getPlayerId() + " POINTS: " + gameEngine.getPlayer(appFrame.getPlayerID()).getPoints() + " BET: " + gameEngine.getPlayer(appFrame.getPlayerID()).getBet());
                }
                else
                {
                    System.out.println("Warning*: You must place a valid bet before you can roll.");
                }
            }
            else
            {
                System.out.println("*Warning*: A player can only roll one time for each round.");
            }
        }
        catch (NullPointerException npe)
        {
            System.out.println("*Error*: No player yet.");
        }
    }
}
