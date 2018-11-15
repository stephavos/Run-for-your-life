package model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Level implements ILevel{
	public IPlayer player;
	private int width = 30;
	private int height = 20;
	private int pixels = 30;
	private ITimer timer = new Timer();
	public IPlayer getPlayer() {
		return player;
	}
	
	
	public Level() {
		this.generate();
		this.placePlayer();
		
	}


	private ArrayList<ITile> map;
	
	
	public void generate() {
		setMap(new ArrayList<ITile>());
		for(int posx = 0 ; posx < width ; posx ++) {
			for(int posy = 0 ; posy < height ; posy ++ ) {
				if(posx == 0 || posx == width-1 || posy == 0 || posy == height-1)
					
					getMap().add( new Tile(posx,posy,Color.black));
				else {
					Random rand = new Random();
					int  r = rand.nextInt(100);
					if(r>85) {
						getMap().add(new Tile(posx,posy,Color.black));
					}
					else {
						getMap().add(new Tile(posx,posy,Color.GRAY));
					}
					
					
				}
				
				
			}
		}
		
		
		
	}
	
	public void placePlayer() {
		boolean validate = false;
		do {
			Random rand = new Random();
			int  posx = rand.nextInt(width);
			rand = new Random();
			int  posy = rand.nextInt(height);
			
			for (ITile element : getMap()) {
				if(posx == element.getX() && posy ==element.getY() && element.getColor()==Color.GRAY)
					validate=true;
					player = new Player(posx, posy,this);
			}
		}while(!validate);
		
		
		
	}

	public ArrayList<ITile> getMap() {
		return map;
	}

	public void setMap(ArrayList<ITile> map) {
		this.map = map;
	}

	public int getPixels() {
		return pixels;
	}

	public void setPixels(int pixels) {
		this.pixels = pixels;
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


	public ITimer getTimer() {
		return timer;
	}


	public void setTimer(ITimer timer) {
		this.timer = timer;
	}

	
	
}