package ch07;

public class Car {

	String name;
	
	Car(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			Car car = (Car)obj;
			String name = car.name;
			if(this.name == name) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	
}
