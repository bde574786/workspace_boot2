package tenco.com.data_structure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class DataStructureTest2 {

	public static void main(String[] args) {
		
		Map map;
		// key와 value 구조로 데이터를 저장한다.
		HashMap<String, String> map1 = new HashMap<>();
		
		// null 값을 허용하지 않는다.
		Hashtable<String, String> map2 = new Hashtable<>();
		
		map1.put("A01", "김포공항정문");
		map1.put("A02", "김포공항후문");
		map1.put("A03", "김포공항로비");
		map1.put("B01", "인천공항정문");
		map1.put("B02", "인천공항후문");
		map1.put("B03", "인천공항로비");
		map1.put("C01", null);
		
		 System.out.println(map1);
		 System.out.println(map1.get("A03"));
		 System.out.println(map1.get("C01"));
		 
		 // 삭제 방법
		 // 키 값 대소문자 구분
		 // 키는 중복될 수 없다.
		 map1.remove("C01");
//		 map1.clear();
		 System.out.println(map1);
	
		 // 사이즈 확인 방법
		 System.out.println(map1.size());

		 // map 계열에서 for문을 사용하는 방법
		 // 1 방법
		 // java.util.Map.Entry
		 for(Entry<String, String> entry : map1.entrySet()) {
			 System.out.println("Key : " + entry.getKey());
			 System.out.println("Value : " + entry.getValue());
		 }
		 System.out.println("========================");
		 // 2 방법
		 // keySet() 활용 Map 계열의 메서드
		 for(String key : map1.keySet()) {
			 System.out.println("[key]" + key);
			 System.out.println("[value]" + map1.get(key));
		 }
		 
	}
	
	
}
