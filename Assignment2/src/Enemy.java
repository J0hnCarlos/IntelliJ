import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Start of class
// No bugs is found
public class Enemy {

    // Declare variables
    private BufferedImage enemyDead;
    private BufferedImage enemyAlive;
    private BufferedImage enemy;
    private int enemyX, enemyY; // Variables name can be X and Y. I used enemyX and enemyY for simplicity purposes
    private int stepSize;
    private Player seek;

    // Taking inputs from game manager, sets the pictures in they're specific variable
    public Enemy(GameManager gameManager, int enemyX, int enemyY) {
        try {
            enemyAlive = ImageIO.read(new File("enemy-alive.png"));
            enemyDead = ImageIO.read(new File("enemy-dead.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // the variable, seek, gets the player coordinates (X, Y)
        this.seek = gameManager.getPlayer();

        // Enemy's movement speed
        this.stepSize = 1;

        // Sets local variable (enemy) to the alive picture
        this.enemy = enemyAlive;

        // Sets the enemies coordinates
        this.enemyX = enemyX;
        this.enemyY = enemyY;
    }

    // Mechanics that lets enemy follow the player.
    // seek gives the players coordinates to the program and lets the enemy(s) decide which way to go to get closer to the player.
    // If the enemy's X coordinates is lower than the player's, it will go to the right by adding the stepSide to enemy's X coordinates
    // For example: if playerX is 10 and enemyX is 1, it means the enemy is on the left of the player thus the enemy needs to move right
    // Otherwise, the enemy will go to the left.
    // Similarly, this also happens to the Y coordinate. If enemyY is lower, it will go up. Otherwise, it will go down

    public void performAction() {
        if (this.enemyX < seek.getX()) {
            this.enemyX = this.enemyX + stepSize;
        } else {
            this.enemyX = this.enemyX - stepSize;
        }

        if (this.enemyY < seek.getY()) {
            this.enemyY = this.enemyY + stepSize;
        } else {
            this.enemyY = this.enemyY - stepSize;
        }
    }

    // Runs this code if player meets winning condition. I.e Player reached the egg
    public void die() {
        this.enemy = enemyDead;
    }

    // Gets the X coordinates from enemies
    public int getX() {
        return this.enemyX;
    }

    // Gets Y coordinates from the enemies
    public int getY() {
        return this.enemyY;
    }

    // Displays the image inside enemy from this class
    public BufferedImage getCurrentImage() {
        return this.enemy;
    }
}
