package ch19;


// abstract --> 강제 !!!
public abstract class Animal {

	// 추상 클래스란 (abstract class)
	// 하나 이상의 추상 메서드를 포함하는 클래스이다. (abstract method)
	
	String name;
	
	public void move() {
		System.out.println("이동 합니다.");
	}
	
	// 추상 메서드 -> 메서드의 선언부만 존재 + abstract
	 public abstract void hunt();
	
	public static void main(String[] args) {
		Animal animal; // = new Animal(); 
		// 추상 클래스는 new라는 키워드를 사용해서 메모리에 올릴 수 없다. 단, 기본적으로  
		
	}
	 
	 
}
