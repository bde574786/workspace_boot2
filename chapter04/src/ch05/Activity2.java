package ch05;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Key;

// 콜리 : 호출자
public class Activity2 extends BaseActivity {

	CallbackCheckPosition callbackCheckPosition;
	
	public void setCallbackCheckPosition(CallbackCheckPosition callbackCheckPosition) {
		this.callbackCheckPosition = callbackCheckPosition;
	}




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
