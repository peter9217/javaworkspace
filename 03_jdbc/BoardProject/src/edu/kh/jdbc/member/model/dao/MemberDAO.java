package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {
	//JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// xml에 작성된 sql을 읽어와 저장할 객체 참조 변수
	private Properties prop;
	
	public MemberDAO() { // 기본 생성자로 객체 생성 시 XML읽어오기
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-sql.xml"));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/** 회원 목록 조회 SQL 수행
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn) throws Exception{
		List<Member> memList = new ArrayList<>();
		try {
			String sql = prop.getProperty("selectMemberList");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member mem = new Member();
				mem.setMemberId(rs.getString(1));
				mem.setMemberName(rs.getString(2));
				mem.setMemberGender(rs.getString(3));
				memList.add(mem);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		return memList;
	}	
	
	
}
