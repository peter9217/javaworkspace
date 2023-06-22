package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.Mapper.CommentMapper;
import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.common.utility.util;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper mapper;
 
 	/** C List
	 *
	 */
	@Override
	public List<Comment> select(int boardNo) {
		return mapper.select(boardNo);
	}

	/** 댓글 삽입
	 *
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insert(Comment comment) {
		// XSS 방지 처리
		comment.setCommentContent(util.XSSHandling(comment.getCommentContent()));
		return mapper.insert(comment);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int delete(int commentNo) {
		return mapper.delete(commentNo);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int update(Comment comment) {
		// XSS 방지 처리
		comment.setCommentContent(util.XSSHandling(comment.getCommentContent()));
		
		return mapper.update(comment);
	}
	
	
	
	
}
