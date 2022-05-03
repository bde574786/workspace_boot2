package ch03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Person;
import dto.Plan;

public class MainTest {

	public static void main(String[] args) {

		JsonObject j1 = new JsonObject();
		JsonObject j2 = new JsonObject();
		JsonObject j3 = new JsonObject();

		JsonArray a1 = new JsonArray();

		j1.addProperty("name", "홍길동");
		j1.addProperty("age", 20);
		j1.addProperty("address", "부산");

		j2.addProperty("name", "이순신");
		j2.addProperty("age", 33);
		j2.addProperty("address", "서울");

		j3.addProperty("name", "세종대왕");
		j3.addProperty("age", 59);
		j3.addProperty("address", "세종시");

		a1.add(j1);
		a1.add(j2);
		a1.add(j3);

		System.out.println("문제 1");
		System.out.println(a1);

		Gson gson1 = new Gson();
		// object
		System.out.println("");
		System.out.println("문제 1 모델링");
		Person test1 = gson1.fromJson(a1.get(0), Person.class);
		System.out.println(test1);

		JsonObject j4 = new JsonObject();
		JsonObject j5 = new JsonObject();

		JsonArray a2 = new JsonArray();
		JsonObject j6 = new JsonObject();

		j4.addProperty("id", 1);
		j4.addProperty("title", "청소");
		j4.addProperty("complete", false);

		j5.addProperty("id", 2);
		j5.addProperty("title", "영어공부");
		j5.addProperty("complete", true);

		a2.add(j4);
		a2.add(j5);

		j6.add("todoList", a2);
		j6.addProperty("server_name", "server_1");

		System.out.println("");
		System.out.println("문제 2");
		System.out.println(j6);

		System.out.println("");

		Gson gson2 = new Gson();
		System.out.println("문제 2 모델링");
		Plan test2 = gson2.fromJson(a2.get(0), Plan.class);
		System.out.println(test2);
	}

}
