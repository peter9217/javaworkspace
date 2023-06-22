package edu.kh.project.board.model.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;


@Mapper // DB관련 + bean 등록 (IOC)
public interface CommentMapper {

	@Autowired // DI, root-context.xml에서 bean 등록

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return
	 */
	public List<Comment> select(int boardNo);
	
	
	

  	/** 댓글 삽입
	 * @param comment
	 * @return
	 */
	public int insert(Comment comment);




	/** 댓삭
	 * @param comment
	 * @return
	 */
	public int delete(int commentNo);




	/** 댓수
	 * @param comment
	 * @return
	 */
	public int update(Comment comment);
	
	
	
	
	
	
}
