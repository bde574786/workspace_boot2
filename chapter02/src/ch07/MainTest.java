package ch07;

public class MainTest {

	public static void main(String[] args) {

		Bank bank = new Bank();

		
		// getter : read-only
		bank.setBalance(-10_000);
		int bankBalance = bank.getBalance();

		
		System.out.println(bankBalance);

		// bank.deposit(10_000);
		// bank.showInfo();

		// bank.withDraw(5_000);
		// bank.showInfo();

		// 신입이 실수로 멤버 변수에 접근해서 잔액을 수정함 !!! ㅠㅠ
		// bank.balance(100_0000);
		// bank.showInfo();

		// 만약 멤버 변수에 접근해햐 할 경우가 있다면 어떻게 하나요???
		// get / set 개념 !!!

	}
}
