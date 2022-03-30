package ch05;

public class UserInfoOracleDao implements UserInfoDao {

	@Override
	public void insertUserInfo(UserInfo info) {
		System.out.println("Oracle : 저장하기 id " + info.getUserId());
		System.out.println("Oracle : 저장하기 pw " + info.getPassword());
		System.out.println("Oracle : 저장하기 name " + info.getUserName());
	}

	@Override
	public void updateUserInfo(UserInfo info) {
		System.out.println("Oracle : 수정하기 id " + info.getUserId());
		System.out.println("Oracle : 수정하기 pw " + info.getPassword());
		System.out.println("Oracle : 수정하기 name " + info.getUserName());
	}

	@Override
	public void deleteUserInfo(String userId) {
		System.out.println("Oracle : 동작");
		System.out.println("delete from dbName userId = ' " + userId + " ' ");
	}

	
	
}
