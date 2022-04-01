package ch03;

import java.util.ArrayList;

public class UserClient implements UserService {

	public static int userNum = 0;
	ArrayList<User> users = new ArrayList<User>();

	public User inputUser(String id, String password) {
		userNum++;
		return new User(userNum, id, password);
	}

	public void updateUser(User user) {
		for (int i = 0; i < userNum; i++) {
			if (users.get(i).getId().equals(user.getId())) {
				String temp = user.getId();
				user.setId(temp);
				System.out.println(temp +"로 수정되었습니다.");
				return;

			} else {
				System.out.println(user.getId() + "의 아이디를 찾을 수 없습니다.");
			}
		}
	}

	@Override
	public void deleteUser(String id) {
		users.remove(id);
		System.out.println("삭제되었습니다.");
	}

	@Override
	public void showUserInfo(ArrayList users) {
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));

		}
	}

	@Override
	public String removeBlank(String str) {
		String result = str.trim().replace(" ", "");
		return result;
	}
	// 회원 객체 입력 받고 유저 객체 반환

}