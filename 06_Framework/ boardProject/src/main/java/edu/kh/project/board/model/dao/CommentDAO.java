package edu.kh.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;


@Repository // DB관련 + bean 등록 (IOC)
public class CommentDAO {

	@Autowired // DI, root-context.xml에서 bean 등록
	private SqlSessionTemplate sqlSession;

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return
	 */
	public List<Comment> select(int boardNo) {
		return sqlSession.selectList("boardMapper.selectCommentList", boardNo);
	}
	
	
	

  	/** 댓글 삽입
	 * @param comment
	 * @return
	 */
	public int insert(Comment comment) {
		return sqlSession.insert("commentMapper.insert", comment);
	}




	/** 댓삭
	 * @param comment
	 * @return
	 */
	public int delete(int commentNo) {
		// TODO Auto-generated method stub
		System.out.println(commentNo);
		return sqlSession.update("commentMapper.delete", commentNo);
	}




	/** 댓수
	 * @param comment
	 * @return
	 */
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return sqlSession.update("commentMapper.update", comment);
	}
	
	
	
	
	
	
}
