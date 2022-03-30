package ch07;

public class MainTest {

	public static void main(String[] args) {

		Car car1 = new Car("차1");
		Car car2 = new Car("차1");
		
		if(car1.equals(car2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
	}

}
