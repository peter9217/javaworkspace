package edu.kh.project.myPage.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // 저장소(DB)와 관련된 클래스 + Bean 등록(IOC, 스프링이 객체 관리)
public class MyPageDAO {
	
	// 등록된 Bean 중 타입이 sqlSessionTemplate으로 일치하는 Bean을 주입 (DI)
	// -> root-context.xml에 <bean> 작성됨 
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	
	/** 회원 정보 수정 DAO
	 * @param updateMember
	 * @return result
	 */
	public int updateInfo(Member updateMember) {
		
		
		
		
		return sqlSession.update("myPageMapper.updateInfo", updateMember);
	}



	/** 회원 비밀번호 조회
	 * @param memberNo
	 * @return encPw
	 */
	public String selectEncPw(int memberNo) {
		
		
		return sqlSession.selectOne("myPageMapper.selectEncPw", memberNo);
	}



	/** 비밀번호 변경
	 * @param newPw
	 * @param memberNo
	 * @return result
 	 */
	public int changePw(String newPw, int memberNo) {
		// MyBatis에서 SQL 수행 시 전달할 수 있는 파라미터는 딱 한 개!
		// -> 여러 파라미터를 전달해야 하는 경우 Map 또는 DTO로 묶어서 전달
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberPw(newPw);
		
		return sqlSession.update("myPageMapper.changePw", member);
		
		
	}



	/** 회원 탈퇴
	 * @param memberNo
	 * @return
	 */
	public int del(int memberNo) {
		Member member = new Member();
		member.setMemberNo(memberNo);
		
		
		return sqlSession.update("myPageMapper.del", member);
	}



	/** 프로필 이미지 수정
	 * @param loginMember
	 * @return 
	 */
	public int updateProfileImage(Member loginMember) {
		return sqlSession.update("myPageMapper.updateProfileImage", loginMember);
	} 

}
