DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"MEMBER_NO"		NUMBER			NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)	NOT NULL,
	"MEMBER_PW"		VARCHAR2(100)	NOT NULL,
	"MEMBER_NICKNAME" VARCHAR2(100)	NOT NULL,
	"MEMBER_TEL"	CHAR(11)		NOT NULL,
	"MEMBER_ADDR"	VARCHAR2(300)	NULL,
	"PROFILE_IMG"	VARCHAR2(300)	NULL,
	"ENROLL_DATE"	DATE			DEFAULT SYSDATE	NOT NULL,
	"MEMBER_DEL_FL"	CHAR(1)			DEFAULT 'N'		NOT NULL,
	"AUTHORITY"		NUMBER			DEFAULT 1		NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';
COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일';
COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호(암호화 적용)';
COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원 이름(별명)';
COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(-없음)';
COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원 주소';
COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지 저장 경로';
COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '회원 가입일';
COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" IS '탈퇴여부(N:탈퇴X, Y:탈퇴O)';
COMMENT ON COLUMN "MEMBER"."AUTHORITY" IS '회원권한(1:일반,2:관리자)';

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

-- 탈퇴여부 CHECK 제약조건 추가
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_MEMBER_DEL_FL"
CHECK("MEMBER_DEL_FL" IN ('N', 'Y'));

-- 권한 CHECK 제약조건 추가
ALTER TABLE "MEMBER" ADD CONSTRAINT "CH_AUTHORITY"
CHECK("AUTHORITY" IN (1, 2));

-- 회원 번호 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

-- 샘플 계정 추가
INSERT INTO "MEMBER" 
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01@mail.com', 'pass01', '유저일', '01012341234', '04540,,서울시 중구 남대문로 120,,2층', NULL, DEFAULT, DEFAULT, DEFAULT);

-- 로그인 SQL
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDR, PROFILE_IMG, AUTHORITY, TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') ENROLL_DATE
FROM "MEMBER"
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_EMAIL = 'user01@mail.com'
AND MEMBER_PW = 'pass01'
;

SELECT * FROM "MEMBER";
