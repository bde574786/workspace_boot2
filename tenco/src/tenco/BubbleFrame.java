package tenco;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{

	
	private JLabel backgroundMap;
	private Player player;
	
	
	public BubbleFrame(){
		initObject();
		initSetting();
		initListener();
		setVisible(true);
		
	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap"));
		setContentPane(backgroundMap); 
		
		player = new Player();
		add(player);
	}
	
	private void initSetting() {
		setSize(100, 640);
		setLayout(null);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initListener() {
		
		
	}
	
	
}
