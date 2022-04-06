package thread_ex;

import java.util.Scanner;

class MyThread1 extends Thread{
	
	boolean flag = true;
	
	
	
	@Override
	public void run() {
		while(flag) {
			System.out.println("-");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	
}


public class ThreadEnd {

	public static void main(String[] args) {
		
		System.out.println("작업자를 생성 합니다.");
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();
		
		
		// 메인 작업자
		System.out.println("중지 0을 입력");
		Scanner scanner = new Scanner(System.in);
		int userInput = scanner.nextInt();
		
		if(userInput == 0) {
//			myThread1.stop(); // deprecated (더 이상 사용하지 마시오)
			myThread1.flag = false;
		}
		
		
	}
	
}
