package ch07;

public class Bank {
	
	// 접근 제어 지시자 (private 나의 클래스 내부에서만 접근 가능)
	private int balance;
	
	// get / set 메서드
	// getter : read-only
	public int getBalance() {
		return this.balance;
	}
	
	// setter
	public void setBalance(int balance) {
		// 방어적 코드
		if(balance < 0) {
			System.out.println("잘못된 입력 값 입니다.");
		} else {
			this.balance = balance; 
		}
		
	}
	
	// 입금
	public void deposit(int money) {
		this.balance += money;
		showInfo();
	}
	
	
	// 출금
	public void withDraw(int money) {
		this.balance -= money;
		showInfo();
	}
	
	// 상태 창
	private void showInfo() {
		System.out.println("현재 잔액은 : " + balance);
	}
	
}
