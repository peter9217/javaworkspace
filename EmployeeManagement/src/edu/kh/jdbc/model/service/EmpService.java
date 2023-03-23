package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Dep;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	public List<Emp> searchAll() throws Exception{
		Connection conn = getConnection();
		List<Emp> emp = dao.searchAll(conn);
		
		return emp;
	}

	public List<Emp> searchRetire() throws Exception {
		Connection conn = getConnection();
		List<Emp> emp = dao.searchRetire(conn);
		return emp;
	}

	public Emp searchId(int input) throws Exception {
		Connection conn = getConnection();
		Emp emp = dao.searchId(conn, input);
		return emp;
	}

	public int insertEmp(Emp emp) throws Exception {
		Connection conn = getConnection();
		int result = dao.insertEmployee(conn, emp);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		}

	public int updateEmp(Emp emp) throws Exception {
		Connection conn = getConnection();
		int result = dao.updateEmp(conn, emp);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int deleteEmp(int empId) throws Exception {
		Connection conn = getConnection();
		int i = dao.deleteEmp(conn, empId);
		if(i > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return i;
	}
	
	// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
	public void retireEmp(int empId) throws Exception {
		Connection conn = getConnection();
		dao.retireEmp(conn, empId);
		commit(conn);
		close(conn);
		return ;
	}

	public List<Emp> recentEmp() throws Exception{
		Connection conn = getConnection();
		List<Emp> empList = dao.recentEmp(conn);
		return empList;
	}

	public List<Dep> deptASalary() throws Exception{
		// 각 부서별
		// 부서명, 인원 수, 급여 평균
		// 부서코드 오름차순 조회
		Connection conn = getConnection();
		List<Dep> dep = dao.deptASalary(conn); 
		return dep;
	}

	public int checkEmp(int empId) throws Exception {
		Connection conn = getConnection();
		int i = dao.checkEmp(conn, empId);
		return i;
	}

	public List<Map<String, Object>> selectDepartment() throws Exception {
		Connection conn = getConnection();
		List<Map<String, Object>> mapList = dao.selectDepartment(conn);
		close(conn);
		return mapList;
	}
}
