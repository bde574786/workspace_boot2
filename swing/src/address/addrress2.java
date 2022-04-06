package address;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class addrress2 extends JFrame {

	
	JPanel backgroundPanel;
	JPanel infoPanel;
	
	JButton addButton;
	
	
	public addrress2() {
		setTitle("주소록 추가하기");
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initData();
		setLayout();
	}
	
	public void initData() {
		
		backgroundPanel = new JPanel();
		infoPanel = new JPanel();
		addButton = new JButton("추가하기");
		
		addButton.setPreferredSize(new Dimension(400, 40));
	}
	
	public void setLayout() {
		
		this.setLayout(new BorderLayout());
		this.add(addButton, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		new addrress2();
	}
	
	
	
}
