package 주소록;

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class address extends JFrame {

	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;

	public address() {
		setTitle("주소록 메인");
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initData();
		setInitLayout();
		}

	

	private void initData() {
			
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		button1 = new JButton("주소록 전체");
		button2 = new JButton("친구");
		button3 = new JButton("회사");
		button4 = new JButton("학교");
		button5 = new JButton("가족");
		button6 = new JButton("추가");
		
		panel3.setLayout(new BorderLayout());
		panel1.setLayout(new GridLayout(2,1));
		panel2.setLayout(new GridLayout(4,1));
		
		getContentPane();
		
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		
		panel3.add(button1);
		panel3.add(panel1);
		
		panel3.add(panel1, BorderLayout.NORTH);
		panel3.add(panel2, BorderLayout.CENTER);
		panel3.add(button1, BorderLayout.SOUTH);
		
		
		
		
		
	}

	private void setInitLayout() {
		setLocationRelativeTo(null);
		panel1.add(button1);
	}

	public static void main(String[] args) {
		new address();
	}

}