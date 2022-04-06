package thread_ex;

// 1번째 방법 : 다른 작업자를 생성하는 방법 (상속) --> run() 메서드 구현
class MyCustomThread extends Thread {
	
	String name;
	public MyCustomThread(String name) {
		this.name = name;
	}
	
	// Thread는 약속 되어있다.
	// run 이라는 메서드는 쓰레드가 동작을 명령 받으면
	// 수행하는 코드 영역이다.
	@Override
	public void run() {
		int i;
		for (i = 0; i < 50; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
}


public class ThreadTest2 {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread());
		System.out.println("메인 쓰레드 시작");
		
		
		// 작업자 호출 및 작업 수행(run)을 순서대로 호출 하더라도
		// 실제 작업은 랜덤이다.
		MyCustomThread t1 = new MyCustomThread("서브작업자1");
		// 쓰레드를 시작하는 방법
		t1.start();
		
		MyCustomThread t2 = new MyCustomThread("서브작업자2"); 
	    t2.start();
		
	    MyCustomThread t3 = new MyCustomThread("서브작업자3"); 
	    t3.start();
	    
	    
		
		System.out.println("메인 쓰레드 종료");
	}
	
}
