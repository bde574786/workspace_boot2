package ch02;

public class Refrigerator extends HomeAppliances {

	@Override
	public void turnOn() {
		System.out.println("티비를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("티비를 끕니다");
	}

	
}
