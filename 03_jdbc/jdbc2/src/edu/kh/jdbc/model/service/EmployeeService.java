package edu.kh.jdbc.model.service;

// JDBCTemplate에 있는 static 메서드를 가져와 자신의 것처럼 사용
import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.dao.EmployeeDAO;
import edu.kh.jdbc.model.dto.Employee;

// Model : 데이터 논리 구조 제어(트랜잭션 제어), 데이터 가공 처리(비지니스 로직)
//			DAO 수행 결과를 View/Controller로 반환
// -> 프로그램(앱)에 포함되어야 할 데이터에 대한 정의


// Service : 비지니스 로직
// - 요청에 따른 필요 데이터를 반환
// + 트랜잭션 제어 처리(Commit, Rollback)
public class EmployeeService {
	
	// dao에 여러 SQL을 수행하기 위한 메서드를 각각 작성하여 호출
	private EmployeeDAO dao = new EmployeeDAO();
	
	/** 전체 ㅏ원
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll() throws SQLException{
		
		// DB에서 필요한 데이터를 조회하기 위해 
		// DAO 메서드를 호출
		
//		1. 커넥션 생성
//		-> service가 트랜잭션 제어 처리를 위해서는 connection 객체가 service에 존재해야함 
//		--> 만약 dao에서 connection을 만들고 반환하면 service쪽에서 connetion을 사용할 수 없게 된다.
//		--> 커넥션이 서비스에 있다	-> 다 쓰고 닫아주는 close()구문이 필요하다 
//		-> 서비스에 conn.close()를 작성해야 된다.
		Connection conn = getConnection();
		
//		2. dao의 메서드를 호출하여 필요한 결과를 db에서 조회해서 반환 받기
		List<Employee> empList = dao.selectAll(conn);
		
		//** DML구문인 경우 해당 위치에 commit/rollback 구문 작성 **
		
		// 3. Connction 반환
		close(conn); // JDBCTemplate 작성된 메서드 호출
		
		// 4. 결과 반환
						
		return empList;
	}

	/** 사원 1명 정보 반환 서비스
	 * @param input
	 * @return
	 */
	public Employee selectOne(int input) throws SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. DAO 메서드를 호출(커넥션, input)
		Employee emp = dao.selectOne(conn, input);
		close(conn);
		
		return emp;
	}

	public List<Employee> selectName(String input) throws SQLException {
		Connection conn=getConnection();
		List<Employee> list = dao.selectName(conn, input);
		
		close(conn);
		return list;
	}

	public List<Employee> selectSalary(int first, int second) throws SQLException {
		Connection conn = getConnection();
		List<Employee> list = dao.selectSalary(getConnection(), first, second);
		close(conn);
		return list;
	}

	/** 사원 정보 삽입
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int insertEmployee(Employee emp) throws SQLException {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		//2.
		int result = dao.insertEmployee(conn, emp);
		// DAO에서 DML(INSERT) 수행 
		// --> 트랜잭션에 임시 저장
		// -> 수행 결과에 따라 commit, rollback 지정
		if(result > 0) // 삽입 성공 시
			commit(conn);
		else 
			rollback(conn);
		// 4. 커넥션 반환
		close(conn);
		// 5, 결과 반환
		return result;
		
		}

	
	/** 사원 정보 수정
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public int updateEmployee(Employee emp) throws SQLException {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		
		// 2. DAO 메서드 호출 후 결과 반환 받기
		int result = dao.updateEmployee(conn, emp);
		
		// 3. 트랜잭션 제어 처리
		if(result>0) commit(conn);
		else rollback(conn);
		
		// 4. 커넥션 반환
		close(conn);
		
		return result;
	}

	
	/** 사원 퇴사 처리 서비스
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public int retireEmployee(int input)  throws SQLException{
		Connection conn = getConnection();
		
		int result = dao.retireEmployee(conn, input);
		// 3. 트랜잭션 제어 처리
		if (result > 0) commit(conn);
		else			rollback(conn);

		// 4. 커넥션 반환
		close(conn);
		
		// 5. 결과 반환
		return result;
	}
	
	
}
