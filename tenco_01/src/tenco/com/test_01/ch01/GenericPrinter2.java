package tenco.com.test_01.ch01;

// T 자료형에 대한 제한을 지정할 수 있다.
public class GenericPrinter2<T extends Material>{

	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return material.toString();
	}
	
	
}
