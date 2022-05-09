package ch05;

import java.util.ArrayList;

public interface IEmployees {
	// employees 테이블에서 title이 Staff이고 사원번호가 1002인 직원 출력
	ArrayList<EmployeesDto> printEmployeeData(String title, int emp_no);
	
}
