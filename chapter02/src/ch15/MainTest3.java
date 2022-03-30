package ch15;

public class MainTest3 {

	public static void main(String[] args) {

		Banana banana1 = new Banana();
		Banana banana2 = new Banana();

		// 배열
		// 주의점 : 배열을 사용할 때는 배열의 크기를 먼저 지정해야 한다.
		// 배열의 크기와 요소의 크기는 반드시 동일한 것은 아니다.
		Banana[] bananas = new Banana[10];
		bananas[0] = banana1;
		bananas[1] = banana2;

		// 주소값.
		// null point exception 발생
		// System.out.println(bananas[3].name);

		Peach[] peaches = new Peach[3];
		peaches[0] = new Peach();
		peaches[1] = new Peach();
		peaches[2] = new Peach();
		
		// 다형성 - 유연한 코드를 작성할 수 있다.
		Fruit[] fruits = new Fruit[4];
		fruits[0] = new Banana();
		fruits[1] = new Peach();
		fruits[2] = new Banana();
		fruits[3] = new Peach();
		
		for (int i = 0; i < fruits.length; i++) {
			fruits[i].showInfo();
			// 문제
			// 바나나 타입일 경우 saleBanana 메서드를 호출해 주세요
			if(fruits[i] instanceof Banana)
				((Banana)fruits[i]).saleBanana();
		
		
		}
	}

}
