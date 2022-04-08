package tenco;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable{

	private int x;
	private int y;
	
	private boolean right;
	private boolean up;
	private boolean down;
	private boolean left;
	
	
	
	private ImageIcon PlayerR;
	private ImageIcon PlayerL;
	
	@Override
	public void right() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void left() {
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
	
	
	public Player(){
		initObject();
		initSetting();
	}
	
	public void initObject() {
		PlayerR = new ImageIcon("images/playerR.png");
		PlayerL = new ImageIcon("images/playerL.png");
	}
	
	public void initSetting() {
		x = 80;
		y = 530;
		
		left = false;
		right = false;
		up = false;
		down = false;
		
		setIcon(PlayerR);
		setSize(50, 50);
		setLocation(x, y);
		
	}
	
	
	
	
	
	
	
	
}
