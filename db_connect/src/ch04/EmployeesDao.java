package ch04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesDao implements IEmployees{

	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet resultSet = null;
	
	@Override
	public ArrayList<EmployeesDto> join1() {
		
		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
			
		
		
			String query1 = "SELECT s.emp_no, s.salary, s.to_date, e.hire_date FROM salaries AS s "
					+ "JOIN employees AS e ON s.emp_no = e.emp_ no GROUP BY s.emp_no HAVING e.hire_date > '1990-01-01' ";

			try{
				resultSet = connection.prepareStatement(query1).executeQuery();
				
				
				while (resultSet.next()) {
					
					EmployeesDto dto = new EmployeesDto();
					
					dto.setEmp_no(resultSet.getInt("emp_no"));
					dto.setSalary(resultSet.getInt("salary"));
					dto.setTo_date(resultSet.getString("to_date"));
					dto.setHire_date(resultSet.getString("hire_date"));
					
					employees.add(dto);
					
				}
				
				
				
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		return employees;
//			while(resultSet.next()) {
//				
//				
//				
//				
//				
//			}
			
			
			
		
		
	}
}
