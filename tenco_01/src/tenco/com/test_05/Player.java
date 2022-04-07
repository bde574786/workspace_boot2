package tenco.com.test_05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable{
	
	private int x;
	private int y;
	
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}
	
	private void initSetting() {
		x = 80;
		y = 500;
		
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
		
	}

	
	@Override
	public void left() {
		setIcon(playerL);
		x = x - 10;
		setLocation(x, y);
		
	}

	@Override
	public void right() {
		setIcon(playerR);
		x = x + 10;
		setLocation(x, y);
		
	}

	@Override
	public void up() {

		System.out.println("점프");
	}

	
	
	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
