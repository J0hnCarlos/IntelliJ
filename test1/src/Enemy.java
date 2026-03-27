import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
	
	private int x;
	private int y;
	private int m;
	private int n;
	
	private BufferedImage imageCurrent;
	private BufferedImage imageOver;
	private BufferedImage imageRunning;
	
	private GameManager gameManager;
	
	public Enemy (GameManager inputGM, int Input1, int Input2) {
		
		try {
			this.imageRunning = ImageIO.read(new File("enemy-alive.png"));
			this.imageOver = ImageIO.read(new File("enemy-dead.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.x = Input1;
		this.y = Input2;
		this.gameManager = inputGM;
		
		this.imageCurrent = this.imageRunning;	
	}
	
	public void performAction() {
		
	}
	
	public void die() {
		this.imageCurrent = this.imageOver;
	}
	
	public BufferedImage getCurrentImage() {
		return this.imageCurrent;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
