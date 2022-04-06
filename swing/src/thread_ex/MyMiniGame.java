package thread_ex;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMiniGame extends JFrame {

	BufferedImage image1;
	BufferedImage image2;
	BufferedImage image3;

	JPanel bottomPanel;

	GridLayout gridLayout;
	JButton moveButton;
	JButton stopButton;

	private CustomJpanel customJpanel;

	private final String image1Url = "image2.jpg";
	private final String image2Url = "icon4.png";
	private final String image3Url = "icon2.png";
	int x, y = 0;
	int xPosition = 0;

	public MyMiniGame() {
		bottomPanel = new JPanel();

		customJpanel = new CustomJpanel();
		moveButton = new JButton("move");
		stopButton = new JButton("stop");

		initData();
		setInitLayout();
		addEventListener();
		// 생성자에서 Thread start 처리
		new Thread(customJpanel).start();
	}

	public void initData() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			image1 = ImageIO.read(new File(image1Url));
			image2 = ImageIO.read(new File(image2Url));
			image3 = ImageIO.read(new File(image3Url));
		} catch (Exception e) {
			System.out.println("파일이 없습니다");
		}
		// 파일 가져오기 TODO
	}

	public void setInitLayout() {
		setVisible(true);
		add(customJpanel);
		
		this.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new GridLayout(1, 2));
		bottomPanel.add(moveButton);
		bottomPanel.add(stopButton);
//		moveButton.addActionListener(moveAction);
//		stopButton.addActionListener(stopAction);
	}

	public void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int k = e.getKeyCode();
				if (k == KeyEvent.VK_UP) {
//					yPoint -= 10;
					y = (y < 0) ? 0 : y - 10;
				} else if (k == KeyEvent.VK_DOWN) {
					y = (y > 500) ? 500 : y + 10;
				} else if (k == KeyEvent.VK_LEFT) {
					x = (x < 0) ? 0 : x - 10;
				} else if (k == KeyEvent.VK_RIGHT) {
					x = (x > 500) ? 500 : x + 10;
				}

				repaint();
			}

		});

	}

	private class CustomJpanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 이미지를 그리기 3개 TODO
			g.drawImage(image1, 0, 0, 600, 600, null);
			g.drawImage(image2, x, y, 100, 100, null);
			g.drawImage(image3, xPosition, 400, 100, 100, null);
		}

		@Override
		public void run() {
			boolean direction = true;
			// 이미지 3번을 좌 우
			// whlie(true) {} <-- 이미지 하나를 >>>>> <<<<<<
			// x좌표값을 +
			// max 확인하고
			// x좌표값을 -
			// 그림을 다시 그려주세요.
			while (true) {
				if (direction) {
					xPosition += 10;
				} else {
					xPosition -= 10;
				}

				if (xPosition == 500) {
					direction = false;
				}

				if (xPosition == 0) {
					direction = true;
				}

				try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
				}

				repaint();
			}

		}
	}

	// Thread.sleep(???);

	public static void main(String[] args) {
		new MyMiniGame();
	}

}
