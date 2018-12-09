package PicturePackage_II;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;

import sun.audio.*;

public class MyCanvas extends Canvas  implements KeyListener { 


	/**
	 * 
	 */

	Goodguy Bluespaceship = new Goodguy(650, 700, 60, 60, "WebPictures/Bluespaceship.png");
	LinkedList badguys = new LinkedList();
	LinkedList bomblist = new LinkedList();
	LinkedList lasers = new LinkedList();
	int width = this.getWidth();
	int timer = 0;
	int lose = 0;
	Font myFont = new Font("Cambria", 1, 45);
	boolean start = false;
	int level = 1;
	Random rand = new Random();
	boolean gameOver = false;

	int iy = 25; 
	int ix = 100;

	private Image backimg = Toolkit.getDefaultToolkit().getImage("WebPictures/Space Background.png");

	/**
	 * 
	 */
	public MyCanvas() {

		this.setSize(1450,799); // set same size as my screen
		this.addKeyListener(this);
		playIt("Sounds/spaceinvadersremix.wav");

		
		//creating every badguy?
		for (int a = 0; a<=53; a++) { 
			if( ix < 1100) {
				Badguy bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader1.png"); 
				
				if (a < 10) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader5.png"); 
				}
				else if (a > 10 && a < 21) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader4.png"); 
				}
				else if (a > 21 && a < 32) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader3.png"); 	
				}
				else if (a > 32 && a < 43) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader2.png"); 	
				}
				else {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader1.png");
				}
				
				ix += 100; 
				badguys.add(bg); 
			
			} else if ( ix >= 1100) {  
				iy = iy + 100; 
				ix = 100; 
			} 
		}
		this.setBackground(Color.WHITE);
		
		

		TimerTask repeatedTask = new TimerTask() {

			public void run() {
				
				
				
				//goes through all the bad guys
				
				
				if (Badguy.getSteps() < Badguy.getNumSteps()) {
					 
					for(int i = 0; i < badguys.size(); i++) {// draw bad guys

						//Step 1: Generate a random number from 0 to 100
						//Step 2: check if num < 10 and fired == false
						 
						 
						Badguy bg = (Badguy) badguys.get(i);
						int x = bg.getxCoord(); 
						int y = bg.getyCoord(); 
					
						
						//for (int j = 0; j<level; j++) {
						bg.setxCoord(bg.getxCoord() - (Badguy.getiSpeed()*Badguy.getDirection())*level);  
						//}
					
						if (Badguy.getSteps() >= Badguy.getNumSteps() - level) {
							bg.setyCoord(bg.getyCoord()+ 10);					
						}
					}	
				}
				
				if (Badguy.getSteps() > Badguy.getNumSteps() - level ) {
					while (Badguy.getSteps() < Badguy.getNumSteps()) {
						Badguy.increaseStep();
					}
				}
				//Badguy.increaseStep();
				else {
					for (int i = 0; i<level; i++) {
						Badguy.increaseStep();
					}
				}
				
				if (Badguy.getSteps() >= Badguy.getNumSteps()) {
					Badguy.setNumSteps(45);	
					Badguy.setDirection();
					Badguy.resetSteps();
					System.out.println(Badguy.getNumSteps()+" "+Badguy.getDirection());
					
				} 
				repaint(); 
			}			

		};

		Timer timer = new Timer("Timer");
		long delay  = 100L;
		long period = 100L;

		timer.scheduleAtFixedRate(repeatedTask, delay, period);
	}
	

	@Override 
	public void paint(Graphics g) {
		if (gameOver) {
			this.setBackground(Color.BLACK);
			Font gOver = new Font("Heveltica", 1, 50);
			g.setFont(gOver);
			g.setColor(Color.WHITE);
			Image backimg = Toolkit.getDefaultToolkit().getImage("WebPictures/GameOver.png");
			g.drawImage(backimg, 0, 0, 1450, 800,this);
			g.drawString("Click [ENTER] to play again!", 350, 680);
			
		}
		else if (!start) {
				g.setColor(Color.WHITE);
				g.setFont(myFont);
				Image backimg = Toolkit.getDefaultToolkit().getImage("WebPictures/StartGame.png");
				g.drawImage(backimg, 0, 0, 1450, 800,this);
				g.drawString("Click [ENTER] to Start", 450, 580);
		}
		else {
			int num = rand.nextInt(100);
			timer++; 
			g.drawImage(backimg, 0, 0, 1450, 800,this); 
			if (start) {
				g.setFont(myFont);
				g.setColor(Color.WHITE);
				//if (badguys.size()>0) {
					g.drawString("Level " + level, 600, 650);
				//}
				
				//g.drawImage(backimg, 0, 0, 1450, 800,this); 
				g.drawImage(Bluespaceship.getImg(), Bluespaceship.getxCoord(), Bluespaceship.getyCoord(),Bluespaceship.getHieght() , Bluespaceship.getWidth(),this);
				for(int i = 0; i < badguys.size(); i++) { // draw bad guys
					Badguy bg = (Badguy) badguys.get(i); 
					g.drawImage(bg.getImg(), (int) bg.getxCoord(), bg.getyCoord(),bg.getHeight() , bg.getWidth(),this);
					Rectangle ggr = new Rectangle(Bluespaceship.getxCoord(),Bluespaceship.getyCoord(),Bluespaceship.getWidth(),Bluespaceship.getHieght());
					Rectangle r = new Rectangle( (int) bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight()); 
					if (ggr.intersects(r)) {
						gameOver = true;
						repaint();
					}
					
					Random rand = new Random();
					if (rand.nextInt(50)<10) {
						Bomb bomb = new Bomb (bg.getxCoord(), bg.getyCoord(), 40, 40, "WebPictures/Bomb.png");
						bomblist.add(bomb);
					}
					
					/*for (int a = 0; a<bomblist.size(); a++) {
						Bomb bmb = (Bomb) bomblist.get(i);	
						//bmb.setyCoord(bmb.getyCoord() + 10);
						//bomblist.set(a, bmb);
						g.drawImage(bmb.getImg(), bmb.getxCoord(), (int) bmb.getyCoord(), bmb.getWidth() , bmb.getHeight(),this);
						//g.drawImage(bg.getImg(), (int) bg.getxCoord(), bg.getyCoord(),bg.getHeight() , bg.getWidth(),this);
					}*/
					
					

					
					for (int j = 0; j < lasers.size(); j++) {
						Projectile k = (Projectile) lasers.get(j);
						if (k.getyCoord() < 0) { 
							lasers.remove(k);
						}
						k.setyCoord((float) (k.getyCoord() - k.getpSpeed())); 
						g.drawImage(k.getImg(), k.getxCoord(), (int) k.getyCoord(), k.getWidth(), k.getHeight(), this); 	 
						Rectangle kr = new Rectangle(k.getxCoord(), (int)k.getyCoord(), k.getWidth(), k.getHeight());
						if (kr.intersects(r)) {
							badguys.remove(i); 
							lasers.remove(j);  
							System.out.println(lasers);
						if (badguys.size() == 0) {
							level++; 
							spawn();
						}
						}
					}
				} 
			}
		}
		
		repaint();
		
	}







	@Override

	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub

		
		
		/*if (e.getKeyCode() == 32) {
			Bomb bomb = new Bomb( Bluespaceship.getxCoord(), Bluespaceship.getyCoord(), 30, 30, "WebPictures/laser.png");
			Bombs.add(bomb); 
		}*/
		if (gameOver && e.getKeyCode()==10) {
			gameOver = false;
			start = false;
			while (badguys.size()>0) {
				for (int i = 0; i<badguys.size(); i++) {
					badguys.remove(i);
				}
			}
			for (int a = 0; a<=53; a++) { 
				if( ix < 1100) {
					Badguy bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader1.png"); 
					
					if (a < 10) {
					bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader5.png"); 
					}
					else if (a > 10 && a < 21) {
					bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader4.png"); 
					}
					else if (a > 21 && a < 32) {
					bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader3.png"); 	
					}
					else if (a > 32 && a < 43) {
					bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader2.png"); 	
					}
					else {
					bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader1.png");
					}
					
					ix += 100; 
					Badguy.setNumSteps(45);
					badguys.add(bg); 
				
				} else if ( ix >= 1100) {  
					iy = iy + 100; 
					ix = 100; 
				} 
			}
		}

		if (start) {
			Bluespaceship.moveIt(e.getKeyCode(), this.getWidth());
			for(int i = 0; i < badguys.size(); i++) { // check if badguys hit
				Badguy bg = (Badguy) badguys.get(i); // convert generic
				Rectangle ggr = new Rectangle(Bluespaceship.getxCoord(),Bluespaceship.getyCoord(),Bluespaceship.getHieght(),Bluespaceship.getWidth());
				Rectangle r = new Rectangle( (int) bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
				if (ggr.intersects(r)) {
					gameOver = true;
				}

			}
		}
		else {
			if (e.getKeyCode()==10) {
				start = true;
			}
		}


	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 32) {
			Projectile laser = new Projectile( Bluespaceship.getxCoord(), Bluespaceship.getyCoord(), 30, 30, "WebPictures/laser.png");
			lasers.add(laser); 
			//System.out.println(lasers);
		}
	}

	public void playIt(String filename) {
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch(IOException e) {

		}
		
	}
	
	public void spawn() {


		Badguy.setIspeed(2*Badguy.getIspeed() );
		Badguy.setNumSteps(Badguy.getNumSteps());
		int iy = 25; 
		int ix = 100;
		
		//creating every badguy?
		for (int a = 0; a<=53; a++) { 
			if( ix < 1100) {
				Badguy bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader1.png"); 
				
				if (a < 10) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader5.png"); 
				}
				else if (a > 10 && a < 21) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader4.png"); 
				}
				else if (a > 21 && a < 32) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader3.png"); 	
				}
				else if (a > 32 && a < 43) {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader2.png"); 	
				}
				else {
				bg = new Badguy( ix , iy , 50, 50, "WebPictures/Invader1.png");
				}
				
				ix += 100; 
				Badguy.setNumSteps(45/level);
				badguys.add(bg); 
			
			} else if ( ix >= 1100) {  
				iy = iy + 100; 
				ix = 100; 
			} 
		}
		this.setBackground(Color.WHITE);
		
		

		TimerTask repeatedTask = new TimerTask() {

			public void run() {
				
				
				
				//goes through all the bad guys
				
				if (Badguy.getSteps() < Badguy.getNumSteps()) {
					for(int i = 0; i < badguys.size(); i++) {// draw bad guys

						
						Badguy bg = (Badguy) badguys.get(i);
						int x = bg.getxCoord(); 
						int y = bg.getyCoord(); 
					
					
						bg.setxCoord(bg.getxCoord() - (Badguy.getiSpeed()*Badguy.getDirection()));
					
						if (Badguy.getSteps() == Badguy.getNumSteps() - 1) {
							bg.setyCoord(bg.getyCoord()+ 10);					
						}
					}
				};
			}
		};
	}
}
	

