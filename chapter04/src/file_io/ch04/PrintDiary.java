package file_io.ch04;

public class PrintDiary {

	public static void main(String[] args) {
		
		Caller caller = new Caller("화면1");
		Callee callee = new Callee("화면2");
		
		callee.setiCaller(caller.iCaller);
		
		
	}
	
}
