package javaGame;

public class Mario {
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
}
