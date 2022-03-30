package ch06;

public class Bus {

	public static int chargeMoney = 1200;
	
	// 상태 (버스 번호, 승객 수, 수입금)
	int busNumber;
	int passengerCount;
	int money;
	
	// 생성자
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	// 행위
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	// 상태 창
	public void showInfo() {
		System.out.println("버스 번호 : " + busNumber);
		System.out.println("승객 수 : " + passengerCount);
		System.out.println("금액 : " + money);
		System.out.println("==================");
	}
	
	
	
}
