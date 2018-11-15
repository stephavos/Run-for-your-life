package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.ILevel;

public class Frame extends JFrame implements KeyListener, IView {
	
	private static final long serialVersionUID = -7393744101067014109L;
	private int width;
	private int height;
	private Display display;
	private ILevel level;

	public Frame(ILevel level) {
		this.level = level;
		this.width=level.getWidth()*level.getPixels();
		this.height=(level.getHeight()+1)*level.getPixels();
		this.display = new Display(this.level);
		this.setTitle("TNTRunner");
		this.setContentPane(this.display);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.addKeyListener(this);
		this.setVisible(true);
	}



	/**
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_RIGHT: level.getPlayer().moveRIGHT();break;
			case KeyEvent.VK_LEFT: level.getPlayer().moveLEFT();break;
			case KeyEvent.VK_UP: level.getPlayer().moveUP();break;
			case KeyEvent.VK_DOWN: level.getPlayer().moveDOWN();break;
			default:break;
		}	 
	}

	public final void keyTyped(final KeyEvent keyEvent) {
		// this.keyCodeToUserOrder(keyEvent.getKeyCode());
	}
	    
	/**
	 * Repaint the components.
	 */ 
	public void repaint() {
		this.display.repaint();
	}

	
	/**
	 * Get the display.
	 * 
	 * @return the display
	 */
	public Display getDisplay() {
		return display;
	}
	
	/**
	 * Get the width.
	 * 
	 * @return the width
	 */
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

	public void setDisplay(Display Display) {
		this.display = Display;
	}
	
	@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}