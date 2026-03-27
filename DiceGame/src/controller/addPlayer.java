package controller;

import view.appFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPlayer  implements ActionListener {
    private appFrame appFrame;

    public addPlayer(appFrame appFrame)
    {
        this.appFrame = appFrame;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        // get details of the player and add the player
        appFrame.addPlayer();
    }
}
