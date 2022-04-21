package file_io.ch04;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BaseProgram extends JFrame {

	String name;
	JLabel label;
	
	public BaseProgram(String name) {
		this.name = name;
		initData();
		setInitLayout();
	}

	protected void initData() {
		setTitle(name);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel();
	}

	protected void setInitLayout() {
		setVisible(true);
		
	}
	
	
}
