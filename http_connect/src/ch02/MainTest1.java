package ch02;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Test;

public class MainTest1 {

	public static void main(String[] args) {

		// JSON 을 받는 것을 확인 ( 응답 )

		// JSON 형식으로 보낼 수도 있다.
		// 자바 문법에서 json 형식을 만드는 방법
		// String a = "{ "\a\" , : b}";

		JsonObject jsonObject1 = new JsonObject();

		jsonObject1.addProperty("이름", "홍길동");
		jsonObject1.addProperty("나이", 23);
		jsonObject1.addProperty("직업", "CEO");
		jsonObject1.addProperty("취미", "노래");
		jsonObject1.addProperty("결혼여부", false);

		// jsonObject1

		System.out.println(jsonObject1);
		System.out.println("-----------------------------");
		System.out.println(jsonObject1.get("이름"));
		System.out.println(jsonObject1.get("나이"));
		System.out.println(jsonObject1.get("직업"));
		System.out.println(jsonObject1.get("취미"));
		System.out.println(jsonObject1.get("결혼여부"));

		// 깊은 복사와 얕은 복사 개념 이해 해보기
		JsonObject b = jsonObject1; // 레퍼런스 전달 -> 얕은 복사
		System.out.println();

		b.addProperty("안녕", "hi");
		System.out.println("----------------");
		System.out.println(jsonObject1);

		// 깊은 복사
		JsonObject c = jsonObject1.deepCopy();

		c.addProperty("test", "1234");
		System.out.println("-----------------");
		System.out.println(jsonObject1);
		System.out.println(c); // 아예 새로운 객체를 만들어버림...

		//
		JsonArray array1 = new JsonArray();
		array1.add(b);
		array1.add(c);
		System.out.println("=========================");
		System.out.println(array1); // 리스트로 객체가 2개 들어갔음...

		System.out.println("-------------------------");
		System.out.println(array1.get(0));
		System.out.println(array1.get(1));
		System.out.println("-------------------------");

		// 모델링
		Gson gson = new Gson();
		// object
		System.out.println("gson");
		Test test = gson.fromJson(array1.get(0), Test.class);
		System.out.println(test);

		// { arr : [ {}, {} ] }

		JsonObject j1 = new JsonObject();

		JsonArray a1 = new JsonArray();
		// 두 개의 object 타입이 필요(문자열)

		// { "name" : "홍길동", "age" : "10" }
		JsonObject t1 = new JsonObject();
		t1.addProperty("name", "홍길동");
		t1.addProperty("age", 10);

		// { "name" : "이순신", "age" : "30" }
		JsonObject t2 = new JsonObject();
		t2.addProperty("name", "이순신");
		t2.addProperty("age", 30);

		a1.add(t1);
		a1.add(t2);

		// { arr : [ { "name" : "홍길동", "age" : "10" }, { "name" : "이순신", "age" : "30" }
		// ] }
		j1.add("arr", a1);
		System.out.println("-------------------------");
		System.out.println(j1);

	}

}
