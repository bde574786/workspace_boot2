package ch14;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		boolean flag = true;

		Scanner sc = new Scanner(System.in);

		Archer archer = new Archer("궁수", 10, 3);
		Wizard wizard = new Wizard("마법사", 10, 3);

		while (flag) {
			System.out.println("캐릭터 선택\n1. 전사\t2. 궁수\t3. 마법사");
			int choice = sc.nextInt();

			Hero hero;

			if (choice == 1) {
				hero = new Warrior("전사", 10, 3);
				hero.getName();
				hero.showInfo();
				while (flag) {
					System.out.println("옵션 선택");
					System.out.println("1. 궁수 공격\t2.마법사 공격");
					int option = sc.nextInt();
					if (option == 1) {
						System.out.println("궁수 공격 중...");
						((Warrior)hero).comboAttack();
					}
				}

			} else if (choice == 2) {
				hero = new Archer("궁수", 10, 5);
				hero.getName();
				hero.showInfo();
				while (flag) {
					System.out.println("옵션 선택");
					System.out.println("1. 전사 공격\t2.마법사 공격");
					int option = sc.nextInt();
					if (option == 1) {
						System.out.println("전사 공격 중...");
						((Archer)hero).fireArrow();
					}
				}
			} else if (choice == 3) {
				hero = new Wizard("마법사", 10, 5);
				hero.getName();
				hero.showInfo();
				while (flag) {
					System.out.println("옵션 선택");
					System.out.println("1. 전사 공격\t2.궁수 공격");
					int option = sc.nextInt();
					if (option == 1) {
						System.out.println("전사 공격 중...");
						((Wizard) hero).freezing();
					}
				}
			}
		}
	}
}
