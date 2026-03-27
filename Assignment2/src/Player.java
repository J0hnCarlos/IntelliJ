import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Start of class
// No bugs is found
public class Player {

    // Declaring variables
    private BufferedImage playerALive;
    private BufferedImage playerDead;
    private BufferedImage playerCurrent;
    private int playerX, playerY; // Player coordinates can be X and Y. playerX and playerY is only for simplicity purposes
    private int stepSize;
    private boolean isPressed;
    private char key;

    // Setting variable with its images
    public Player(int playerX, int playerY) {
        try {
            this.playerALive = ImageIO.read(new File("player-alive.png"));
            this.playerDead = ImageIO.read(new File("player-dead.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Gets player's coordinates
        this.playerX = playerX;
        this.playerY = playerY;
        // Sets image player alive to current as player is still alive during the start of the game
        this.playerCurrent = playerALive;
        // step size is movement speed
        this.stepSize = 5;
    }

    // this is where the player can move in all directions
    public void performAction() {
        // Firstly, checks if the button is pressed
        if (this.isPressed) {

            // This section checks which button is pressed and run a program that is corresponding to the character letter from GameManager
            if (this.key == 'L') {
                moveLeft();
            }

            if (this.key == 'R') {
                moveRight();
            }

            if (this.key == 'U') {
                moveUp();
            }

            if (this.key == 'D') {
                moveDown();
            }
        }
    }

    // This takes input from GameManager and store it in this class
    public void setKey(char move, boolean b) {
        this.isPressed = b;
        this.key = move;
    }

    // Gets player's X coordinates and stores it in this class
    public int getX() {
        return this.playerX;
    }

    // Gets player's Y coordinates and stores it in this class
    public int getY() {
        return this.playerY;
    }

    // The program will run this code if the player meets the losing condition. I.e If the enemies touches the egg or the player
    public void die() {
        // Changes the player image to a dead version
        this.playerCurrent = this.playerDead;
    }

    // Display the image from the variable playerCurrent
    public BufferedImage getCurrentImage() {
        return this.playerCurrent;
    }

    // The code to make player move right, left, up and down
    public void moveRight() {
        this.playerX = this.playerX + stepSize;
    }

    public void moveLeft() {
        this.playerX = this.playerX - stepSize;
    }

    public void moveUp() {
        this.playerY = this.playerY - stepSize;
    }

    public void moveDown() {
        this.playerY = playerY + stepSize;
    }
}