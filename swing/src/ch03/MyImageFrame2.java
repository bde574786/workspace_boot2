package ch03;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame2 extends JFrame {

	// 코드를 조금 수정해주세요
	// 상수, 스태틱 활용해서 처리해주세요
	
	
	private BufferedImage backgroundImage;
	private BufferedImage imageIcon;
	private MyImagePanel myImagePanel;
	private Button button;
	
	private final String backgroundUrl = "image1.jpg";
	private final String imageUrl = "icon2.png";
	
			
	public MyImageFrame2() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("이미지 백그라운드 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			backgroundImage = ImageIO.read(new File(backgroundUrl));
			imageIcon = ImageIO.read(new File(imageUrl));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다.");
		}
	
		myImagePanel = new MyImagePanel();
	
	}
	
	
	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
		add(myImagePanel);
	}
	
	
	
	private class MyImagePanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 500, 500, null);
			g.drawImage(imageIcon, 0, 0, 100, 100, null);
		}
		
	} // end of inner class
	
	// 메인 함수
	public static void main(String[] args) {
		new MyImageFrame2();
		
		
	} // end of main
	
	
	public void addEventListner() {
		System.out.println("브랜치를 만들었습니다.");
	}
	
} // end of outter class



