package ch13_1;

public class MainTest {

	public static void main(String[] args) {

		Unit zealot = new Zealot("질럿"); 
		Unit marine  = new Marine("마린", 10, 5);
		Unit zergling  = new Zergling("저글링", 10, 5);
		
		((Zealot)zealot).attack(marine);
		marine.showInfo();

	}

}
