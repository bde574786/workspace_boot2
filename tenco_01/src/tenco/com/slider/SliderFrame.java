package tenco.com.slider;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SliderFrame extends JFrame {

	private JLabel bgMap;
	int pointX = 0;
	int pointY = 0;

	public SliderFrame() {
		initObject();
		initSetting();
		initListener();

	}

	private void initObject() {
		
		bgMap = new JLabel(new ImageIcon("images/marioBackgroundMap.gif"));

		setSize(2500, 1100);
		setVisible(true);
		setResizable(true);
		setLocationRelativeTo(this);
	}

	private void initSetting() {
		setContentPane(bgMap);
	}

	private void initListener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					System.out.println("왼쪽 방향키 눌림");
					new Thread(new Runnable() {
						@Override
						public void run() {

							for (int i = 0; i < 50; i++) {
								bgMap.setLocation(pointX, pointY);
								pointX++;
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}).start();
					break;

				case KeyEvent.VK_RIGHT:
					System.out.println("오른쪽 방향키 눌림");
					new Thread(new Runnable() {

						@Override
						public void run() {

							for (int i = 0; i < 50; i++) {
								bgMap.setLocation(pointX, pointY);
								pointX--;
								try {
									Thread.sleep(10);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						}
					}).start();

				default:
					break;
				}
			}

		});

	}

	public static void main(String[] args) {
		new SliderFrame();
	}

} // end of class
