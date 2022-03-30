package ch14;

public class Car {

	String name;
	int price;
	Engine engine;
	
	public Car() {
		engine = new Engine("gdr엔진", 600);
	}
	
	
	
	public void showInfo() {
		System.out.println(engine.name);
		System.out.println(engine.price);
	}
	
	
}
