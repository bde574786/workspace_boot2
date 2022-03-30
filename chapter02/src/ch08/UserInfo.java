package ch08;

public class UserInfo {

	//  멤버 변수
	// this 활용한 생성
	
	String name;
	String address;
	String phoneNumber;
	
	
	public UserInfo(){
	}
	
	public UserInfo(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public UserInfo(String name, String address, String phoneNumber){
		this(name, address);
		this.phoneNumber = phoneNumber;
	}
	
	public void showInfo() {
		header();
		System.out.println("이름 : "+name+"\n주소 : "+ address + "\n전화번호 : "+ phoneNumber);
		
	}
	
	public void  header() {
		System.out.println("=================================");
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		UserInfo user1 = new UserInfo("홍길동", "부산","010-1234-1234");
		UserInfo user2 = new UserInfo("홍길동", "부산","010-1234-1234");
		user1.showInfo();
		user2.showInfo();
		
	
		
		
		
		
		// 여기서 메인 함수 사용할 수 있다.
		
		
	}
	
	
}
