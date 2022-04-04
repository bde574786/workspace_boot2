package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel1 extends JPanel {

	@Override
	public void paint(Graphics g) {
		// 무조건 호출되어야 동작
		super.paint(g);
		g.drawString("바둑이 집", 380, 150);

		g.drawLine(300, 350, 400, 200);
		g.drawLine(400, 200, 500, 350);

		g.drawLine(450, 400, 400, 400);
		g.drawLine(400, 450, 400, 400);
		g.drawLine(450, 450, 450, 400);
		g.drawLine(400, 450, 450, 450);

		g.drawLine(400, 425, 450, 425);
		g.drawLine(425, 400, 425, 450);

		g.drawLine(430, 400, 450, 425);
		g.drawLine(425, 400, 425, 450);

		g.drawRect(300, 350, 200, 200);
	}

}

public class MyHouseFrame extends JFrame {

	MyPanel1 panel1;

	public MyHouseFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("직접 그려보기 연습");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new MyPanel1();

	}

	private void setInitLayout() {
		setVisible(true);
		add(panel1);

	}

	public static void main(String[] args) {
		new MyHouseFrame();
	}

}
