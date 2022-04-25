package ch00;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseFile extends JFrame implements ActionListener{

	JPanel panel;
	
	
	// 서버
	JButton saveBtn;
	
	
	// 클라이언트
	JButton connectBtn;
	
	
	public BaseFile() {
		initData();
		setInitLayout();
	}
	
	protected void initData() {
		setVisible(true);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	private void setInitLayout() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
