package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee1;

// DAO (Data Access Object) : 데이터에 접근하기 위한 객체
// == DB 연결 역할 객체
public class SelectDepartmentTitleDAO {
	
	/* 부서명으로 사원 조회 DAO
	 * @param departmentTitle
	 * 
	 * */
	public List<Employee1> select(String departmentTitle) {
		// 조회 결과를 저장하고 반환할 때 사용할 List를 생성
		List<Employee1> empList = new ArrayList<>();		
		
		
		// 1단계 : JDBC 객체 참조 변수 선언
		Connection conn = null; // DB 연결 정보 저장. Statement 통로
		Statement stmt = null; // SQL수행, 결과 반환
		ResultSet rs = null; // SELECT 수행 결과 저장용 객체
		
		// 2단계 : 참조 변수에 알맞은 값 대입
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 메모리에 드라이버 객체 로드
			// DB연결 정보
			// Connection 생성 시 필요한 값을 미리 변수에 대입
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost"; // DB서버 : 115.90.212.22
			String port = ":1521"; // DB서버 : 9000
			String dbName = ":ORCL"; // 19c -> :ORCL , 18c, DB서버 -> :XE
			String user = "kh_jbs";
			String pw = "oracle_jbs123A";
			
			String condition = null;
			
			// DriverManager를 이용해 Connection 생성하여 얻어오기
			conn = DriverManager.getConnection(type+ip+port+dbName,user,pw);
			
			if(departmentTitle.equals("null")) {
				condition = "WHERE DEPT_TITLE IS NULL";
			}else {
				condition = "WHERE DEPT_TITLE= '" + departmentTitle +"'"; 
			}
			
			// SQL 작성
			
			String sql = "SELECT EMP_NO, EMP_NAME, SALARY, DEPT_TITLE FROM EMPLOYEE LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) "+condition+" ORDER BY EMP_ID";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 3단계
			while(rs.next()) { // 커서를 1행씩 이동, 다음 행이 없을 때까지
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				int salary = rs.getInt(3);
				String Title = rs.getString(4);
				Employee1 emp = new Employee1(empId, empName, salary, departmentTitle);
				empList.add(emp);
				
				
				
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return empList; // 조회 결과가 담긴 empList 반환
	}

}
