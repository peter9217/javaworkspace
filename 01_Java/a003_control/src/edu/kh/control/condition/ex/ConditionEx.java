package edu.kh.control.condition.ex;

import java.util.Scanner;
public class ConditionEx {

	public void test1() {
		System.out.println("test1() 수행");
	}
	
	public void test2() {
		System.out.println("test2() 수행");
	}
	
	public void test3() {
		System.out.println("test3() 수행");
	}
	
	//if 예시 1번
	public void ex1() {
		Scanner sc = new Scanner(System.in);
		// 
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		/*if(input > 0) {
			System.out.println("양수 입니다.");
			System.out.println("ex1() 종료");
		}else if(input==0) {
			System.out.println("0 입니다");
		}else{
			System.out.println("음수 입니다.");
			
		}
		
		if( input < 0 ) {
			System.out.println("음수 입니다.");
		}*/
		/*if( input % 2 == 0) {
			if(input == 2) {
				System.out.println("input은 2입니다.");
			}
			System.out.println("input은 2의 배수입니다.");
		
		}else {
			System.out.println("input은 2의 배수가 아닙니다.");
		}*/
		
		
	}
	
	
	// if 예시 2번 (if - else
	public void ex2() {
		// 조건식이 true이면 if문 수행
		// false이면 else문 수행
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해 주세요 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수 입니다.");
		}else{
			//System.out.println("음수 입니다.");
			//[중첩 if문]
			if(input == 0) {
				System.out.println("0 입니다.");
			}else {
				System.out.println("음수 입니다.");
			}
		}
	}
	
	
	
	// if 예시 3번 : if - else if - else
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[홀짝 판별기]");
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		// 홀수, 짝수, 0
		if(input == 0) {
			System.out.println("0은 홀/짝을 구분할 수 없습니다.");
		}else if( Math.abs(input) % 2 == 1){
			//절대값
			System.out.println("홀수 입니다.");
		}else {
			System.out.println("짝수 입니다.");
		}
		
		
		
	}
	
	//if 예시 4번 
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("계절을 알고 싶은 달(월)을 입력해주세요 : ");
		int input = sc.nextInt();
		
		// 조건문 결과를 저장할 문자열 변수 선언
		String result;
		
		if(input >= 3 && input <= 5) {
			result = "봄";
		}else if(input >= 6 && input <= 8 ) { //6,7,8
			result = "여름";
			
		}else if(input>=9 && input <=11) { // 9,10,11
			result = "가을";
		}else if(input==12 || input==1 || input==2){
			result = "겨울";
			
		}else {
			result = "해당하는 계절이 없습니다.";
		}
		
		//if - else if - else를 거치게 되면
		//무조건 result에 값이 하나 저장되어 있다.
		System.out.println(result);
		
	}
	
	//if 예시 5번
	public void ex5() {
		//나이를 입력 받아 13세 이하면 "어린이" 13세 초과 19세 이하면 "청소년" 19세 초과 "성인" 출력
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		String result;
		
		if (input <= 13) {
			result = "어린이";
		}else if(input >= 14 && input <= 19) {
			result = "청소년";
		}else if(input >= 20) {
			result = "성인";
		}else {
			result = "잘못 입력하셨습니다";
		}
		
		System.out.println(result);
	}
	
	
	// if 예시 6번
	public void ex6() {
		//놀이기구 탑승 제한 검사
		// 나이가 12세 이상, 키 140.0cm 이상일 경우에만 탑승 가능
		// 나이가 12세 미만 : " 적정 연령이 아닙니다."
		// 키 140.0cm 미만 : " 적정 키가 아닙니다."
		// 나이를 0세 미만 또는 100세 초과 입력 시 : " 잘못 입력하셨습니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		Double height = sc.nextDouble();
		String result;
		if (age<12 && age>=0) {
			result = "적정 연령이 아닙니다.";
			
		}else if(height<140) {
			result = "적정 키가 아닙니다.";
		}else if(age < 0 || age > 100) {
			if(age > 100) {
				result = "100 초과 숫자를 입력하셨습니다.";
			}else {
				result = "0 미만 숫자를 입력하셨습니다.";
			}			
		}else {
			result = "탑승가능";
		}
		
		
		System.out.println(result);
				
	}
	
	
	// 예제 6번 업그레이드
	public void ex7() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		//나이를 입력 받자마자 검사
		if(age < 0 || age > 100) {
			result = "잘못 입력하셨습니다.";
		}else if(age < 12) {
			result = "적정 연령이 아닙니다.";
		}else {
			// else 내부에서는 age가 정상 입력으로 판단됨
			
			System.out.print("키 입력 : " );
			Double height = sc.nextDouble();
			
		
		}
	}
	
	
	

}



