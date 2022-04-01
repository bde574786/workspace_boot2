package ch02;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutEx extends JFrame {

	// 배열, ArrayList
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private FlowLayout flowLayout;
	private GridLayout gridLayout;

	public GridLayoutEx() {
		initData();
		setInitData();
	}

	private void initData() {

		setTitle("그리드 레이아웃 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

		button1 = new JButton("가");
		button2 = new JButton("나");
		button3 = new JButton("다");
		button4 = new JButton("라");
		button5 = new JButton("마");
		gridLayout = new GridLayout(3,2);
	}

	private void setInitData() {
		setVisible(true);
		setLayout(gridLayout);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
	}

	public static void main(String[] args) {
		new GridLayoutEx();
	}
	
}
