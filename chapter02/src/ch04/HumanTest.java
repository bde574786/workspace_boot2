package ch04;

import java.util.Scanner;

public class HumanTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int weight = sc.nextInt();
		sc.nextLine();
		String gender = sc.nextLine();
		String name  = sc.nextLine();
		int age = sc.nextInt();
		
		Human human1 = new Human(height, weight, gender, name, age);
		human1.showInfo();

		
		
	}
	
	
}
