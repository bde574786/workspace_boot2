package ch05;

import java.awt.Color;

public class Activity1 extends BaseActivity {

	CallbackCheckPosition callback = new CallbackCheckPosition() {

		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name + "가 콜백을 받았습니다" + x);

		}
	};

	public Activity1(String name) {
		super(name);
	}

	@Override
	protected void initData() {
		super.initData();
		System.out.println("activity1 init Data");
	}

	@Override
	protected void setInitLayout() {
		super.setInitLayout();
		panel.setBackground(Color.blue);
		System.out.println("activity1 layout Data");
	}

}
