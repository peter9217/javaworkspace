package edu.kh.jdbc.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.dto.Employee;

//DAO (Data Access Object) : DB접근용 객체
public class EmployeeDAO {
	
	// JDBC 구문이 여러 번 작성될 예정
	// -> JDBC 객체 참조 변수가 계속 작성될 예정
	//	-> 필드로 작성하여 재사용
	
	private Statement stmt;
	private ResultSet rs;
	
	private PreparedStatement pstmt; //외부 변수(값)를 SQL에 삽입할 준비가 된 Statment
	
	// PreparedStatement는 Statement 클래스의 자식 클래스로 SQL구문에 ? 기호를 작성해서 SQL에 작성되어지는 리터럴 값을 동적으로 제어하는 기능을 가지고 있다.

	// ? 기호 = placeholoder
	
	
	/* 전체 사원 조회 SQL수행 후 결과 반환 메서드 
	 * empList 
	 * SQLException*/
	public List<Employee> selectAll(Connection conn) throws SQLException {
		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입
			// 1) SQL작성 
			// 사번, 이름, 부서명, 직급명, 전화번호, 직급코드 오름차순
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE FROM EMPLOYEE NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID) ORDER BY JOB_CODE";
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			
			// 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
			while(rs.next()) {
				String empId = rs.getString(1);
				String empName = rs.getString(2);
				String empdepartmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				Employee emp=new Employee(Integer.parseInt(empId), empName, phone, empdepartmentName, jobName);
				empList.add(emp);
				
			}
			
		} finally {
			// catch문 -> throws 구문으로 예외 처리
			// 4. JDBC 객체 자원 반환 (단, conn 빼고)
			close(stmt);
			close(rs);
			
		}
		
		// 5. 결과 반환
		return empList;
	}

	/** 사번으로 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException{
		// 1. 결과 저장을 위한 변수/객체 준비
		Employee emp = null;
		// -> 조회 결과가 있을 경우에 객체 생성
		
		try {
			// 2. SQL 작성 후 수행
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE FROM EMPLOYEE NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID) WHERE EMP_ID = "+input;
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			// 3. 조회 결과가 있는 지 확인 후 == 있으면 Employee 객체 생성 후 emp에 대입
			if(rs.next()) {
				String empId = rs.getString(1);// DB에서 값을 얻어올 때 "숫자" (문자열로 된 숫자) 형태일 경우 getInt()를 작성하면 자동으로 int 형변환 진행
				String empName = rs.getString(2);
				String empdepartmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				// 객체 생성해서 emp에 대입
				emp = new Employee(Integer.parseInt(empId), empName, phone, empdepartmentName, jobName);
			}
			//if(조건식){true 이면 수행} --> 1번 수행
			
			//while(조건식){true 이면 수행} + 반복
			// --> 1행만 조회되면 1번 수행
			// --> 불필요한 검사를 진행할 수 있다. (1행은 if문 권장)
		
		} finally {
			// 4. JDBC 객체 자원 반환 (conn빼고)
			close(rs);
			close(stmt);
		}
		return emp;
	}
	
	public List<Employee> selectName(Connection conn, String input) throws SQLException {
		List<Employee> list = new ArrayList<>();
		try {
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, NVL(PHONE, '없음') PHONE FROM EMPLOYEE NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID) WHERE EMP_NAME LIKE '%"+input+"%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String empId = rs.getString(1);// DB에서 값을 얻어올 때 "숫자" (문자열로 된 숫자) 형태일 경우 getInt()를 작성하면 자동으로 int 형변환 진행
				String empName = rs.getString(2);
				String empdepartmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				// 객체 생성해서 emp에 대입
				Employee emp = new Employee(Integer.parseInt(empId), empName, phone, empdepartmentName, jobName);
				list.add(emp);
				
				
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	/** 급여 범위 조회 SQL 수행 후 결과 반환 메서드
	 * @param connection
	 * @param first
	 * @param second
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> selectSalary(Connection connection, int first, int second) throws SQLException{
		List<Employee> list = new ArrayList<>();
		try {
			//2번
//			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, SALARY FROM EMPLOYEE NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID) WHERE SALARY >="+first+ "AND SALARY<="+second;
//			// SQL을 수행하고 결과를 반환 받을 Statement 객체 생성
//			stmt = connection.createStatement();
//			// SQL(SELECT)수행 후 결과(ResultSet) 반환 받아 저장
//			rs = stmt.executeQuery(sql);
			//------------------------------------------------------------------------------
			// 2번 대체******************************* preparedStatement
			String sql = "SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '없음') DEPT_TITLE, JOB_NAME, SALARY FROM EMPLOYEE NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID) WHERE SALARY >= ?  AND SALARY<= ?";
			//-- > 값이 동적으로 추가되는 부분을 ?기호로 작성
			// SQL을 수행하고 결과를 반환 받을 PreparedStatement 객체 생성
			pstmt = connection.prepareStatement(sql);
			// PreparedStatement에 추가된 SQL 구문에서 미완성된(?) 부분에 알맞은 값을 추가
			// pstmt.set 자료형 (순서, 값)
			// -> 순서번째 ?에 값을 세팅 (자료형은 값에 맞게 지정)
			pstmt.setInt(1, first);
			pstmt.setInt(2, second);
			
			// 준비가 완료된 PreparedStatement를 이용해서 SQL 수행 후 결과 반환 받기
			rs=pstmt.executeQuery();
			// SQL이 담겨져 있기 때문에 SQL 수행 구문에서 따로 매개변수를 작성하지 않는다.
			
			
			// 커서를 이용해서 조회 결과를 1행씩 접근
			while(rs.next()) {
//				String empId = rs.getString(1);
//				String empName = rs.getString(2);
//				String empdepartmentName = rs.getString(3);
//				String jobName = rs.getString(4);
//				int salary = rs.getInt(5);
//				
				// 객체 생성해서 emp에 대입
				// (기본 생성자 + setter)
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setDepartmentTitle(rs.getString(3));
				emp.setJobName(rs.getString(4));
				emp.setSalary(rs.getInt(5));
				
				
				list.add(emp);
				
				
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return list;
	}

	/** 사원 정보를 삽입하는 SQL 수행 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmployee(Connection conn, Employee emp) throws SQLException {
		// ** DML 수행 시 영향을 끼친 행의 개수가 반환된다.
		// 삽입된 행의 개수, 수정된 행의 개수, 삭제된 행의 개수
		// -> 행의 개수 == 숫자(정수) == int 사용
		// 1. 결과를 저장할 변수/객체 선언
		int result = 0;
		try {
			// 2. PreparedStatement 객체 생성
			// 1. SQL 작성
			String sql = "INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
			// 2) pREPAREDsTATEMENT 객체 생성 후 placeholder에 세팅 값
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmail());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getDeptCode());
			pstmt.setString(6, emp.getJobCode());
			pstmt.setString(7, emp.getSalLevel());
			pstmt.setInt(8, emp.getSalary());
			pstmt.setDouble(9, emp.getBonus());
			pstmt.setInt(10, emp.getManagerId());
			
			// 3. SQL 수행 후 결과 반환 받기
			// executeQuery() : SELECT 수행 후 ResultSet 반환
			// executeUpdate() : DML 수행 후 결과 행의 개수 반환
			
			result = pstmt.executeUpdate();
			// select와 다르게 옮겨 담는 과정이 없다.
		} finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
			// -> Statement를 close() 하는 메서드 호출 ( 매개변수에 다형성 업캐스팅 적용)
		}
		
		// 5. 결과반환
		return result;
	}

	/** 사원 정보를 수정한 후 결과 행 개수 반환하는 메서드
	 * @param conn
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmployee(Connection conn, Employee emp) throws SQLException {
		
		// 1. 결과 저장용 변수/객체 선언
		int result = 0;
		
		try {
			// 2. PreparedStatement 생성
			// 1) SQL
			String sql = "UPDATE EMPLOYEE SET EMAIL = ?, PHONE = ?, SALARY = ? WHERE EMP_ID = ?";
			// 2) PreparedStatement 생성 후 placeholder에 값 세팅 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setInt(4, emp.getEmpId());
			// set자료형() 으로 ?에 값을 세팅할 때- 자료형에 맞는 DB 리터럴 표기법으로 변환되서 세팅된다.
			// setString() -> 'hong_gd@naver.com'
			
			// 3. 수행 후 결과 반환 받기
			result = pstmt.executeUpdate();
			
		}finally {
			//4. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 5. 결과 반환
		return result;
	}

	/** 퇴사 처리 sql 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return
	 * @throws SQLException
	 */
	public int retireEmployee(Connection conn, int input) throws SQLException {
		int result = 0;
		try {
			String sql = "UPDATE EMPLOYEE SET ENT_DATE = SYSDATE, ENT_YN = 'Y' WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate(); // 1행 성공, 0행 성공
			
		} finally {
			// 4. JDBC 객체 자원 반환
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
}
