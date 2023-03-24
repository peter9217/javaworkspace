package edu.kh.jdbc.main.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MainDAO {
	
	// 필드 
	// JDBC 객체 참조 변수
	private Statement stmt; // SQL수행, 결과 반환
	private PreparedStatement pstmt; //placeholder를 포함한 SQL세팅/수행
	private ResultSet rs; // SELECT 수행 결과 저장
	
	private Properties prop;
	// - Map<String, String> 형태
	// - XML파일 입/출력 메서드를 제공
	
	public MainDAO() {
		// DAO 객체가 생성될 때 XML 파일을 읽어와 Properties 객체에 저장
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("main-sql.xml"));
			// -> Properties 객체에 key:value 형식으로 xml내용이 저장됨
			// -> prop.getProperty("key") 호출 -> value(SQL) 반환
		}catch(Exception e ) {
			e.printStackTrace();
		}
	} // 기본 생성자
	public Member login(Connection conn, String memberId, String memberPw) throws Exception{
		Member mem = null;
		
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				//입력받은 아이디 == 조회한 아이디 꺼낼 필요 없음
				//String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				String enrollDate = rs.getString("ENROLL_DT");
				
				// Member 객체 생성 후 값 세팅
				mem = new Member();
				mem.setMemberNo(memberNo);
				mem.setMemberId(memberId);
				mem.setMemberName(memberName);
				mem.setMemberGender(memberGender);
				mem.setEnrollDate(enrollDate);
				
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return mem;
	}
	
	/** 아이디 중복 검사 SQL 수행 
	 * @param conn
	 * @param memberId
	 * @return
	 */
	
	public int idDuplicationCheck(Connection conn, String memberId) throws Exception{
		int i = 0;
		try {
			String sql = prop.getProperty("idDuplicationCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()) i = rs.getInt(1);
			
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		return i;
	}
	public int signUp(Connection conn, Member member) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			i = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
			
		}
		return i;
	}
	
	
	
	
}
