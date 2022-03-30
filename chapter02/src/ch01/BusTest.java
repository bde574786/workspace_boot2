package ch01;

public class BusTest {

	public static void main(String[] args) {
		Bus b1 = new Bus();
		
		b1.color = "노란색";
		b1.number = 1234;
		b1.height = 123.4;
		b1.pay = 1000;

		
		System.out.println(b1.color);
		System.out.println(b1.number);
		System.out.println(b1.height);
		System.out.println(b1.pay);
	}

}
