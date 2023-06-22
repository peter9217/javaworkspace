package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

/**
 * @author user1
 *
 */
public interface AjaxService {

	/** 이메일로 닉네임 조회
	 * @param email
	 * @return nickname
	 */
	String selectNickname(String email);

	
	
	/** 닉네임으로 전화번호 조회
 	 * @param nickname
	 * @return tel
	 */
	String selectMemberTel(String nickname);



	/** 이메일 중복 확인
	 * @param email
	 * @return count
	 */
	int checkEmail(String email);



	/** 닉네임 중복 검사
	 * @param nickname
	 * @return
	 */
	int checkNickname(String nickname);



	/** 이메일로 정보 조회
	 * @param email
	 * @return
	 */
	Member selectMember(String email);



	/** 단어가 포함한 회원 정보 조회
	 * @param input
	 * @return
	 */
	List<Member> selectMemberList(String input);
	

}
