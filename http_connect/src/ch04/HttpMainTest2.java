package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Todos;

public class HttpMainTest2 {

	public static void main(String[] args) {

		try {
			// http 통신을 하기위한 준비물 1
			URL url = new URL("https://jsonplaceholder.typicode.com/todos");
			// 준비물 2
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 부가적인 정보를 추가해서 보내기 !!!
			connection.setRequestMethod("GET");
			connection.connect();

			// 100, 200, 300, 400, 500 대 종류가 있다.
			// 200번대는 성공
			int statusCode = connection.getResponseCode();
//			System.out.println("statusCode : " + statusCode);

			// http 통신 할 때 스트림을 달아야 한다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer sb = new StringBuffer();
			String line = null;

			if (statusCode == 200) {
				while (((line = reader.readLine())) != null) {
					sb.append(line + "\n");
				}
			}
			
			Gson gson = new Gson();
			String str = sb.toString();
			System.out.println(str);
			
			// 파싱 처리 해주세요 !!!!
			Type todosType = new TypeToken<ArrayList<Todos>>() {}.getType();
			ArrayList<Todos> arrayList = gson.fromJson(str, todosType);
			for (Todos todo : arrayList) {
				System.out.println(todo);
			}
			

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
