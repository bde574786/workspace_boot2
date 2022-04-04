package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MyImageFrame1 extends JFrame {

	
	private ImagePanel ImagePanel;
	
	
	public MyImageFrame1() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("JPanel에 이미지 넣기");
		setSize(500,500);
		//ImagePanel = new ImagePanel();
	}
	
	
	private void setInitLayout() {
		setVisible(true);
		add(new ImagePanel());
	}
	
	
	public static void main(String[] args) {
		new MyImageFrame1();
	}
	
	private class ImagePanel extends JPanel{
		
		private Image image;
		
		
		public ImagePanel() {
			image = new ImageIcon("image1.jpg").getImage();
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
		
		
		
	} // end of inner class
	
	
}	// end of outter class
