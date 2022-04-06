package thread_ex;

import javax.swing.JFrame;

class MyRunnable2 extends JFrame {

	int grade;
	// -> 내부 익명 구현 객체를 변수에 담기
	// 익명 구현 객체
	Runnable runnable = new Runnable() {
		@Override
		public void run() {

			for (int i = 0; i < 10; i++) {
				System.out.println("-");

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	// 생성자
	public MyRunnable2() {
		// runnable.run();

	}

}

public class RunnableTest2 {

	public static void main(String[] args) {
		MyRunnable2 myRunnable2 = new MyRunnable2();
		// 여기서 실행 -->
		myRunnable2.runnable.run();

	}

}
