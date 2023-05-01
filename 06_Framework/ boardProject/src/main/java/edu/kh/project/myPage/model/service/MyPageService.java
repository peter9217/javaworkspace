package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원 정보 수정 서비스
	 * @param updateMember
	 * @return result
	 */
	int updateInfo(Member updateMember);

	/** 비밀번호 변경 서비스
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return
	 */
	int changePw(String currentPw, String newPw, int memberNo);

	
	/** 회원 탏퇴
	 * @param memberPw
	 * @param memberNo
	 * @return
	 */
	int del(String memberPw, int memberNo);

}
