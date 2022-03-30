package ch13;

public class MainTest1 {

	public static void main(String[] args) {
		
	
	Zealot zealot1 = new Zealot("질럿1");
	Marine marine1 = new Marine("마린1");
	Zergling zergling1 = new Zergling("저글링1");

	zealot1.showInfo();
	marine1.showInfo();
	zergling1.showInfo();

	// 오버로딩
	System.out.println("1");
	System.out.println(1);
	System.out.println(1.0);
	
	}

}
