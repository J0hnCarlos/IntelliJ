package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class dieGraphics extends JFrame {
    dieGraphics() {
        setLayout(new FlowLayout());
        add(new JDie());
        add(new JDie());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
//    public static void main(String[] args) {
//        new dieGraphics();
//    }
}
class JDie extends JPanel {
    private static final int SIDE = 32;
    private static final Random r = new Random();
    private Color color = Color.black;
    private int value = getValue();
    JDie() {
        value = getValue();
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(SIDE * 7, SIDE * 7);
    }
    private int getValue() {
        return r.nextInt(6) + 1;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        switch (value) {
            case 1:
                g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
                break;
            case 2:
                g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
                g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
                break;
            case 3:
                g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
                g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
                g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
                break;
            case 4:
                g.fillRect(SIDE, SIDE, SIDE, SIDE);
                g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
                g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
                g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
                break;
            case 5:
                g.fillRect(SIDE, SIDE, SIDE, SIDE);
                g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
                g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
                g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
                g.fillRect(3 * SIDE, 3 * SIDE, SIDE, SIDE);
                break;
            case 6:
                g.fillRect(SIDE, SIDE, SIDE, SIDE);
                g.fillRect(5 * SIDE, 5 * SIDE, SIDE, SIDE);
                g.fillRect(5 * SIDE, SIDE, SIDE, SIDE);
                g.fillRect(SIDE, 5 * SIDE, SIDE, SIDE);
                g.fillRect(SIDE, 3 * SIDE, SIDE, SIDE);
                g.fillRect(5 * SIDE, 3 * SIDE, SIDE, SIDE);
                break;
        }
    }
}