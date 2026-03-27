package controller;

import view.appFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exit implements ActionListener {
    private view.appFrame appFrame;

    public exit(appFrame appFrame)
    {
        this.appFrame = appFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // exit the game
        appFrame.exit();
    }
}
