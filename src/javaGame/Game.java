package javaGame;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas implements Runnable{

	public static final int WIDTH = 1200;
	public static final int HEIGHT = 930;
	public final String TITLE = "Game";
	
	private final int updateTime = 3;
	private boolean running = false;
	private static JPanel map ;
	private Thread thread;
	private static Mario mario = new Mario();
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
				if(!mario.getAlive()) {
					/*
					 *  game over!
					 */
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
		
		
		
		game.start();
 
		JFrame frame = new JFrame();
		map = new Map(mario);
		
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
		
		
		
	}

}
