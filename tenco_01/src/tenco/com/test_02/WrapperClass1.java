package tenco.com.test_02;

public class WrapperClass1 {
	
	public static void main(String[] args) {
		
		Integer num = new Integer(100); // 박싱
		Number n1 = 10;
		
		int n = num.intValue(); // 언박싱
		System.out.println(n);
		System.out.println("================");
	
		Integer num1 = 200; // 자동 박싱 ( new Integer(200) )
		int num10 = num1; // 자동 언박싱( num1.intValue() )
		
	}
	
	
	
}
