-- 함수 : 컬럼의 값을 읽어서 연산 결과를 반환

-- 단일행 함수 : N개의 행의 값을 전달하여 N개의 결과를 반환

-- 그룹 함수 : N개의 행의 값을 하나의 그룹으로 묶어 그룹 수 만큼의 결과를 반환

-- 함수는 SELECT절, WHERE절, ORDER BY절, GROUP BY절, HAVING절 사용 가능
/************* 단일행 함수 ***********************/

--<문자열 관련 함수>

-- LENGTH(문자열 | 컬럼명) : 문자열 길이 반환
SELECT 'HELLO WORLD', LENGTH('HELLO WORLD') FROM DUAL;

-- EMPLOYEE 테이블에서 이메일이 12글자인 사원의 이름, 이메일 조회
SELECT EMP_NAME, EMAIL FROM EMPLOYEE WHERE LENGTH(EMAIL) = 12;

-- EMPLOYEE 테이블에서 이메일 길이 오름차순으로 조회
SELECT EMP_NAME, EMAIL FROM EMPLOYEE ORDER BY LENGTH(EMAIL) ASC;

------------------------------------------------
-- INSTR(문자열|컬럼명, '찾을 문자열' [, 찾을 시작 위치[, 순번]])
-- 찾을 시작 위치부터 지정된 순번째에 찾을 문자열의 시작 위치 반환
-- 문자열에서 맨 앞에 있는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B') FROM DUAL; -- 3

-- 문자열을 5번째부터 검색하여 처음 찾는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA','B',5) FROM DUAL; -- 3
						--    12345

-- 문자열을 5번째부터 검색하여 두번째로 찾는 B의 위치 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA','B',5,2) FROM DUAL; -- 3
						--    12345

-- EMPLOYEE 테이블에서 사원명, 이메일 중 '@' 위치 조회
SELECT EMP_NAME, EMAIL, INSTR(EMAIL, '@') FROM EMPLOYEE;

----------------------------------------------------------
--SUBSTR(문자열|컬럼명, 시작 위치 [, 길이]ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ)
-- 문자열을 시작 위치부터 지정된 길이 만큼 잘라내서 반환
-- 길이 미작성 시 시작 위치부터 끝까지 잘라내서 반환
SELECT SUBSTR('ABCDEF', 3, 3) FROM DUAL; -- CDE
SELECT SUBSTR('ABCDEF', 3) FROM DUAL; -- CDEF 끝까지 다 잘라냄

-- EMPLOYEE 테이블에서 사원명과 사원의 이메일 아이디만 조회
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 아이디 FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원명과 사원의 이메일 아이디만 조회 오름차순
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 아이디 FROM EMPLOYEE ORDER BY 아이디;

-----------------------------------------------------

-- TRIM([[옵션]문자열|컬럼명 FROM ]문자열|컬럼명)
-- 주어진 문자열의 앞|뒤쪽|양쪽에 존재하는 지정된 문자열를 제거
-- 옵션 : LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)

SELECT '     K H     ', TRIM(LEADING ' 'FROM '     K H     ')FROM DUAL;
SELECT '     K H     ', TRIM(TRAILING  ' 'FROM '     K H     ')FROM DUAL;
SELECT '     K H     ', TRIM(BOTH  ' 'FROM '     K H     ')FROM DUAL;

SELECT '#####K H#####', TRIM(LEADING  '#'FROM '#####K H#####'),
 '#####K H#####', TRIM(TRAILING  '#'FROM '#####K H#####'),
 '#####K H#####', TRIM(BOTH  '#'FROM '#####K H#####')FROM DUAL;

-- 문자열 앞뒤 공백 제거(해당 용도로 가장 많이 사용됨)
SELECT TRIM('     K H     ') FROM DUAL;

------------------------------------------------------

-- REPLACE(문자열|컬럼명, 찾을 문자열, 바꿀 문자열)
-- 찾을 문자열을 바꿀 문자열로 변경하여 문자열 반환
SELECT REPLACE(NATIONAL_NAME, '한국', '대한민국')  FROM NATIONAL;

