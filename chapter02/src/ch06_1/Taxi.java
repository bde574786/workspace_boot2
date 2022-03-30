package ch06_1;

public class Taxi {

	private int money;
	private String company;
	

	public Taxi(String company, int money) {
		this.company = company;
		this.money = money;
	}
	
	// 사람을 태운다. 
	public void take(int money) {
		this.money += money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public String getCompany() {
		return company;
	}
	
}
