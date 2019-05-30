package javaGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
public class Mario implements KeyListener{
	private int cor_x;
	private int cor_y;
	private int money;
	private int state; // control which sprite will be set
	private boolean alive;
	private Map m;
	
	Mario(){
		alive = true;
		cor_x = 12;
		cor_y = 10;
		money = 0;
	}
	public void setMap(JPanel map) {
		m = (Map) map;
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
				System.out.println(m.getMap()[0][0]);
				/*
				 * 
				 *  m.getMap()[i][j] means get map[i][j] in current Map
				 * 
				 */
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("DOWN");
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("right");
				alive = false;
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
