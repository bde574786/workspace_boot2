package ch15;

public class Fruit {

	String name;
	int price;
	int fresh;
	
	public void showInfo() {
		System.out.println("상품명 : " + name);
		System.out.println("가격 : " + price);
		System.out.println("신선도 : " + fresh);
	}
	
}
