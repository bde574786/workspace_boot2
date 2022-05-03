package ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import dto.Post;

public class HttpMainTest3 {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://yts.mx/api/v2/list_movies.json");
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
			
			Yts yts = new Gson().fromJson(str, Yts.class);
			System.out.println(yts.getData().getMovieCount());
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
