package ch05;

import java.util.Scanner;

public class UserInfoClient {
	
	public static final String MYSQL = "mysql";
	public static final String ORACLE = "oracle";

	public static void main(String[] args) {
		
		String id;
		String password;
		String name;
		
		// UserInfo 스캐너로 받아서 흐름 만들어 주세요
		// 사용자한테 userInfo 정보 받는다.
		UserInfo info = new UserInfo();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디를 입력해주세요");
		id = sc.nextLine();
		info.setUserId(id);
		
		System.out.println("비밀번호를 입력해주세요");
		password = sc.nextLine();
		info.setPassword(password);
		
		System.out.println("이름을 입력해주세요");
		name = sc.nextLine();
		info.setUserName(name);
		
//		info.setUserId("abc");
//		info.setPassword("1234");
//		info.setUserName("홍길동");

		// 인터페이스 활용

		// 1. A
//		UserInfoMySqlDao mySqlDao = new UserInfoMySqlDao();
//		mySqlDao.insertUserInfo(info);

		// 2. B
//		UserInfoOracleDao oracleDao = new UserInfoOracleDao();
//		oracleDao.insertUserInfo(info);
//		String str = new String("mysql"); //

		// equals 는 문자열의 값을 비교 합니다.
		// == 객체의 주소값을 비교합니다.

		// 문자열을 비교 할 때는 무조건 equals라는 것을 사용한다.
//		if(str == MYSQL) {

//		if ("mysql".equals(MYSQL)) {
//			System.out.println("문자열이 같습니다");
//		} else {
//			System.out.println("문자열이 다릅니다");
//		}

		// 1. mysql 문자열이면 --> UserInfoMySqlDao 동작
		// 2. Oracle 문자열이면 --> UserInfoOracleDao 동작
		// 단, 다형성을 사용해서 처리 해 주세요

		// 널포인터 예외 뜨므로 null로 초기화
		UserInfoDao userInfoDao = null;
		String str = "mysql";
		
		if (MYSQL.equals(str)) {
			userInfoDao = new UserInfoMySqlDao();
		} else if(ORACLE.equals(str)) {
			userInfoDao = new UserInfoOracleDao();
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	
		// null 값이 들어갈 수 있으므로 방어적 코드 작성
		if(userInfoDao != null) {
			userInfoDao.insertUserInfo(info);
		}
	}	
}
