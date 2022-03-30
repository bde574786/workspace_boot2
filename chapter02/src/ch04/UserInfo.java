package ch04;

public class UserInfo {

	String userId;
	String userName;
	String phone;


	// 생성자 오버로딩
	// 생성자 만들기 연습
	// this <-- .자기 자신을 의미한다
	public UserInfo(String userId){
		this.userId =userId;
	}
	public UserInfo(String userId, String userName){
		this.userId = userId;
		this.userName = userName;
	}
	public UserInfo(String userId, String userName, String phone) {
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
	}
}