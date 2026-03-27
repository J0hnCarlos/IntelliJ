package view;

import controller.addPlayer;
import controller.deletePlayer;
import controller.exit;
import model.interfaces.GameEngine;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menu extends JMenuBar{
    private static final long serialVersionUID = 1L;

    public menu(GameEngine gameEngine, appFrame appFrame)
    {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        this.add(fileMenu);

        // add player function
        JMenuItem addPlayerItem = new JMenuItem("Add player", KeyEvent.VK_A);
        addPlayerItem.addActionListener(new addPlayer(appFrame));

        // remove player function
        JMenuItem removePlayerItem = new JMenuItem("Remove player", KeyEvent.VK_R);
        removePlayerItem.addActionListener(new deletePlayer(appFrame));

        // exit function
        JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_E);
        exitItem.addActionListener(new exit(appFrame));

        // add menu items
        fileMenu.add(addPlayerItem);
        fileMenu.add(removePlayerItem);
        fileMenu.add(exitItem);
    }
}
