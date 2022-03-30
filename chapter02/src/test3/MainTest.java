package test3;

public class MainTest {

	public static void main(String[] args) {

		// 다형성 --> 
		A temp1 = new B();
		A temp2 = new C();
		
		if(temp1 instanceof B) {
			// 우리는 testPrint 메서드가 있는지 알고 있다.
			((B)temp1).testPrint();
		}
		
		temp1.test1();
	}

}
