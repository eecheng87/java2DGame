package javaGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mario implements KeyListener{
	private int cor_x;
	private int cor_y;
	private int money;
	private int state; // control which sprite will be set
	private boolean alive;
	
	Mario(){
		alive = true;
		cor_x = 12;
		cor_y = 10;
		money = 0;
	}
	
	public int getX() {
		return cor_x;
	}
	public int getY() {
		return cor_y;
	}
	public int getMoney() {
		return money;
	}
	public int getState() {
		return state;
	}
	public void setState(int i) {
		this.state = i;
	}
	public boolean getAlive() {
		return alive;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_UP:
				cor_x = cor_x -1;
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("DOWN");
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("right");
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("left");
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
