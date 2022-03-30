package ch09;

public class NumberPrinter {

	// 인스턴스들이 공유 할 수 있는 메모리 영역이다.
	private int id;
	public static int waitNumber = 100;
	
	public NumberPrinter(int id) {
		this.id = id;
		waitNumber = 1;
	}
	
	
	// 번호표를 출력합니다.
	public void printWaitNumber() {
		System.out.println(id + " 기기의 대기 순번은 : " + waitNumber);
//		waitNumber = waitNumber + 1;
		waitNumber++;
	}
	
	
	
}
