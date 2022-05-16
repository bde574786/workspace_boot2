package ch02;


public class MainTest2 {

	public static void main(String[] args) {
		
		IMaxNumber iMaxNumber = (a, b) -> a > b ? a : b;
		System.out.println(iMaxNumber.getMax(100, 1000));
		
		
		
		
//		IMaxNumber iMaxNumber = (a, b) -> {
//			return Math.max(a, b);
//		};
//
//		System.out.println(iMaxNumber.getMax(1, 2));
		
	}

	 
	
}
