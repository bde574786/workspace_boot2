package ch03;

public class StringConcatImpl implements IStringConcat {

	@Override
	public void makeString(String s1, String s2) {
		System.out.println("***" + s1 + ", " + s2 + "***");
	}

	
	
}
