package edu.kh.jdbc.main.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MainService {
	
	private MainDAO dao = new MainDAO();

	/** 로그인 서비스
	 * @param memberId
	 * @param memberPw
	 * @return ember
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {
		Connection conn = getConnection();
		Member mem = dao.login(conn, memberId, memberPw);
		close(conn);
		return mem;
	}

	/** 아이디 중복 검사 서비스
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public int idDuplicationCheck(String memberId) throws Exception {
		Connection conn = getConnection();
		int check = dao.idDuplicationCheck(conn, memberId);
		close(conn);
		return check;
	}

	public int signUp(Member member) throws Exception {
		Connection conn = getConnection();
		int i = dao.signUp(conn, member);
		if(i > 0 ) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return i;
	}
	
	
	
	
	
	
	

	
}
