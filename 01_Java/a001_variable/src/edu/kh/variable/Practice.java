package edu.kh.variable;

public class Practice {
	public static void main(String[] args) {
		
		
		/* 기본 자료형 8가지
		 * 
		 * 정수형
		 * byte (1)
		 * short (2)
		 * int (정수 기본형)(3)
		 * long (4, L)
		 * 
		 * 실수형
		 * float (4) (f)
		 * double (실수 기본형)(8)
		 * 
		 * 문자형
		 * char (2) (문자를 저장하는 것이 아닌 대응되는 숫자를 저장)
		 * 
		 * 논리형
		 * boolean (1, true/false)
		 * 
		 * [컴퓨터 값 처리 원칙]
		 * 같은 자료형끼리만 연산 가능, 결과도 같은 자료형
		 * 
		 * [자동 형변환]
		 * 값의 범위가 다른 자료형끼리의 연산 시
		 * 범위가 작은 자료형을 큰 자료형으로 변환
		 * (컴파일러가 자동으로 진행)
		 * 
		 * [강제 형변환]
		 * 특정한 자료형으로 강제 변환(바꾸고 싶은 자료형을 명시)
		 * 데이터 손실이 발생할 수 있다.
		 * 
		 * */
		
		int iNum1 = 10;
		int iNum2 = 4;
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		//println() 자동 완성 : "syso" -> ctrl + spacebar -> enter
		System.out.println( iNum1 / iNum2 ); // 2
		System.out.println( (int)dNum );
		System.out.println(iNum2 * dNum); 
		System.out.println( (double)iNum1 );
		System.out.println( (double)iNum1/iNum2);
		System.out.println((int)fNum); //3
		System.out.println( (int)(iNum1 / fNum));
		System.out.println(iNum1/fNum);
		System.out.println(iNum1/(double)fNum);
		System.out.println((int)ch);
		System.out.println(ch + iNum1);
		System.out.println((char)(ch + iNum1));
		
		//asdasdasd
		
		
		
		
		
		
	}

}
