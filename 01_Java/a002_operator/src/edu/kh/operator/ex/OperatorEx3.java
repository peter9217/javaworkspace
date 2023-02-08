package edu.kh.operator.ex;

public class OperatorEx3 {

	public static void main(String[] args) {
		
		//논리 연산자 : &&(AND), ||(OR)
		
		// &&(AND) 연산자 : 둘 다 true이면 true, 나머지 false
		

		// 정수가 100 이상이면서 짝수인가?
		int num1 = 102;
		boolean result1 = num1 >=100 && num1 % 2 == 0;
		System.out.println(num1 + "은 100 이상이면서 짝수? " + (num1 >= 100 && num1 % 2 == 0));
		// 정수가 50 이하이고 3의 배수인가?
		int num2 = 33;
		System.out.println(num2 + "는 50이하이고 3의 배수인가? " + (num2 <= 50 && num2 % 3 == 0));
		// 정수가 1부터 100 사이의 숫자인가?
		int num3 = 99;
		System.out.println(num3 + "는 1부터 100 사이의 숫자인가? " + (num3>=1 && num3<=100));
		
		
		
		
		// ||(OR) 연산자 : 둘 다 false이면 false, 나머진 true
		// 또는 , ~ 이거나(거나)
		
		// 정수가 10을 초과하거나 홀수인가?
		int num4 = 8;
		System.out.println(num4 + "는 정수가 10을 초과하거나 홀수인가? " + (num4>10 || num4%2==1));
		
		//정수는 0부터 50사이 숫자 또는 음수인가?
		// == 50 이하인가?
		int num5 = -120;
		System.out.println(num5 + "는 0부터 50사이 숫자 또는 음수인가? "+ ((num5 >= 0 && num5 <= 50) || num5<0));
		
		// 논리 부정 연산자 : ! (not)
		// - 논리 값을 반대로 바꾸는 연산자
		
		// 11은 짝수가 아니다.
		System.out.println("11은 짝수가 아니다 : " + !(11 % 2 ==0));
		
		System.out.println( true || false && !false );
		
		
			
		
		
	}

}
