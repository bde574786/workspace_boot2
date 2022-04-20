package ch04;

import java.awt.Color;

public class Activity1 extends BaseActivity {

	// 변수, 초기화 (콜백 메서드)
	CallbackCheckPosition callback = new CallbackCheckPosition() {
		
		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name + "가 콜백을 받았습니다." + x);
			System.out.println(name + "가 콜백을 받았습니다." + x);
		}
	};
	
	
	
	// 부모 클래스의 생성자를 호출해야함
	public Activity1(String name) {
		super(name);
		
	}

	
	@Override
	protected void initData() {
		super.initData();
	}
	
	// 슈퍼에서 부모 기능 동작
	// 자기의 기능을 다음으로 수행
	@Override
	protected void setInitLayout() {
		super.setInitLayout();
		panel.setBackground(Color.blue);
	}
	
	
	
	
}
