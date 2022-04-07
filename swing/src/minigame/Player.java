package minigame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	private ImageIcon Player;
	
	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		Player = new ImageIcon("images/icon4.png");
	}
	
	private void initSetting() {
		x = 50;
		y = 500;
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		setIcon(Player);
		setSize(50,50);
		setLocation(x, y);
		
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
