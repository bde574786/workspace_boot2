package ch04;


public class Human {

	int height;
	int weight;
	String gender;
	String name;
	int age;

	public Human(int height, int weight, String gender, String name, int age) {
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.name = name;
		this.age = age;
	}

	public void	showInfo() {
		System.out.println("키가 "+height+"이고"+" 몸무게가 "+weight+"인 "+gender+"이 있습니다. 이름은 "+name+"이고 나이는 "+age+"세 입니다.");
	
	}

	
	
}
