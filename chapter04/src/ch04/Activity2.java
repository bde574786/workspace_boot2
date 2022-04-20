package ch04;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 콜리 : 호출자
public class Activity2 extends BaseActivity {

	
	CallbackCheckPosition callbackCheckPosition;
	
	public void setCallbackCheckPosition(CallbackCheckPosition callbackCheckPosition) {
		this.callbackCheckPosition = callbackCheckPosition;
	}

	// 부모 클래스의 생성자를 호출해야함
	public Activity2(String name) {
		super(name);
		
		addEventListener();
	}

	private void addEventListener() {
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				callbackCheckPosition.checkPosition(x, y);
				
			}
			
		
		});
	}
	
	
	
}
