package thread_ex;

public class ThreadTest1 {

	// 메인 코드의 시작점
	// 메인 쓰레드
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			System.out.println(i + "\t");

			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
}
