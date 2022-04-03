package SignInSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

	Scanner sc;
	ArrayList<User> users = new ArrayList<User>();

	public UserServiceImpl() {
		sc = new Scanner(System.in);
		users = new ArrayList<>();
	}

	public boolean goBack() {
		do {
			System.out.println("계속하시겠습니까? (y/n(뒤로가기))");
			String continueFlag = sc.nextLine();
			if (continueFlag.equals("y") || continueFlag.equals("Y")) {
				return true;
			} else if (continueFlag.equals("n") || continueFlag.equals("N")) {
				return false;
			} else {
				System.out.println("잘못된 명령입니다.");
			}
		} while (true);
	}

	public boolean nextOn() {
		do {
			System.out.println("계속 정보를 등록하시겠습니까? (y/n(뒤로가기))");
			String continueFlag = sc.nextLine();
			if (continueFlag.equals("y") || continueFlag.equals("Y")) {
				return true;
			} else if (continueFlag.equals("n") || continueFlag.equals("N")) {
				return false;
			} else {
				System.out.println("잘못된 명령입니다.");
			}
		} while (true);
	}

	@Override
	public void createUser() {
		boolean signInFlag = true;

		while (signInFlag) {

			System.out.println("회원가입을 진행합니다");
			System.out.print("아이디를 입력하세요\n>>> ");
			String id = sc.nextLine();
			System.out.print("이름을 입력하세요\n>>> ");
			String name = sc.nextLine();
			System.out.print("이메일을 입력하세요\n>>> ");
			String email = sc.nextLine();

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			while (true) {
				System.out.print("비밀번호를 입력하세요\n>>> ");
				String password = sc.nextLine();
				System.out.print("비밀번호를 다시 입력하세요\n>>> ");
				String passwordCheck = sc.nextLine();
				if (password.equals(passwordCheck)) {
					System.out.println("회원가입에 성공하였습니다.");
					user.setPassword(password);
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다");
				}

			}
			signInFlag = nextOn();
			insertUser(user);
		}

	}

	@Override
	public void insertUser(User user) {
		users.add(user);
	}

	public void showAllUser() {
		System.out.println("전체 회원 목록");
		System.out.println("=========================================");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("=========================================");
		System.out.println("");
	}

	@Override
	public void updateUser() {
		boolean flag = true;
		String id;
		String password;
		String passwordCheck1;
		String passwordCheck2;
		while (flag) {
			System.out.println("아이디를 입력하세요");
			id = sc.nextLine();
			System.out.println("현재 비밀번호를 입력하세요");
			password = sc.nextLine();
			System.out.println("변경할 비밀번호를 입력하세요");
			passwordCheck1 = sc.nextLine();
			System.out.println("변경할 비밀번호를 다시 입력하세요");
			passwordCheck2 = sc.nextLine();
			for (int i = 0; i < users.size(); i++) {
				if ((users.get(i).getId().equals(id))) {
					if (passwordCheck1.equals(passwordCheck2) && (users.get(i).getPassword().equals(password))) {
						users.get(i).setPassword(passwordCheck2);
						System.out.println("비밀번호가 변경되었습니다.");
						return;
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						flag = goBack();
					}
				} else {
					System.out.println("해당 회원을 찾을 수 없습니다.");
					flag = goBack();
				}

			}
		}
	}

	@Override
	public void deleteUser() {
		boolean flag = true;
		while (flag) {
			System.out.println("회원 탈퇴를 시작합니다.");
			System.out.println("아이디를 입력해주세요");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력해주세요");
			String password = sc.nextLine();
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId().equals(id)) {
					if (users.get(i).getPassword().equals(password)) {
						users.remove(i);
						System.out.println("탈퇴가 완료되었습니다.");
						return;
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						flag = goBack();
					}
				} else {
					System.out.println("아이디를 찾을 수 없습니다.");
					flag = goBack();
				}
			}
		}

	}

	@Override
	public void showUserInfo() {
		String getId;
		boolean flag = true;
		while (flag) {
			System.out.println("아이디를 입력하세요");
			getId = sc.nextLine();
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId().equals(getId)) {
					System.out.println("회원 정보");
					System.out.println(users.get(i));
					return;
				}
			}
			System.out.println("해당 아이디를 찾을 수 없습니다.");
			flag = goBack();
		}
	}

	// 일반회원
	public void logIn() {
		boolean flag = true;
		while (flag) {
			System.out.println("일반 회원으로 로그인 합니다.");
			System.out.print("아이디를 입력하세요\n>>> ");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력하세요\n>>> ");
			String password = sc.nextLine();

			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId().equals(id) && users.get(i).getPassword().equals(password)) {
					System.out.println("환영합니다.");
					return;
				}
			}
			System.out.println("비밀번호가 일치하지 않습니다.");
			flag = goBack();
		}

	}

	// 관리자
	public void logInManager() {
		Scanner sc = new Scanner(System.in);
		final String ID = "1";
		final String PASSWORD = "2";
		while (true) {
			System.out.println("관리자로 로그인 합니다");
			System.out.println("id : 1, password : 2");
			System.out.print("관리자 아이디를 입력하세요\n>>> ");
			String id = sc.nextLine();
			System.out.print("관리자 비밀번호를 입력하세요\n>>> ");
			String password = sc.nextLine();
			if ((id.equals(ID)) && (password.equals(PASSWORD))) {
				System.out.println("환영합니다.");
				return;
			}
			System.out.println("다시 시도하세요");
			System.out.println("");
		}
	}

	@Override
	public void loginUser() {
		String login;
		while (true) {
			System.out.println("1. 일반회원 로그인\t2. 관리자 로그인 3. 뒤로가기");
			login = sc.nextLine();
			if (login.equals("1")) {
				logIn();
				System.out.println("일반 회원 메뉴입니다.");
				userMenu();
			} else if (login.equals("2")) {
				logInManager();
				System.out.println("관리자 메뉴입니다.");
				manageMenu();
			} else if (login.equals("3")) {
				break;
			} else {
				System.out.println("다시 시도하세요");
				System.out.println("");
			}
		}
	}

	public void userMenu() {
		String choice;
		boolean flag = true;
		while (flag) {
			System.out.println("1. 회원 정보 조회 2. 비밀번호 수정 3. 회원 탈퇴 4. 뒤로가기");
			choice = sc.nextLine();
			if (choice.equals("1")) {
				System.out.println("회원정보를 조회합니다.");
				showUserInfo();
				flag = goBack();
			} else if (choice.equals("2")) {
				System.out.println("비밀번호를 수정합니다.");
				updateUser();
			} else if (choice.equals("3")) {
				deleteUser();
			} else if (choice.equals("4")) {
				flag = false;
			}
		}
	}

	public void loginManagetDelete() {
		System.out.println("회원을 강제로 탈퇴시킵니다.\n");
		while (true) {
			showAllUser();
			System.out.println("탈퇴시킬 회원 아이디를 입력하세요");
			String num = sc.nextLine();
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId().equals(num)) {
					users.remove(i);
					System.out.println("회원을 강제 탈퇴하였습니다.");
					return;
				}
			}
			System.out.println("해당 아이디를 찾을 수 없습니다.\n");
		}

	}

	public void manageMenu() {
		while (true) {
			System.out.println("1. 회원 강제 탈퇴 2. 전체 회원 정보 조회 3. 뒤로가기");
			String delete = sc.nextLine();
			if (delete.equals("1")) {
				loginManagetDelete();
			} else if (delete.equals("2")) {
				showAllUser();
			} else if (delete.equals("3")) {
				break;
			} else {
				System.out.println("다시 시도하세요");
			}
		}
	}

}
