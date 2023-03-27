package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();

	public List<Member> selectMemberList() throws Exception {
		Connection conn = getConnection();
		List<Member> mem = dao.selectMemberList(conn);
		close(conn);
		return mem;
	}

	public int updateMember(String memberName, String memberGender, int memberNo) throws Exception {
		Connection conn = getConnection();
		int i = dao.updateMember(conn, memberName, memberGender, memberNo);
		if (i > 0) commit(conn);
		else		rollback(conn);
		close(conn);
		return i;
	}

	public int updatePassword(String nowPw, String newPw, int memberNo) throws Exception {
		Connection conn = getConnection();
		int i = dao.updatePassword(conn, nowPw, newPw, memberNo);
		if(i > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return i;
	}
	
	/** 숫자 6자리 보안코드 생성
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer();
		// String 불변성, StringBuffer 가변성
		Random ran = new Random();
		for(int i=0; i<6; i++) {
			int x = ran.nextInt(10); // 0이상 10미만 정수
			code.append(x);
		}
		return code.toString();
	}

	public int unRegistMember(String pw, int memberNo) throws Exception {
		Connection conn = getConnection();
		int i = dao.unRegistMember(conn, pw, memberNo);
		if(i > 0) commit(conn);
		else rollback(conn);
		close(conn);
		return i;
	}
	
	
}
