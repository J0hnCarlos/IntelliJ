package app;

import view.appFrame;

import javax.swing.*;

public class DiceGameStart {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new appFrame();
            }
        });
    }
}
