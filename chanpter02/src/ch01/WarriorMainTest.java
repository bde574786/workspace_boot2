package ch01;

public class WarriorMainTest {

	public static void main(String[] args) {

		// 변수 --> 지역변수
		Warrior w1 = new Warrior();
		w1.name = "오크";
		w1.height = 5;
		w1.power = 200;
		w1.color = "초록색";

		Warrior w2 = new Warrior();
		w2.name = "작은전사";
		w2.height = 1;
		w2.power = 50;
		w2.color = "빨간색";
		
		System.out.println("=====상태창=====");
		System.out.println(w1.name);
		System.out.println(w1.color);
		System.out.println(w1.height);
		System.out.println(w1.power);
		System.out.println("===============");
		
		
	}

}
