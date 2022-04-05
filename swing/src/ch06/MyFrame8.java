package ch06;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame8 extends JFrame implements ActionListener {

	// !!! 변수의 효용 !!!

	ImagePanel panel1;
	BufferedImage bgImage;
	BufferedImage imageIcon;

	// 내부 클래스 선언 - paint

	// 이벤트 리스너 등록 1, 2, 3
	public MyFrame8() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			imageIcon = ImageIO.read(new File("icon4.png"));
			bgImage = ImageIO.read(new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setInitLayout() {
		setVisible(true);
		add(new ImagePanel());
	}

	// 다형성
	private void addEventListener() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	// 내부 클래스
	private class ImagePanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, 500, 500, null);
			g.drawImage(imageIcon, 0, 0, 100, 100, null);

		}

	} // end of inner class

	// 메인
	public static void main(String[] args) {
		new MyFrame8();
	}

} // end of outter class
