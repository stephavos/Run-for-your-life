package model;

import java.awt.Color;

public class Player extends Element implements IPlayer{
	private boolean alive = true;
	public Level level;
	
	public Player(int x, int y, Level level) {
		super(x, y);
		this.setColor(Color.GREEN);
		this.level=level;
	}
	
	
	public void moveToXY(int x , int y) {
		for (ITile elem : level.getMap()) {
			if(elem.getX() == this.x && elem.getY()==this.y) {
				if(elem.getColor()==Color.BLACK) {
					this.setAlive(false);
					System.out.println("Dead");
				}
				elem.setActivated(true);
				
			}
			
		}
		
		
		this.x=x;
		this.y=y;
		this.setChanged();
		this.notifyObservers();
		
		//tue le joueur si sur du noir
		for (ITile elem : level.getMap()) {
			if(elem.getX() == this.x && elem.getY()==this.y) {
				if(elem.getColor()==Color.BLACK) {
					this.setAlive(false);
					System.out.println("Dead");
				}
				elem.setActivated(true);
				
			}
			
		}
	}
	
	
	public void moveUP()    {this.moveToXY(x, y-1);}
	public void moveDOWN()  {this.moveToXY(x, y+1);}
	public void moveLEFT()  {this.moveToXY(x-1, y);}
	public void moveRIGHT() {this.moveToXY(x+1, y);}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}