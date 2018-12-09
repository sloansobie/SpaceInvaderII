package PicturePackage_II;

import java.awt.Image;
import java.awt.Toolkit;

public class Goodguy {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int hieght = 10;
	private Image img; 
	
	/**
	 * Goodguy default constructor
	 */
	public Goodguy() {
		setxCoord(10);
		setyCoord(1200);
		setWidth(30);
		setHieght(30);
		
		
		
	}

	/**
	 * Goodguy overload constructor
	 * @param x initial x location
	 * @param y initial y location
	 * @param w initial width
	 * @param h initial height
	 */
	public Goodguy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHieght(h);
		setImg(imgpath);
	}
	
	public void moveIt(int direction, int w) {
		int speed = 20;
		int x = getxCoord();
		int y = getyCoord();
		//int w = getWidth();
		//int h = getHieght();
		
		if (direction == 39) {
			x = x + speed;
			if (x > w) {x = x - speed *3; } // check to see if user has moved off game area
			setxCoord(x);
			setImg("WebPictures/Bluespaceship.png");
		} else if (direction == 37) {
			x = x - speed;
			if (x < 0) {x = x + speed *3; } // check to see if user has moved off game area
			setxCoord(x);
			setImg("WebPictures/Bluespaceship.png");
		}
	}
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHieght() {
		return hieght;
	}

	public void setHieght(int hieght) {
		this.hieght = hieght;
	}

	public Image getImg() {
		return img;
	}
		
	public static Goodguy get(int i) {
		// TODO Auto-generated method stub
		return null;
	}


}
	

