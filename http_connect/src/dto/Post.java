package dto;

import lombok.ToString;

// 데이터만 전달하는 클래스 dto
@ToString
public class Post {

	public int userId;
	public int id;
	public String title;
	public String body;

}
