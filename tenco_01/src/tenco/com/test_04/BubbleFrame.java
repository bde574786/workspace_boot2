package tenco.com.test_04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		
		setVisible(true);
	
	}
	
	private void initObject() {
		// 예외처리를 하지 않아도 되지만 디버깅하기 어려움
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));
		setContentPane(backgroundMap);
		
		player = new Player();
		add(player);
	}
	
	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // absolute (좌표값으로 자유롭게 그림을 그릴 수 있다)
		
		setLocationRelativeTo(null); // JFrame 가운데 배치하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
	
}
