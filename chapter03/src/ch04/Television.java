package ch04;

public class Television extends HomeAppliances implements RemoteController {

	@Override
	public void turnOn() {
		System.out.println("TV ON");
	}

	@Override
	public void turnOff() {
		System.out.println("TV OFF");
	}
	
}
