package tenco.com.test_13;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 메인 쓰레드 바쁨 --> 키보드 이벤트 처리
// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

	public BackgroundPlayerService(Player player) {
		this.player = player;

		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// 도전과제 ! 던지거나 처리
		// 색상 확인
		while (true) {

			// 자바의 좌표 기준은 왼쪽 위, 아이콘 크기 50, 50
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));  //   
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
								+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

			// -2 가 아니라면 !!!. 바닥 충돌 확인 
			if (bottomColor != -2) {
				player.setDown(false);
			} else { // 바닥 색깔이 하얀색
				// 점프 하는 순간 down 메서드가 호출
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
			}
			
			
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}


			try {
				// 캐릭터가 이동 될 때 값을 못 찾는 경우가 있다.
				// 이동 속도보다 더 빠르게 움직여야 해결 가능
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
