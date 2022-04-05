package ch07;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveIcon extends JFrame implements KeyListener{

	private BufferedImage bgImage;
	private BufferedImage imgIcon;
	private ImagePanel imagePanel;
	
	private String bgImageFileName = "image1.jpg";
	private String imageIconFileName= "icon2.png";
	int xPoint = 200;
	int yPoint = 200;
	// 내부 클래스
	
	
	public MoveIcon() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 이미지
		try {
			bgImage = ImageIO.read(new File(bgImageFileName));
			imgIcon = ImageIO.read(new File(imageIconFileName));
		} catch (IOException e) {
			System.out.println("파일이 없습니다.");
		}
		imagePanel = new ImagePanel();
				
	}
	
	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(imagePanel);
		
	}

	private void addEventListener() {
		this.addKeyListener(this);
	}
	
	private class ImagePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(imgIcon, xPoint, yPoint, 100, 100, null);
		
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_UP) {
//			yPoint -= 10;
			yPoint = (yPoint < 0) ? 0 : yPoint - 10;
		} else if (k == KeyEvent.VK_DOWN) {
			yPoint = (yPoint > 500) ? 500 : yPoint + 10;
		} else if(k == KeyEvent.VK_LEFT) {
			xPoint = (xPoint < 0) ? 0 : xPoint - 10;
		} else if(k == KeyEvent.VK_RIGHT) {
			xPoint = (xPoint > 500) ? 500 : xPoint + 10;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}
	public static void main(String[] args) {
		new MoveIcon();
	}
}