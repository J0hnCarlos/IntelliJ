
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;

public class Stage {
	
	private BufferedImage imageCurrent;
	private BufferedImage imageRunning;	
	private BufferedImage imageOver;
	
	public Stage () {
		try {
			this.imageRunning = ImageIO.read(new File("stage-normal.png"));
			this.imageOver = ImageIO.read(new File("stage-gameover.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.imageCurrent = this.imageRunning;
	}
	
	public void setGameOverBackground () {
		this.imageCurrent = this.imageOver;
	}
	
	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}
}
