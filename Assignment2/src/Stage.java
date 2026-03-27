import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Start of the class
// No bugs is found
public class Stage {
    private BufferedImage gameoverBackground;
    private BufferedImage background;
    private BufferedImage startBackground;

    // This constructor sets the variables for gameoverbackground and start background then sets the variable background (for simplicity purposes)
    public Stage() {
        try {
            gameoverBackground = ImageIO.read(new File("stage-gameover.png"));
            startBackground = ImageIO.read(new File("stage-normal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.background = this.startBackground;
    }

    // This changes a background picture inside the variable background
    public void setGameOverBackground() {
        this.background = this.gameoverBackground;
    }

    // This returns the image in the variable background
    public Image getCurrentImage() {
        return this.background;
    }
}