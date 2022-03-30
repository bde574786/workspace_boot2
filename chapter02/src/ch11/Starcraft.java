package ch11;

import java.util.Scanner;

public class Starcraft {

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		boolean flag = true;

		Zealot zealot = new Zealot("질럿");
		Marine marine = new Marine("마린");
		Zergling zergling = new Zergling("저글링");

		while(flag) {
			System.out.println("종족을 선택하세요.\n1.프로토스  2.테란  3.저그");
			String tribe = sc1.nextLine();
			if (tribe.equals("1")) {
				System.out.println("프로토스를 선택하셨습니다.");
				System.out.println("당신은 질럿입니다.");
				zealot.showInfo();
				while (flag) {
					System.out.println("옵션을 선택하세요");
					System.out.print("1.공격력 업그레이드 2.체력 업그레이드 3.마린 공격 4.저글링 공격 q.종료\n");
					String option = sc1.next();

					if (option.equals("1")) {
						zealot.powerUpgrade(zealot);
						String upgrading = ".";
						for (int i = 0; i <= 10; i++) {
							// zealot1.attackMarrine(marine1);
							System.out.print(upgrading);
							try {
								Thread.sleep(250);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println("\n업그레이드 완료");
						zealot.showInfo();

					} else if (option.equals("2")) {
						zealot.hpUpgrade(zealot);
						String upgrading = ".";
						for (int i = 0; i <= 10; i++) {
							// zealot1.attackMarrine(marine1);
							System.out.print(upgrading);
							try {
								Thread.sleep(250);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println("\n업그레이드 완료");
						zealot.showInfo();
						
					} else if (option.equals("3")) {
						String attack = ".";
						if (marine.getHp() > 0) {
							System.out.println("마린 공격 중");
							for (int i = 0; i <= 10; i++) {
								System.out.print(attack);
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							zealot.attackMarine(marine);
							marine.showInfo();
						} else {
							System.out.println("마린은 이미 사망하였습니다.");
						}
					} else if (option.equals("4")) {
						String attack = ".";
						if (zergling.getHp() > 0) {
							System.out.println("저글링 공격 중");
							for (int i = 0; i <= 10; i++) {
								System.out.print(attack);
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							zealot.attackZergling(zergling);
							zergling.showInfo();
						} else {
							System.out.println("저글링은 이미 사망하였습니다.");
						}
					} else if (option.equals("q")) {
						while (flag) {
							System.out.println("정말 종료하시겠습니까?y/n(뒤로가기)");
							String finish = sc2.nextLine();
							if (finish.equals("y")) {
								flag = false;
							} else if (finish.equals("n")) {
								break;
							} else {
								System.out.println("값을 잘못 입력하였습니다.");
							}
						}

					} else {
						System.out.println("다시 선택하세요");
					}

				}
			} else if (tribe.equals("2")) {
				System.out.println("테란을 선택하셨습니다");
				System.out.println("당신은 마린입니다.");
				marine.showInfo();
				while (flag) {
					System.out.println("옵션을 선택하세요");
					System.out.print("1.공격력 업그레이드 2.체력 업그레이드 3.질럿 공격 4.저글링 공격 q.종료\n");
					String option = sc1.next();

					if (option.equals("1")) {
						marine.powerUpgrade(marine);
						String upgrading = ".";
						for (int i = 0; i <= 10; i++) {
							System.out.print(upgrading);
							try {
								Thread.sleep(250);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("\n업그레이드 완료");
						marine.showInfo();

					} else if (option.equals("2")) {
						marine.hpUpgrade(marine);
						String upgrading = ".";
						for (int i = 0; i <= 10; i++) {
							System.out.print(upgrading);
							try {
								Thread.sleep(250);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("\n업그레이드 완료");
						marine.showInfo();
						
					} else if (option.equals("3")) {
						String attack = ".";
						if (zealot.getHp() > 0) {
							System.out.println("질럿 공격 중");
							for (int i = 0; i <= 10; i++) {
								System.out.print(attack);
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							marine.attackZealot(zealot);
							zealot.showInfo();
						} else {
							System.out.println("질럿은 이미 사망하였습니다.");
						}
					} else if (option.equals("4")) {
						String attack = ".";
						if (zergling.getHp() > 0) {
							System.out.println("저글링 공격 중");
							for (int i = 0; i <= 10; i++) {
								System.out.print(attack);
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							marine.attackZergling(zergling);
							zergling.showInfo();
						} else {
							System.out.println("저글링은 이미 사망하였습니다.");
						}
					} else if (option.equals("q")) {
						while (flag) {
							System.out.println("정말 종료하시겠습니까?y/n(뒤로가기)");
							String finish = sc2.nextLine();
							if (finish.equals("y")) {
								flag = false;
							} else if (finish.equals("n")) {
								break;
							} else {
								System.out.println("값을 잘못 입력하였습니다.");
							}
						}

					} else {
						System.out.println("다시 선택하세요");
					}

				}
				
			} else if (tribe.equals("3")) {
				System.out.println("저그를 선택하셨습니다.");
				System.out.println("당신은 저글링입니다");
				zergling.showInfo();
				while (flag) {
					System.out.println("옵션을 선택하세요");
					System.out.print("1.공격력 업그레이드 2.체력 업그레이드 3.질럿 공격 4.마린 공격 q.종료\n");
					String option = sc1.next();

					if (option.equals("1")) {
						zergling.powerUpgrade(zergling);
						String upgrading = ".";
						for (int i = 0; i <= 10; i++) {
							System.out.print(upgrading);
							try {
								Thread.sleep(250);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("\n업그레이드 완료");
						zergling.showInfo();

					} else if (option.equals("2")) {
						zergling.hpUpgrade(zergling);
						String upgrading = ".";
						for (int i = 0; i <= 10; i++) {
							// zealot1.attackMarrine(marine1);
							System.out.print(upgrading);
							try {
								Thread.sleep(250);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println("\n업그레이드 완료");
						zergling.showInfo();
						
					} else if (option.equals("3")) {
						String attack = ".";
						if (zealot.getHp() > 0) {
							System.out.println("질럿 공격 중");
							for (int i = 0; i <= 10; i++) {
								System.out.print(attack);
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							zergling.attackZealot(zealot);
							zealot.showInfo();
						} else {
							System.out.println("질럿은 이미 사망하였습니다.");
						}
					} else if (option.equals("4")) {
						String attack = ".";
						if (marine.getHp() > 0) {
							System.out.println("마린 공격 중");
							for (int i = 0; i <= 10; i++) {
								System.out.print(attack);
								try {
									Thread.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							zergling.attackMarine(marine);
							marine.showInfo();
						} else {
							System.out.println("마린은 이미 사망하였습니다.");
						}
					} else if (option.equals("q")) {
						while (flag) {
							System.out.println("정말 종료하시겠습니까?y/n(뒤로가기)");
							String finish = sc2.nextLine();
							if (finish.equals("y")) {
								flag = false;
							} else if (finish.equals("n")) {
								break;
							} else {
								System.out.println("값을 잘못 입력하였습니다.");
							}
						}

					}else {
						System.out.println("다시 선택하세요");
					}

				}
			} else {
				System.out.println("다시 선택하세요.");
			}
		
		}
		
	}
	
}