package dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Person {
	private String name;
	private int age;
	private String address;
	
}
