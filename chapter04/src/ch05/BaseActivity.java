package ch05;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseActivity extends JFrame {

	String name;
	JPanel panel;
	
	public BaseActivity(String name) {
		this.name = name;
		initData();
		setInitLayout();
	}

	protected void initData() {
		setTitle(this.name);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		System.out.println("BaseActivity init Data");
		
	}

	protected void setInitLayout() {
		setVisible(true);
		add(panel);
		System.out.println("BaseActivity layout Data");
	}
	
	
	
	
}
