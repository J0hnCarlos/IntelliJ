package controller;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.appFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectPlayer implements ActionListener {
    private GameEngine gameEngine;
    private appFrame appFrame;

    public selectPlayer(GameEngine gameEngine, appFrame appFrame)
    {
        this.gameEngine = gameEngine;
        this.appFrame = appFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(appFrame.getToolBar().getPlayerBox().getSelectedItem() != null)
        {
            // set the current player to be the selected player
            appFrame.setPlayer(((SimplePlayer)appFrame.getToolBar().getPlayerBox().getSelectedItem()).getPlayerId());

            // check if selected player has finished rolling
            if(gameEngine.getPlayer(appFrame.getPlayerID()).getResult() != null)
            {
                // update the player dice result
                appFrame.getInfo().getDiceResultPanel().getPlayerDiceResultPanel().getResult().setText(gameEngine.getPlayer(appFrame.getPlayerID()).getResult().toString());
                appFrame.getInfo().getDiceResultPanel().getPlayerDiceResultPanel().update(gameEngine.getPlayer(appFrame.getPlayerID()).getResult().getDie1().getValue(), gameEngine.getPlayer(appFrame.getPlayerID()).getResult().getDie2().getValue());
            }
            else
            {
                // reset the player dice result
                appFrame.getInfo().getDiceResultPanel().getPlayerDiceResultPanel().getResult().setText("Oops! Haven't rolled yet.");
                appFrame.getInfo().getDiceResultPanel().getPlayerDiceResultPanel().update(0, 0);
            }

            // update the player details
            appFrame.getStatusBar().getPlayerDetail().setText("PLAYER ID: " + appFrame.getPlayerID() + " POINTS: " + appFrame.getPoints() + " BET: " + gameEngine.getPlayer(appFrame.getPlayerID()).getBet());
        }
    }
}
