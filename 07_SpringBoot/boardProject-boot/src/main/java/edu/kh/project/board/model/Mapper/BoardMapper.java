package edu.kh.project.board.model.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.project.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	List<Map<String, Object>> selectBoardTypeList();
	
	/** 특정 게시판의 삭제되지 ㅇ낳은 게시글 수 조회
	 * @param boardCode
	 * @return
	 */
	public int getListCount(int boardCode) ;

	/** 특정 게시판에서 현재 페이지에 해당하는 부분에 대한 게시글 조회
	 * @param pagination
	 * @param boardCode
	 * @return
	 */
	public List<Board> selectBoardList(int boardCode, RowBounds rowbounds);

	/** 게시글 상세조회
	 * @param map
	 * @return
	 */
	public Board selectBoard(Map<String, Object> map) ;

	public int boardLikeCheck(Map<String, Object> map);
	/** 좋아요 삽입
	 * @param paramMap
	 * @return
	 */
	public int insertBoardLike(Map<String, Integer> paramMap);

	/** 좋아요 삭제
	 * @param paramMap
	 * @return
	 */
	public int deleteBoardLike(Map<String, Integer> paramMap) ;

	public int countBoardLike(Integer integer);
	
	

	/** 조회 수 증가
	 * @param boardNo
	 * @return
	 */
	public int updateReadCount(int boardNo);

	/** 게시글 수 조회(검색)
	 * @param paramMap
	 * @return listCount
	 */
	public int getListCount(Map<String, Object> paramMap);

	/** 게시글 목록 조회(검색) 
	 * @param pagination
	 * @param paramMap
	 * @return boardList
	 */
	public List<Board> selectSearchBoardList(Map<String, Object> paramMap, RowBounds rowbounds);
	
	/** 헤더 검색
	 * @param query
	 * @return list
	 */
	public List<Map<String, Object>> headerSearch(String query);

	/** DB 이미지(파일) 목록 조회
	 * @return
	 */
	public List<String> selectImageList();

}
