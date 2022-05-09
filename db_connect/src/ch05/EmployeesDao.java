package ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch04.DBClient;

public class EmployeesDao implements IEmployees {
	
	
	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet resultSet = null;
	
	
	@Override
	public ArrayList<EmployeesDto> printEmployeeData(String title, int emp_no) {
		
		ArrayList<EmployeesDto> employees = new ArrayList<>();
	
		try {
			String query = "select *\r\n"
				+ "from employees as e\r\n"
				+ "where e.emp_no = (select emp_no\r\n"
				+ "from titles\r\n"
				+ "where title = ?\r\n"
				+ "and emp_no = ?);";
		
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				EmployeesDto dto = new EmployeesDto();
				
				
				
				
				
				
			}
		
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
