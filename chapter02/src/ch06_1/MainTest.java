package ch06_1;

public class MainTest {

	public static void main(String[] args) {
		
		
		
		People people = new People("Edward", 20000);
		Taxi taxi = new Taxi("잘나간다 운수 택시", 0);
		people.takeTaxi(taxi);
		
		System.out.println(people.getName() + "님의 남은 돈은 " + people.getMoney() + "원 입니다");
		System.out.println(taxi.getCompany() + "수입은 " + taxi.getMoney() + "워입니다");
		
		
		
	}

}
