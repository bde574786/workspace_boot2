package ch02;

@FunctionalInterface
public interface ICalc {
	
	// 하나만 쓸 수 있음
	int add(int x, int y);
//	int sub(int x, int y);
	
}
