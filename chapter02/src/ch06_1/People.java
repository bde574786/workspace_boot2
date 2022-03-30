package ch06_1;

public class People {

	private String name;
	private int money;
	
	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	People(String name, int money){
		this.name = name;
		this.money = money;
	}
	
	// 택시를 탄다. 
	public void takeTaxi(Taxi taxi) {
		taxi.take(10000);
		this.money -= 10000; 
	}
	
	// 버스틀 탄다 
	
	//  지하철을 탄다. 
	
	
	
}
