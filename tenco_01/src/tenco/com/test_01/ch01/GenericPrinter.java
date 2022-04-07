package tenco.com.test_01.ch01;

public class GenericPrinter<T> {

	// T 라는 대체 문자를 사용, E = element, K - key, V - value (사실 아무 문자나 상관 없음)
	
	private T material; // T 자료형으로 선언한 변수

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	
	
	
	
}
