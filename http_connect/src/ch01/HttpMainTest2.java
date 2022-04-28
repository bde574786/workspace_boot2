package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import dto.Post;


public class HttpMainTest2 {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/20");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); // REST API
//			connection.addRequestProperty("content type", "application/json");
			connection.connect();

			int statusCode = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer buffer = new StringBuffer();
			String line = null;

			if (statusCode == 200) {
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			} else if (statusCode == 404) {
				System.out.println("네트워크 연결이 불안정합니다.");
			}

			String str = buffer.toString();
			System.out.println(str);
			System.out.println("---------------------");
			
			
			Post post = new Post();
			
			post.userId = Integer.parseInt(str.substring(13 ,14));
			System.out.println(post.userId);
			
			
			post.id = Integer.parseInt(str.substring(23, 25));
			System.out.println(post.id);
			
			post.title = str.substring(38, 72);
			System.out.println(post.title);
			
			post.body = str.substring(85, 301);
			System.out.println(post.body);
			
			
			
			
//			System.out.println(post.userId);
//			System.out.println(str.substring(13,14));
//			
//			System.out.println(str.substring(b, b+6));
//			System.out.println(str.substring(d));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
