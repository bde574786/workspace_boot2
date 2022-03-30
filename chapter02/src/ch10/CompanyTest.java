package ch10;

public class CompanyTest {

	public static void main(String[] args) {
		
		// 단 한개의 주소만 가지는 company 만들겠다.
		
		
//		Company company = new Company();
		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();
		Company company3 = Company.getInstance();
			
		System.out.println(company1);
		System.out.println(company2);
		System.out.println(company3);
		
	}

}
