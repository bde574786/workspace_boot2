package ch03;

public class User {

	private String id;
	private String password;

	public User() {

	}

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public User(int num, String id, String password) {
		this(id, password);
	}

///////////////////////////////////////////////////////////////////생성자 메소드 구분
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}

}