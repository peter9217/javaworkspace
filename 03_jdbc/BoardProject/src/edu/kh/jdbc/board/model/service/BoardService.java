package edu.kh.jdbc.board.model.service;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kg.jdbc.board.dto.Board;
import edu.kh.jdbc.board.model.dao.BoardDAO;

public class BoardService {
	private BoardDAO dao = new BoardDAO();

	public List<Board> selectAllBoard() throws Exception {
		Connection conn = getConnection();
		List<Board> list = dao.selectAllBoard(conn);
		close(conn);
		
		
		return list;
	}

	/** 게시글 상세 조회
	 * @param input
	 * @param memberNo1
	 * @return
	 * @throws Exception
	 */
	public Board selectBoard(int input, int memberNo) throws Exception {
		// 1. 커넥션 생성
		Connection conn = getConnection();
		Board board = dao.selectBoard(conn, input);
		if(board != null) {
			if(memberNo!=board.getMemberNo()) {
				int result = dao.updateReadCount(conn, input);
				if(result>0) {
					commit(conn);
					board.setReadCount(board.getReadCount()+1);
				}
				// 조회된 board의 조회수 0
				// DB의 조회수는 1
				else rollback(conn);
			}
		}
		close(conn);
		
		return board;
	}

	public int updateBoard(String boardTitle, String boardContent, int boardNo) throws Exception{
		Connection conn = getConnection();
		int i = dao.updateBoard(conn, boardTitle, boardContent, boardNo);
		if(i>0) commit(conn);
		else rollback(conn);
	
		close(conn);
		return i;
	}

	public int deleteBoard(int boardNo) throws Exception {
		Connection conn =getConnection();
		int result = dao.deleteBoard(conn, boardNo);
		if(result > 0) commit(conn);
		else rollback(conn);
		close(conn);
		
		
		
		
		return result;
	}

	public int insertBoard(String t, String sb, int memberNo) throws Exception {
		Connection conn = getConnection();
		int boardNo = dao.nextBoardNo(conn);
		
		int i = dao.insertBoard(conn, t, sb, memberNo, boardNo);
		if(i>0) {
			commit(conn);
			i = boardNo;
		}else {
			rollback(conn);
		}
		close(conn);
		
		return i;
	}
	
	
	
	
	
	
	
	
}
