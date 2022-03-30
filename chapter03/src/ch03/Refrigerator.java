package ch03;

public class Refrigerator extends HomeAppliances implements RemoteController, SoundEffect {

	@Override
	public void turnOn() {
		System.out.println("냉장고 ON");
	}

	@Override
	public void turnOff() {
		System.out.println("냉장고 OFF");
	}

	@Override
	public void notification() {
		System.out.println("띠리링 ~~~~~~ ");
	}
	
}
