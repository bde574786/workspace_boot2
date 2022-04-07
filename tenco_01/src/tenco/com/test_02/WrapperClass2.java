package tenco.com.test_02;

public class WrapperClass2 {

	public static void main(String[] args) {
		
		String str = "100asdf";
		String str2 = "100.5";
		String str3 = "true";
		
		try {
			int i = Integer.parseInt(str);
		} catch(NumberFormatException n){
			System.out.println("변환 할 수 없습니다.");
		}
		
//		double d = Double.parseDouble(str2);
//		boolean bool = Boolean.parseBoolean(str3);
		
//		System.out.println("문자열 int 값 변환 : " + i);
//		System.out.println("문자열 double 값 변환 : " + d);
//		System.out.println("문자열 boolean 값 변환 : " + bool);
		
		
		
	}
	
}
