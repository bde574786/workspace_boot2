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
		bgMap = new JLabel(new ImageIcon("images/backgroundMap.png"));

		setSize(400, 400);
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
				case KeyEvent.VK_RIGHT:

					new Thread(new Runnable() {
						@Override
						public void run() {

							for (int i = 0; i < 100; i++) {
								bgMap.setLocation(pointX, pointY);
								pointX++;
								try {
									Thread.sleep(3);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}).start();
					break;

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
