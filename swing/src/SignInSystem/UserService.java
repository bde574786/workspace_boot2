package SignInSystem;

public interface UserService {

	// C R U D

	// Create
	public void createUser();

	// Read
	public void showUserInfo();

	// Update
	public void updateUser();

	// Delete
	public void deleteUser();

	public void insertUser(User user);

	public void loginUser();
}
