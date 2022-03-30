package ch20;

public class DeskTop extends Computer {

	@Override
	public void display() {
			System.out.println("모니터에 화면을 출력합니다.");
	}

	@Override
	public void typing() {
		System.out.println("키보드로 타이핑 합니다.");
	}

	
}
