package ch06;

public class Subway {

	int lineNumber;
	int passengerCount;
	int money;

	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
		
	}

	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.println("지하철 호선 : " + lineNumber);
		System.out.println("승객 수 : " + passengerCount);
		System.out.println("금액 : " + money);
		System.out.println("====================");
	}
	
}
