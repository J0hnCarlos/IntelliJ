import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.*;

public class Goal {
	private int x;
	private int y;
	private BufferedImage imageCurrent;
	private BufferedImage imageRunning;
	private BufferedImage imageOver;
   
	private int stepSize;
   private Random rng; // Tip: Code that students write must not use randomness

	public Goal(int x, int y) {		
		try {
			this.imageRunning = ImageIO.read(new File("goal-alive.png"));
			this.imageOver    = ImageIO.read(new File("goal-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
  		this.x=x;
		this.y=y;
      this.stepSize=10;
      
      this.rng=new Random(x+y); // Tip: Code that students write (elsewhere) must not use any randomness.

		this.imageCurrent = this.imageRunning;
      return;
	}
   
   public void performAction() {
      // The code below shows how the Goal can be moved by manipulating its x and y coordinates.
      // Tip: Code that students write (elsewhere) must not use any randomness.
      this.x+= this.rng.nextInt()%stepSize;
      this.y+= this.rng.nextInt()%stepSize;
      return;
	}


	public int getX() {
		return this.x;
	}

	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}

	public void die() {
		this.imageCurrent = this.imageOver;
      return;

	}

	public int getY() {
		return this.y;
	}


}
