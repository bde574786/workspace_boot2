package tenco.com.test_04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{
	
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
	
	
	
	
}
