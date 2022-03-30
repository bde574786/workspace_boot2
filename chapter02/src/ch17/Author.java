package ch17;

public class Author {

	String name;
	int age;
	
	public Author(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}
