package tenco.com.test_14;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 스레드로 만들지 않음 !!!
// 느려진다.
public class BackgroundBubbleObserver {

	private BufferedImage image;
	private Bubble bubble;
	
	// Color 멤버 변수로 만드는게 좋은가?? -> 지역변수로 추천
	// 리팩토링 과정 ... 연습
	

	public BackgroundBubbleObserver(Bubble bubble) {
		this.bubble = bubble;
		
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다.");
		}
	}

	public boolean checkLeftWall() {
		// 1단계
		Color leftColor = new Color(image.getRGB(bubble.getX(), bubble.getY()));
		if(leftColor.getRed() == 255 && leftColor.getGreen() ==0 && leftColor.getBlue() == 0) {
			return true;
		}
		return false;
	}

	public boolean checkRightWall() {
		// 2단계
		if(isCrashColor()) {
			return true;
		}
		return false;
	}

	public boolean checkTopWall() {
		// 3단계
		return isCrashColor();
	}

	
	private boolean isCrashColor() {
		Color topColor = new Color(image.getRGB(bubble.getX(), bubble.getY()));
		if(topColor.getRed() == 255 && topColor.getGreen() ==0 && topColor.getBlue() == 0) {
			return true;
		}
		return false;
	}
	
	
	
}
