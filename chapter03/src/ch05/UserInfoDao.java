package ch05;

public interface UserInfoDao {
	
	void insertUserInfo(UserInfo info);
	void updateUserInfo(UserInfo info);
	void deleteUserInfo(String userId);
}
