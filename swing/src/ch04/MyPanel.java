package ch04;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;


	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	

	public MyPanel() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("도전과제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

		panel1 = new JPanel();
		panel1.setBackground(Color.RED);

		panel2 = new JPanel();
		panel2.setBackground(Color.blue);

		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		button4 = new JButton("button4");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new GridLayout(2, 1));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

		add(panel1);
		add(panel2);

		panel1.add(button1);
		panel1.add(button2);

		panel2.add(button3);
		panel2.add(button4);
		
	}


	 public void addEventListener() {
	        button1.addActionListener(this);
	        button2.addActionListener(this);
	        button3.addActionListener(this);
	        button4.addActionListener(this);
	    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton selectedBtn = (JButton) e.getSource();

		if (selectedBtn.getText().equals(this.button1.getText())) {
			panel1.setBackground(Color.BLACK);
		} else if(selectedBtn.getText().equals(this.button2.getText())) {
			panel1.setBackground(Color.GREEN);
		} else if(selectedBtn.getText().equals(this.button3.getText())) {
			panel2.setBackground(Color.LIGHT_GRAY);
		} else {
			panel2.setBackground(Color.orange);
		}

	}

	public static void main(String[] args) {
		new MyPanel();
	}

}
