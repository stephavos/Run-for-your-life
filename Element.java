package model;

import java.awt.Color;
import java.util.Observable;

public abstract class Element extends Observable{
	
	protected int x;
	protected int y;
	private Color color;
	
	public Element(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}
	
	
	

}