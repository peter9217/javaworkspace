package edu.kh.polymorphism.ex2.dto;

// 계산기 인터페이스
//	-> 모든 계산기에 대한 공통 필드, 기능명을 제공
//	-> 공통 규약(이름만) 설정
public interface Calculator {
	public static final double PI = 3.14;
	final int MAX_NUM = 100_000_000; //public static 생략
	int MIN_NUM = -100_000_000; 
	
	/** 두 정수의 합 반환
	 * @param a
	 * @param b
	 * @return a와 b의 합
	 */
	public abstract int plus(int a, int b); // 더하기

	
	/**
	 * @param a
	 * @param b
	 * @return a와 b의 차
	 */
	int minus(int a, int b); // 빼기

	
	/**
	 * @param a
	 * @param b
	 * @return a와 b의 곱
	 */
	int multiple(int a, int b); // 곱하기
	
	
	/** 두 정수를 나눈 몫 반환
	 * @param a
	 * @param b
	 * @return a와 b의 나눈 몫
	 */
	int divide(int a, int b); // 몫

	/** 두 정수를 나눈 몫 반환
	 * @param a
	 * @param b
	 * @return a와 b의 나눈 몫
	 */
	double divide2(int a, int b); // 소수점까지 반환
	
	
	/** 원의 넓이 반환
	 * @param r
	 * @return 원의 넓이
	 */
	double areaOfCircle(double r); // 원의 넓이
	
	/** a의 x 거듭 제곱 (a^x)
	 * @param a
	 * @param x
	 * @return (a^x)
	 */
	int square(int a, int x);
	

}
