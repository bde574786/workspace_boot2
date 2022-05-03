package dto;

import lombok.ToString;

@ToString
public class Todos {

	private int userId;
	private int id;
	private String title;
	private boolean completed;

}
