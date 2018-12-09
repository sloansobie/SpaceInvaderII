package PicturePackage_II;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

public class Bomb {

	static private int xCoord = 0;
	static private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;


	public static void setyCoord(int yCoord) {
		Bomb.yCoord = yCoord;
	}

	public Bomb() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("..WebPictures/Bomb.png");

	}

		public Bomb (int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);

			

		

	}


		
		public void moveIt(int direction, int w, int h) {

	     	}


 		

		public void setImg(String imgpath) {
			this.img = Toolkit.getDefaultToolkit().getImage(imgpath); 

	

		}

		public int getxCoord() {
			return xCoord;

		}

		public void setxCoord(int xCoord) {
			this.xCoord = xCoord;

		}

		public float getyCoord() {
			return yCoord;

		}

		public void setyCoord(float f) {
			this.yCoord = yCoord;

		}

		public int getWidth() {
			return width;

		}

		public void setWidth(int width) {
			this.width = width;

		}

		public int getHeight() {
			return height;

		}

		public void setHeight(int height) {
			this.height = height;

		}

		public Image getImg() {
			return img;

		}

		public void setImg(Image img) {
			this.img = img;

		}

		public static int size() {
			// TODO Auto-generated method stub
			return 0;

		}

		public void remove(int i) {
			// TODO Auto-generated method stub

			

		}

		public Bomb get(int i) {
			// TODO Auto-generated method stub
			return null;

		}

		public static void add(LinkedList bombs) {
			// TODO Auto-generated method stub
			
		}
		

}

