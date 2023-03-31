package edu.kh.jdbc.board.model.service;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;

public class CommentService {
	private static CommentDAO commentDao = new CommentDAO();
	

	public static int insertComment(int boardNo, String string, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int i = commentDao.insertComment(conn, boardNo, string, memberNo);
		close(conn);
		return i;
	}


	public static int checkComment(int input) throws Exception{
		Connection conn = getConnection();
		int i = commentDao.checkComment(conn, input);
		close(conn);
		return i;
	}


	public static int reComment(String string, int commentNo) throws Exception{
		Connection conn = getConnection();
		int i = commentDao.reComment(conn, string, commentNo);
		close(conn);
		return i;
	}


	public static int deleteComment(int input) throws Exception {
		Connection conn = getConnection();
		int i = commentDao.deleteComment(conn, input);
		close(conn);
		return i;
	}


	public static List<Comment> board(int boardNo) throws Exception{
		Connection conn = getConnection();
		List<Comment> i = commentDao.board(conn, boardNo);
		close(conn);
		
		return i;
	}
	
	

}
