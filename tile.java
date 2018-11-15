package model;

import java.awt.Color;

public class Tile extends Element implements ITile{

	public Tile(int x, int y , Color color) {
		super(x, y);
		this.setColor(color);
		if(color == Color.BLACK) {
			this.counter = 0;
		}
		else {this.counter=500;}
	}
	
	
	private boolean activated= false;
	private int counter;
	
	
	
	
	
	
	public void reduce() {
		if(activated) {
			this.counter --;
			this.setColor(Color.red);
			this.setChanged();
			this.notifyObservers();
		}
		if(counter<=0)
			this.setColor(Color.black);
		
	}
	
	public int getCounter() {
		return this.counter;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	

}