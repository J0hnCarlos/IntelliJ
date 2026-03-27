package controller;

import view.appFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deletePlayer implements ActionListener {
    private appFrame appFrame;

    public deletePlayer(appFrame appFrame)
    {
        this.appFrame = appFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // check if playerID is valid
        try
        {
            // get details of the player to be removed
            appFrame.removePlayer();

            // update playerBox
            appFrame.getToolBar().getPlayerBox().update();
        }
        catch (NullPointerException npe)
        {
            System.out.println("*Error*: Please enter a valid playerID.");
        }
    }
}
