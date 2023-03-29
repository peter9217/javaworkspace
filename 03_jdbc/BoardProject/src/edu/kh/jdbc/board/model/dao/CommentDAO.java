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

import edu.kh.jdbc.board.model.dto.Comment;



public class CommentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
		} catch (Exception  e) {
			e.printStackTrace();

		}
	}
	
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception {
		List<Comment> commentList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("comment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Comment c = new Comment();
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				commentList.add(c);
				
			}
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return commentList; 
	}

	public int insertComment(Connection conn, int boardNo, String string, int memberNo) throws Exception {
		int i = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, string);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, boardNo);
			i = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return i;
	}

	public int checkComment(Connection conn, int input) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("checkComment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return i;
	}

	public int reComment(Connection conn, String string, int commentNo) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("reComment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, string);
			pstmt.setInt(2, commentNo);
			i = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return i;
	}

	public int deleteComment(Connection conn, int input) throws Exception {
		int i = 0;
		try {
			String sql = prop.getProperty("deleteComment");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			i = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return i;
	}

	public List<Comment> board(Connection conn, int boardNo) throws Exception {
		List<Comment> i = new ArrayList();
		try {
			String sql = prop.getProperty("board");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Comment c = new Comment();
				int e = rs.getInt("COMMENT_NO");
				c.setCommentNo(e);
				System.out.print(c.getCommentNo());
				i.add(c);
			}
		} finally {
			close(pstmt);
		}
		
		return i;
	}
	
	
}
	
	