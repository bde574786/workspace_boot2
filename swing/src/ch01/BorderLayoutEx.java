package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame {

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private BorderLayout borderLayout;
	
	
	
	public BorderLayoutEx() {
		//super 생략
		// 레이아웃 이름 지정
		setTitle("테스트1");
		// 레이아웃 크기
		setSize(500, 500);
		// 레이아웃 보이게 하기 디폴트 false
		setVisible(true);
		// 레이아웃 끄면 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initData();
		setInitLayout();
	}

	private void initData() {
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		borderLayout = new BorderLayout();
	}

	private void setInitLayout() {
		this.setLayout(borderLayout);
		
		this.add(button1, BorderLayout.NORTH);
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		
		new BorderLayoutEx();
	}
	
}
