package ch05;

public class MainTest {

	public static void main(String[] args) {
		// 사용하기 ( 실행의 흐름 )
		InputUserInfoScanner userInfoScanner = new InputUserInfoScanner();
		// 힙 영역에 userInfoScanner 객체가 올라가고 실행의 제어권이 생성자로 넘어가면
		// 생성자에 있는 새로운 스캐너 객체도 올라간다.
		UserInfo user1 =  userInfoScanner.inputData();
		// 대입 연산자의 순서는 오른쪽에서 왼쪽
		// 가정 먼저 inputData로 넘어감
		System.out.println("메인 :  " + user1.name);
		System.out.println("메인 :  " + user1.id);
		
		
		
	}
	
}
