package edu.kh.project.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok 라이브러리 여러 자동완성

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드에 대한 매개변수 생성자
@Getter
@Setter
@ToString
public class Member {
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNickname;
	private String memberTel;
	private String memberAddress;
	private String ProfileImage;
	private String enrollDate;
	private String memberDeleteFlag;
	private int authority;

}
