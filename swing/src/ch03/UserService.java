package ch03;

import java.util.ArrayList;

public interface UserService {
	
	// 삭제
	public void deleteUser(String id);
	
	// 수정
	public void updateUser(User user);
	
	// 결과 출력
	void showUserInfo(ArrayList array);
	
	// 공백 제거
	String removeBlank(String str);

	
}
