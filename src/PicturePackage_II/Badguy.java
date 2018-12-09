package PicturePackage_II;


	import java.awt.Image;
import java.awt.Toolkit;



public class Badguy {

	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	private static boolean fired = false; 
	//What is a static variable
	//A static variable is a variable that is shared among all instances.  What this means is that
	//if you have 100 Badguys there is only one variable called steps that they all share.  
	//Change it for one it changes for all
	//This has memory impacts as if you have 100 badguys you don't need 100*32 bits you need 32 bits
	private static int steps = 0;
	private static int numSteps = 0;
	private static int direction = 1;
	private static int ispeed = 10;
	public static int getIspeed() {
		return ispeed;
	}

	public static void setIspeed(int ispeed) {
		Badguy.ispeed = ispeed;
	}
	private static Bomb bomb = null;

	

	public Badguy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("..WebPictures/Invader5.png");

	}

		public Badguy (int x, int y, int w, int h, String imgpath) {
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

		public Badguy get(int i) {

			// TODO Auto-generated method stub

			return null;

		}

		public void setxCoord(float f) {
			// TODO Auto-generated method stub
			
		}

		/*
		 * This is a static method because it accesses a static variable. YOU CANNOT ACCESS ANY
		 * FIELDS THAT ARE NOT STATIC
		 */
		public static void increaseStep() { steps = steps + 1; }
		public static int getSteps() { return steps; }
		public static void resetSteps() { steps = 0; }
		
	

		public static int getNumSteps() { return numSteps; }
		public static void setNumSteps(int a) { numSteps = a; }
		public static int getiSpeed() { return ispeed; }
		public static int getDirection() { return direction; }
		public static void setDirection() { direction = direction * -1; }
		public static void setBomb(Bomb b) {  bomb = b; }
		
	

}