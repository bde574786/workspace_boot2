package ch12;

import java.util.logging.Logger;

class Student {
	String name;
	int grade;
	
}

public class MyLog {

	public static void main(String[] args) {
		//로그 남겨 보기
		Logger logger = Logger.getLogger("MyLog");
		
		Student student = null;
		
		try {
			student.name = "홍길동";
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("---------------------------");
			logger.warning("오류 확인 : " + e.toString());
		}
		
		System.out.println("여기 코드 실행 확인!!");
		
	}
	
}
