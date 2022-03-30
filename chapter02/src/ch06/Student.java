package ch06;

public class Student {

	String name;
	int money;
	
	// 생성자
	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	
	// 학생이 버스를 탄다
	public void takeBus(Bus bus) {
		// 5_000원 >> 버스 요금 1200
		bus.take(1200);
		this.money -= 1200;
		}
	
	// 학생이 지하철을 탄다
	public void takeSubway(Subway subway) {
		subway.take(1300);
		this.money -= 1300;
	}
	
	// 상태창
	public void showInfo() {
		System.out.println("학생 이름 : " + name);
		System.out.println("학생의 소지금 : " + money);
		System.out.println("===============");
	}
	
}