------------------------------------------------------

-- <숫자 관련 함수>

-- MOD(숫자|컬럼명, 숫자 | 컬럼명) : 나머지 값 반환 +-*/%
SELECT EMP_NAME, MOD(SALARY,1000000) FROM EMPLOYEE; 

-- ABS(숫자|컬럼명) : 절대값
SELECT ABS(10), ABS(-10) FROM DUAL;

-- CEIL(숫자 | 컬럼명) : 올림
-- FLOOR(숫자 | 컬럼명) : 내림
--> 둘 다 소수점 첫째 자리에서 처리 -> 정수 결과 반환

SELECT 123.5, CEIL(123.5), FLOOR(123.5) FROM DUAL;

-----------------------------------------------------

-- ROUND (숫자|컬럼명[,소수점 위치]) : 반올림
-- 소수점 위치 지정 X : 첫째자리에서 반올림 -> 정수 반환
-- 소수점 위치 지정 O :
-- 1) 양수 : 지정된 위치의 소수점까지 표현
-- 2) 음수 : 지정된 위치의 정수 자리수까지 표현

SELECT 123.456, ROUND(123.456), ROUND(123.456, 1), ROUND(123.456, 2), ROUND(123.456, 0), ROUND(166.456, -1),ROUND(123.456, -2) FROM DUAL;
									-- 소수점 첫째			--둘째 자리			정수				 1의 자리 반올림		10의 자리 반올림

-----------------------------------------------------

-- TRUNC(숫자 | 컬럼명 [, 소수점 위치]) : 잘라내기, 버림, 절삭
SELECT TRUNC(123.456), TRUNC(123.456, 1), TRUNC(123.456, -1) FROM DUAL;

SELECT FLOOR(-123.5), TRUNC(123.5) FROM DUAL;

SELECT EMP_NAME, TRUNC(SALARY,-6)||'원 이상'급여 FROM EMPLOYEE;

-----------------------------------------------------
-----------------------------------------------------------------------------------------------------

-- <날짜 관련 함수>
-- SYSDATE : 시스템에 현재 시간(년, 월, 일, 시, 분, 초) 반환
-- SYSTIMESTAMP : SYSDATE 반환값 + MS 단위 추가
SELECT SYSDATE, SYSTIMESTAMP  FROM DUAL; --2023-03-07 12:22:42.000 / 2023-03-07 12:22:42.167 +0900 <-9시간 빠르다

------------------------------------------------------------------
--MONTH_BETWEEN(날짜, 날짜) : 두 날짜의 개월 수 차이를 반환
SELECT '약' ||ROUND(MONTHS_BETWEEN('2023/07/14', '2023/02/06'))||'개월' 훈련기간 FROM DUAL; 

--EMPLOYEE 테이블에서 사원의 이름, 입사일, 근무 N년차, 근속 개월 수 조회
SELECT EMP_NAME, HIRE_DATE,CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12)"근속 N차 수",FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))"근속 개월 수"  FROM EMPLOYEE;

------------------------------------------------------------------

-- ADD_MONTHS(날짜, 숫자) : 날짜에 숫자 만큼의 개월 수 를 더하여 반환
SELECT ADD_MONTHS(SYSDATE, -1), SYSDATE, ADD_MONTHS(SYSDATE, 1) FROM DUAL;  

-- LAST_DAY(날짜) : 해당 월의 마지막 날짜를 반환
SELECT LAST_DAY(SYSDATE), LAST_DAY('2023/04/01')+1 FROM DUAL;

------------------------------------------------------------------

-- EXTRACT(YEAR | MONTH | DAY FROM 날짜)
-- 날짜에서 년 | 월 | 일을 추출하여 정수로 반환

-- EMPLOYEE 테이블에서 각 사원의 이름, 입사 년, 월, 일 조회

SELECT EMP_NAME 이름, EXTRACT(YEAR FROM HIRE_DATE) 년, EXTRACT(MONTH FROM HIRE_DATE) 월, EXTRACT(DAY FROM HIRE_DATE) 일  FROM EMPLOYEE WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2000 ORDER BY 년;












