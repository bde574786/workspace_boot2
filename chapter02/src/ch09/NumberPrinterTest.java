package ch09;

public class NumberPrinterTest {

	public static void main(String[] args) {

		//new Person();
		int number = NumberPrinter.waitNumber;
		 System.out.println(number);
		
		
		//numberPrinter.printWaitNumber();
		
		NumberPrinter numberPrinter = new NumberPrinter(1);
		NumberPrinter numberPrinter2 = new NumberPrinter(2);
		NumberPrinter numberPrinter3 = new NumberPrinter(3);

		//1
		numberPrinter.printWaitNumber();
		//2		
		numberPrinter.printWaitNumber();
		//3		
		numberPrinter.printWaitNumber();
		//4		
		numberPrinter.printWaitNumber();
		System.out.println("================");
		numberPrinter2.printWaitNumber();
		numberPrinter2.printWaitNumber();
		System.out.println("================");
		numberPrinter.printWaitNumber();
		numberPrinter3.printWaitNumber();
		
		
		
	}

}
