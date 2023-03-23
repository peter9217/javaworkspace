package edu.kh.jdbc.model.dao;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Dep;
import edu.kh.jdbc.model.dto.Emp;


public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Emp> searchAll(Connection conn) throws Exception{
		List<Emp> emp = new ArrayList();
		// 현재 재직중인 사원의
		// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
		// 직급코드 오름차순으로 조회
		
		try {
			String sql = "SELECT EMP_NO, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL FROM EMPLOYEE LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE) JOIN JOB USING(JOB_CODE) WHERE ENT_YN='N'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String empNo = rs.getString(1);
				String empName = rs.getString(2);
				String departmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				
				Emp emp1 = new Emp(empNo, empName, departmentTitle, jobName, salary, phone, email);
				emp.add(emp1);
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		
		
		return emp;
	}

	public List<Emp> searchRetire(Connection conn) throws Exception {
		List<Emp> emp = new ArrayList();
		try {
			//사번, 이름, 전화번호, 이메일, 퇴사일을
			// 퇴사일 오름차순으로 조회
			String sql = "SELECT EMP_ID, EMP_NAME, PHONE, EMAIL, ENT_DATE FROM EMPLOYEE WHERE ENT_YN='Y'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5);
				Emp emp1 = new Emp(empId, empName, email, phone, entDate);
				emp.add(emp1);
			}
			
			
		} finally  {
			close(rs);
			close(stmt);
			
		}
		return emp;
	}

	public Emp searchId(Connection conn, int input) throws Exception {
		// 사번을 입력 받아 일치하는 사원의
		// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
		// 단, 사번이 일치하는 사원이 없으면
		// "사번이 일치하는 사원이 없습니다" 출력
		
		String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY, PHONE, EMAIL, ENT_DATE, ENT_YN FROM EMPLOYEE LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE) JOIN JOB USING(JOB_CODE) WHERE EMP_ID = ?";
		Emp emp = new Emp();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setDepartmentTitle(rs.getString(3));
				emp.setJobName(rs.getString(4));
				emp.setSalary(rs.getInt(5));
				emp.setPhone(rs.getString(6));
				emp.setEmail(rs.getString(7));
				emp.setEntDate(rs.getString(8));
				emp.setEntYN(rs.getString(9));
			}
			
			
		} finally {
			close(pstmt);
		}
		
		return emp;
	}

	public int insertEmployee(Connection conn, Emp emp) throws Exception {
		int i;
		String sql ="INSERT INTO EMPLOYEE VALUES(SEQ_EMP_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, NULL, 'N')";
		
		try {
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
			i = pstmt.executeUpdate();
		} finally {
			// TODO Auto-generated catch block
			close(pstmt);
		}
		return i;
	}
	
	//이메일, 전화번호, 급여, 보너스 수정
	public int updateEmp(Connection conn, Emp emp) throws Exception {
		int i;
		String sql = "UPDATE EMPLOYEE SET EMAIL = ?, PHONE = ?, SALARY = ?, BONUS = ? WHERE EMP_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setDouble(4, emp.getBonus());
			pstmt.setInt(5, emp.getEmpId());
			i = pstmt.executeUpdate();
		} finally {
			// TODO: handle finally clause
			close(pstmt);
		}
		return i;
		
	}
	
	// SELECT문 : executeQuery(SQL)
	// DML문 : executeUpdate(SQL)
	// SQL 작성하는 경우 : Statement 객체 사용 할 때
	
	
	
	
	public int deleteEmp(Connection conn, int empId) throws Exception {
		int i = 0;
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			i = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return i;
	}
	
	// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
	public void retireEmp(Connection conn, int empId) throws Exception {
		
		String sql = "UPDATE EMPLOYEE SET ENT_YN = 'Y', ENT_DATE = SYSDATE WHERE EMP_ID = ? AND ENT_YN='N'";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			pstmt.executeQuery();
		} finally {
			close(pstmt);
		}
		return ;
	}
	
	// 가장 최근(입사일이 늦은) 사원 5명의
	// 사번, 이름, 부서명, 입사일을
	// 입사일 내림차순으로 조회

	public List<Emp> recentEmp(Connection conn) throws Exception {
		List<Emp> emp= new ArrayList<>();
		String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE FROM EMPLOYEE LEFT JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE) ORDER BY HIRE_DATE DESC) WHERE ROWNUM<6";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Emp i = new Emp();
				i.setEmpId(rs.getInt(1));
				i.setEmpName(rs.getString(2));
				i.setDepartmentTitle(rs.getString(3));
				i.setHireDate(rs.getDate(4));
				emp.add(i);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return emp;
	}
	// 부서명, 인원 수, 급여 평균
	public List<Dep> deptASalary(Connection conn) throws Exception {
		List<Dep> dep = new ArrayList();
		String sql = "SELECT DEPT_TITLE, ROUND(COUNT(DEPT_TITLE), 0), AVG(SALARY) FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE) GROUP BY DEPT_TITLE, DEPT_ID ORDER BY DEPT_ID";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Dep i = new Dep();
				i.setName(rs.getString(1));
				i.setMembers(rs.getInt(2));
				i.setSalary(rs.getInt(3));
				dep.add(i);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dep;
	}

	public int checkEmp(Connection conn, int empId) throws Exception {
		int i=0;
		String sql = "SELECT DEPT_TITLE, ROUND(COUNT(DEPT_TITLE), 0), AVG(SALARY) FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_ID=DEPT_CODE) GROUP BY DEPT_TITLE, DEPT_ID ORDER BY DEPT_ID";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String deptTitle = rs.getString("DEPT_TITLE");
		}
		return i;
	}
//		try {
//			
//
//			}
//		} finally {
//			close(rs);
//			close(pstmt);
//
//		}
//		
//		return i;
//	}

	public List<Map<String, Object>> selectDepartment(Connection conn) throws Exception{
		// 1. 결과 저장용 객체 생성
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		try {
			// 2. SQL 작성 후 수행
			String sql = "SELECT DEPT_TITLE, COUNT(*) 인원, FLOOR(AVG(SALARY)) 평균 FROM EMPLOYEE LEFT JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID) GROUP BY DEPT_TITLE ORDER BY DEPT_CODE"; 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				for(int i, i<, i++) {
					mapList.get(i).put("DEPT_TITLE", rs.getInt(1));
					mapList.get(i).put("COUNT", rs.getInt(2));
					mapList.get(i).put("SALARY", rs.getInt(3));				
					
				}
			}
		}finally {
			
		}
		
		return null;
	}

	
}
