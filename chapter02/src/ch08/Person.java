package ch08;

public class Person {

	// this 란
	// 1. 인스턴스(객체) 자신의 메모리 주소를 가리킨다.
	// 2. 생성자에서 또 다른 생성자를 호출할 때 사용할 수 있다(생성자 오버로딩)
	// 3. 자신의 주소 (참조값, 주소값)을 반환시킬 수 있다.

	private String name;
	private int age;
	private String phone;
	private int weight;

	public Person() {
		// 2. 생성자에서 또 다른 생성자를 호출할 때 사용할 수 있다
		this("이름없음", 1);
		// Person("이름없음", "1");
	}

	public Person(String name, int age) {
		// 1. 자기 자신을 가리키는 this
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, String phone) {
		// 1. 자기 자신을 가리키는 this
		// this.name = name;
		// this.age = age;
		this(name, age);
		this.phone = phone;
	}

	public Person(String name, int age, String phone, int weight) {
		// 1. 자기 자신을 가리키는 this
		// this.name = name;
		// this.age = age;
		// this.
//		this.name = name;
//		this.age = age;
//		this.phone = phone;
		this(name, age, phone);
		this.weight = weight;
	}
	
	// 메서드
	// 3. 자신의 주소 (참조값, 주소값)을 반환시킬 수 있다.
	// 빌더 패턴을 만들어 낼 수 있다.
	public Person getPerson() {
		return this;
	}

	public void showInfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}

}
