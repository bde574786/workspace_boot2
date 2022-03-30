package ch09;

public class Employee {


	public static int serialNum;
	
	private int employeeId;
	private String employeeName;
	private String department;
	
	public Employee() {
	    serialNum++;
		this.employeeId = serialNum;
	}
	
	public void showInfo() {
		System.out.println("사원 번호 : " + employeeId);
		System.out.println("사원 이름 : " + employeeName);
		System.out.println("사원 부서 : " + department);
	}

	// 단축키 사용
	// getter, setter
	public static int getSerialNum() {
		// Static 주의점
		// Static 영역에서 인스턴스 멤버 변수에 접근할 수 없다.
		// 객체가 생성되어 있는지 아닌지 보장할 수 없기 때문에 문법 오류
		
		// 멤버변수는 객체가 메모리에 올라가야 쓸 수 있지만
		// 스태틱은 메모리가 올라가기 전에 바로 뜨기 때문
		// 스태틱 메서드가 메모리에 먼저 떠 버림
//		String temp = serialNum + "_" + employeeId;
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Employee.serialNum = serialNum;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		// 홍길동_사원번호
		this.employeeName = employeeName + "_" + serialNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	// 1. static 변수
	// 2. 멤버 변수
	// 3. 지역 변수
	// 결론 : 어느 메모리에 위치 하느냐에 따라 이름을 구분지어 말할 수 있다.
	
	
}
