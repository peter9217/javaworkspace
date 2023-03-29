package edu.kh.jdbc.board.model.dao;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kg.jdbc.board.dto.Board;


public class BoardDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/** 게시글 목록 조회 SQL 수행
	 * @param conn
	 * @return boardList
	 * d
	 */
	public List<Board> selectAllBoard(Connection conn) throws Exception {
		List<Board> list = new ArrayList<>();
		try {
			String sql = prop.getProperty("selectAllBoard");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				int commentCount = rs. getInt("COMMENT_COUNT");
				Board bo = new Board();
				bo.setBoardNo(boardNo);
				bo.setBoardTitle(boardTitle);
				bo.setMemberName(memberName);
				bo.setReadCount(readCount);
				bo.setCreateDate(createDate);
				bo.setCommentCount(commentCount);
				list.add(bo);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return list;
	}

	public Board selectBoard(Connection conn, int input) throws Exception {
		Board b = null;
		try {
			String sql = prop.getProperty("selectBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");				
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				int memberNo=rs.getInt("MEMBER_NO");
				
				b = new Board();
				b.setBoardNo(boardNo);
				b.setBoardTitle(boardTitle);
				b.setMemberName(memberName);
				b.setReadCount(readCount);
				b.setCreateDate(createDate);
				b.setMemberNo(memberNo);
				b.setBoardContent(boardContent);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return b;
	}

	public int updateReadCount(Connection conn, int input) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("updateReadCount");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			i = pstmt.executeUpdate();
			
			
					
		} finally {
			close(pstmt);
		}
		return i;
	}

	public int updateBoard(Connection conn, String boardTitle, String boardContent, int boardNo) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("updateBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);
			i = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return i;
	}

	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		int i = 0; // 결과 저장용 변수 선언
		try {
			String sql = prop.getProperty("deleteBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			i = pstmt.executeUpdate(); // DDL 수행 시 결과로 -1 반환
			
		} finally {
			close(conn);
		
		}
		
		return i;
	}

	public int nextBoardNo(Connection conn) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("nextBoardNo");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				i = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return i;
	}

	public int insertBoard(Connection conn, String t, String sb, int memberNo, int boardNo) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("insertBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, t);
			pstmt.setString(3, sb);
			pstmt.setInt(4, memberNo);
			i = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		
		
		
		return i;
	}
	

}
