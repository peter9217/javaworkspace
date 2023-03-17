package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee1;
import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {
	public List<Employee2> select(String jobName) {
		
		List<Employee2> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//---------------------------------------------------ClassNotFound : 오라클 드라이버 경로 
			// 메모리에 드라이버 객체 로드
			// DB연결 정보
			// Connection 생성 시 필요한 값을 미리 변수에 대입
			String type = "jdbc:oracle:thin:@";
			String ip = "localhost"; // DB서버 : 115.90.212.22
			String port = ":1521"; // DB서버 : 9000
			String dbName = ":ORCL"; // 19c -> :ORCL , 18c, DB서버 -> :XE
			//-------------------------------------- SQLRecoverble DB연결을 위한 URL 오타
			String user = "kh_jbs";
			String pw = "oracle_jbs123A";
			//------------------------------------SQLException 아이디 비밀번호 오타
			String condition = null;
			conn = DriverManager.getConnection(type+ip+port+dbName, user, pw);
			//부서명, 직급명, 이름, 이메일
			if(jobName.equals("null")) {
				condition = "WHERE JOB_NAME IS NULL";
			}else {
				condition = "WHERE JOB_NAME= '" + jobName +"'"; 
			}
			String sql = "SELECT DEPT_TITLE, JOB_NAME, EMP_NAME, EMAIL FROM EMPLOYEE JOIN DEPARTMENT d ON(DEPT_CODE = DEPT_ID) JOIN JOB USING(JOB_CODE)"+condition;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String dept = rs.getString(1);
				String job = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				Employee2 emp = new Employee2(dept, job, name, email);
				list.add(emp);
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
		return list; // 조회 결과가 담긴 empList 반환
	}
}
