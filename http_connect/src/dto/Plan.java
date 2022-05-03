package dto;

import java.util.ArrayList;
import java.util.List;

class Todo {
	int id;
	String title;
	boolean complete;
}



public class Plan {

	private List<Todos> todoList = new ArrayList<Todos>();
	private String server_name;
	
	// todoList, get, set
	
	public List<Todos> getTodoList() {
		return this.todoList;
	}
	
	public void setTodoList(List<Todos> todoList) {
		this.todoList = todoList;
	}
	
}
