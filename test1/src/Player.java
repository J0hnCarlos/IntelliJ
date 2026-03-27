import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Player {
	
	private int x;
	private int y;
	
	private BufferedImage imageCurrent;
	private BufferedImage imageRunning;
	private BufferedImage imageOver;
	
	private int stepSize;
	private Random rng;
	
	public Player (int x, int y) {
		try {
			this.imageRunning = ImageIO.read(new File("player-alive.png"));
			this.imageOver = ImageIO.read(new File("player-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x=x;
		this.y=y;
		this.stepSize=10;
      
		this.rng=new Random(x+y); 
		this.imageCurrent = this.imageRunning;
	}
	public void performAction() {
		
	}
	
	public void die() {
		this.imageCurrent = this.imageOver;
		return;
	}
	
	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}
	
	public void setKey (char Input1, boolean flag) {
		
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
