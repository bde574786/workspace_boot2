package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyPaint extends JFrame {

	MyPanel myPanel;
	
	
	public MyPaint() {
		initData();
		setInitLayout();
	}
	
	
	private void initData() {
		setTitle("직접 그려보기 연습");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel = new MyPanel();
		
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(myPanel);
		
	}
	
	public static void main(String[] args) {
		new MyPaint();
	}
	
	private class MyPanel extends JPanel {
		
		// 내부 클래스
		@Override
		public void paint(Graphics g) {
			// 무조건 호출되어야 동작
			super.paint(g);
			g.drawString("안녕 Java 2D ~ ", 100, 200);
		
			g.drawLine(20, 30, 100, 100);
			
			g.drawRect(300, 500, 150, 150);
		}
	}

	
}
