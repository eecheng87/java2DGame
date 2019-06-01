package javaGame;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java_GUI.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Game extends Canvas implements Runnable{

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 930;
	public final String TITLE = "Game";
	public static int score=0;
	public static int count=0;
	public static String usrName;
	
	private final int updateTime = 2;
	private boolean running = false;
	private static JPanel map ;
	private Thread thread;
	private static Mario mario = new Mario();
	private static JFrame frame;
	private static boolean shutDown=false;
	private static boolean gameOverMsgShow=false;
	private synchronized void start() {
		if(running) {
			
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run() {
		long start = System.nanoTime();
		long elapse;
		while(running) {
			elapse = System.nanoTime()-start;
			
			if(elapse/100000000>updateTime) {
				/*
				 * 
				 * update frame
				 */
				
				Random rand = new Random();
				score+=rand.nextInt(11);
			
				if(!mario.getAlive()) {
					/*
					 *  game over!
					 */
					Game_Over_Window gow;
					if(!gameOverMsgShow) {
						gow = new Game_Over_Window();
						gameOverMsgShow = true;
					}
					shutDown=true;
				}
				((Map) map).display();

				start = System.nanoTime();
				
			}
			
		}
		stop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		//Mario mario = new Mario();
		
		Login_Window login_window = new Login_Window();
		
		while(!login_window.is_close)
			usrName = login_window.enter_field_username.getText();
		
		System.out.println("usrName = " + usrName);
		
		//System.out.print("B");
		game.start();
 
		frame = new JFrame();
		map = new Map(mario);
		mario.setMap(map);
		frame.addKeyListener(mario);
		frame.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		frame.setMinimumSize(new Dimension(WIDTH,HEIGHT));
	
		frame.add(game);
		frame.add(map);
		map.setPreferredSize(new Dimension(50,50));
		map.setMaximumSize(new Dimension(50,50));
		map.setMinimumSize(new Dimension(50,50));		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		while(!shutDown)System.out.print("");
		write_score();
		frame.setVisible(false);
		frame.dispose();
		//System.exit(0);
	}
	
	public static void write_score()
	{
		PrintWriter score_writer;
		
		try
		{
			// Keep the new account.
			score_writer = new PrintWriter(new FileOutputStream("src/java_GUI/SCORE" + "_" + usrName + ".txt"));
			score_writer.println(usrName + " " + score);
			score_writer.flush();
			score_writer.close();
		}
		catch (FileNotFoundException exception)
		{
			exception.printStackTrace();
		}
		
	}
}
