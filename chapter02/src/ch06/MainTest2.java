package ch06;

public class MainTest2 {

	public static void main(String[] args) {
		
		Student student1 = new Student("홍길동", 10_000);
		 Bus bus100 = new Bus(100);
		Subway subway1 = new Subway(1);
		 
		student1.takeBus(bus100);
		student1.showInfo();
		bus100.showInfo();
		 
		// 실행의 흐름 추가하기
		student1.takeSubway(subway1);
		student1.showInfo();
		subway1.showInfo();
	}

}
