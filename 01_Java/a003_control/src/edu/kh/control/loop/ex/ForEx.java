package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {
	/* for문
	 * - 끝이 정해져 있는 경우에 사용하는 반복문
	 *  (== 반복 횟수가 지정되어 있는 경우 사용)
	 * 
	 * - 작성법
	 * 
	 *  for(초기식[1] ; 조건식[2][5][8] ; 증감식[4][7]){
	 *      [3][6]조건식이 true일 때 반복 수행할 코드
	 *  }
	 *  
	 *  // 1~4 수행 후 조건식이 false가 나올 때 까지 5~7 반복 
	 * 
	 *  - 초기식 :  for문을 제어하는 용도의 변수 선언 및 초기화
	 *  
	 *  - 조건식 : for문의 반복 여부를 지정하는 식
	 *             조건식이 true인 경우에만 반복 수행을 함.
	 *             보통 초기식에 사용된 변수를 이용해서 
	 *             조건식을 작성함. 
	 *           
	 *  - 증감식 : for문이 한 번 반복을 수행할 때 마다
	 *             마지막에 특정 값을 증가 또는 감소 시키는 식
	 *             
	 *             보통 초기식에 사용된 변수를 증가/감소 시켜
	 *             조건식의 결과를 변화하게 만드는 용도
	 */
	
	// for문 기초 사용법 1
	public void ex1() {
		// 1~10까지 반복 출력
		// 1,2,3,4,5,6,7,8,9,10
		for( int a = 1; a<11; a++ ) {
			System.out.print(a);
			if (a<10) { 
				System.out.print(",");
			}else {
				
			}
		}
		
	}
	
	// for문 기초 사용법 2
	public void ex2( ) {
		
		// 5부터 12까지 1씩 증가하며 출력
		for(int num = 5; num < 13; num++) {
			System.out.print(num + " ");
		}
	}
	
	// for문 기초 사용법 2
	public void ex3() {
		// 3 부터 20 까지 2씩 증가하며 출력 
		for(int i = 3; i<21; i += 2) {
			System.out.print(i + " ");
			
		}
	}
	
	//for문 기초 사용법 4
	public void ex4() {
		// 1부터 100까지의 모든 정수의 합 == 5050
		int sum = 0; // i가 증가하면서 변한 값들을 누적할 변수 선언
		             // 0으로 초기화 하는 이유 : 어떤 값을 더하든 영향이 없어서
		for(int i = 1; i<101; i++) {
			
			sum += i;
			
		}System.out.print("합계 : " + sum);
	}
	
	
	//for문 기초 사용법 5
	public void ex5() {
		// 두 정수를 입력 받아
		// 두 정수 사이의 모든 정수의 합 출력하기
		// (단, 첫 번째 입력 받는 정수가 무조건 작다고 가정)
		
		// 정수 1 입력 : 2
		// 정수 2 입력 : 5
		// 2부터 5까지 모든 정수의 합 : 14
		//
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 입력 : ");
		int num = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int num2 = sc.nextInt();
		int sum = 0;		
		for (int i = num; i <= num2; i++ ) { //조건식은  == 는 true가 아니므로 유의!!
			sum += i;			
		}
		System.out.printf("%d부터 %d까지 모든 정수의 합 : %d", num, num2, sum);
	}
	
	// for문 기초 사용법 6
	public void ex6() {
		
		// 다른 자료형으로 for문 사용하기 
		// 10부터 20까지 0.5씩 증가하며 출력
		for(Double a = 10.0; a <= 20; a+=0.5) { //int로 시작시 0.5+ 된다고 해도 정수는 변하지 않음(소수점 계산 시 주의)
			System.out.println(a);
		}
		System.out.println("---------------------------");
		
		// A-Z까지 모든 알파벳 출력하기
		// 1) A, Z의 유니코드 번호를 이용하기
		for (int i = 65; i<=90; i++) {
			System.out.print((char)i); 
		}
		
		// 2) 유니코드 번호를 모를 때
		System.out.println();
		for(int i='A'; i<='Z'; i++) {
			System.out.print((char)i);
		}
		
		// 3) char 자료형은 문자형이지만 실제로는 정수를 저장한다!
		System.out.println();
	    for( char i = 'A'; i<='Z'; i++) {
	    	System.out.print(i);
	    }
		
	}
	
	
	// for문 응용 사용법 1
	public void ex7() {
		// 감소하기 
		
		//10부터 1까지 1씩 감소하며 출력
		for (int i = 10; i>0; i-- ) {
			System.out.println(i);
		}
	}
	
	//for문 응용 사용법 2
	public void ex8() {
		// 입력, 합계(sum), for
		// 정수 5개를 입력 받아 합계 출력하기
		Scanner sc = new Scanner(System.in);
		int sum = 0; //합계를 저장할 변수 선언 및 0으로 초기화
		for (int i=1; i<=5; i++) {
			System.out.printf("정수 입력 %d : ",i);
			sum += sc.nextInt();
			
				
		}
		System.out.print(sum);
	}
	
	//for문 응용 사용법 3
	public void ex9() {
		// ex8번 응용
		//정수를 몇 번 입력 받을지 먼저 입력하고 입력된 정수의 합계를 출력
		
		// 입력 받을 정수의 개수 : 2
		// 입력 1 : 3
		// 입력 2 : 5
		// 합계 : 8
		
		// 입력 받을 정수의 개수 : 4
		// 입력 1 : 3
		// 입력 2 : 5
		// 입력 3 : 4
		// 입력 2
		// 합계 : 8
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 정수의 개수 : ");
		int h = sc.nextInt();
		int sum = 0;
		for (int i = 1; i<=h; i++) {
			System.out.printf("입력 %d : ",i);
			sum += sc.nextInt();
		
		}
		System.out.printf("합계 : %d", sum);
	}
	
	// for문 응용 사용법 4
	public void ex10() {
		//for + if 동시 사용
		// 1부터 10까지 반복하며 출력
		// 단, 짝수일 경우 ()로 숫자를 감싸서 출력
		// 1 (2) 3 (4) 5 (6) 7 (8) 9
		for (int i=1; i<=10; i++) {
			if (i%2==0) {
				System.out.printf("(%d) ",i);
			}else {
				System.out.printf("%d ",i);
			}
						
		}
		
	}
	
	// for문 응용 사용법 5
	public void ex11() {
		// 1부터 10까지 1씩 증가하며 출력
		// 단, 3의 배수의 경우 숫자를 []감싸서 출력
		// 단, 5의 배수인 경우 숫자 대신 @ 출력
		//1 2 [3] 4 @ [6] 7 8 [9] @
		
		for (int i=1; i<=10; i++) {
			if (i%5==0) {
				System.out.print("@ ");
			}else if(i%3==0){
				System.out.printf("[%d] ", i);
			}else {
				System.out.printf("%d ", i);
			}
		}
		System.out.println();
	}
	// for문 응용 사용법 6
	public void ex12() {
		// for, if, printf
		
		//구구단 2단 출력하기
		// 2 x 1 = 2
		// 2 x 2 = 4
		// 2 x 3 = 6
		// 2 x 4 = 8
		// 2 x 5 = 10
		// 2 x 6 = 12
		// 2 x 7 = 14
		// 2 x 8 = 16
		// 2 x 9 = 18
		
		for (int i=1; i<=9; i++ ) {
			int dd = 0;
			System.out.printf("2 X %d = %2d \n", i, i*2);
		}
		
		
	}
	
	//for문 응용 사용법 7
	public void ex13() {
		//원하는 단을 입력 받아서 역순으로 출력
		// 단 입력 : 3
		// 3 X 9 = 29
		// 3 X 8 = 
		// 3 X 7 = 
		// 3 X 6 = 
		// 3 X 5 = 
		// 3 X 4 = 
		// 3 X 3 = 
		// 3 X 2 = 
		// 3 X 1 =
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int input = sc.nextInt();
		for (int i=9; i>=1; i--) {
			System.out.printf("%d X %d = %2d \n",input, i, input*i);
			
			
		}
	}
	
	// for문 응용 사용법 8
	public void ex14() {
		// 입력 받은 단의 구구단 출력하기
		// 단, 입력 받은 단이 2~9 사이가 아니라면 
		// "잘못 입력 하셨습니다." 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int input = sc.nextInt();
		
		if (input < 2 || input > 9) {
			System.out.print("잘못 입력 하셨습니다.");
		}else {
			for (int i=1; i<=9; i++) {
				System.out.printf("%d X %d = %2d \n",input, i, input*i);
			}
		
		}
	}
	
	// 중첩 반복문 기본 사용법 1
	public void ex15() {
		//12345
		for (int k=1; k<=5; k++) {
			
			for (int i=1; i<=5; i++) { //12345 출력
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		
	}
	
	// 중첩 반복문 기본 사용법 2
	public void ex16() {
		// 1  2  3  4  5
		// 2  4  6  8 10
		// 3  6  9 12 15
		// 4  8 12 16 20
		// 5 10 15 20 25
		for(int j=1; j<=5; j++) {
			for(int i=1; i<=5; i++) {
				System.out.printf("%3d", i*j);
			}
			System.out.println();
		}
		
	} 
	
	// 중첩 반복문 응용 사용법1
	
	public void ex17() {
		// 구구단을 2단 부터 9단까지 모두 출력하기
		// 2x1=2 2x2=4 2x3=6 ...
		// 3x1=3 3x2=6 3x3=9 ...
		// ...
		// 9x1=9 ... 9x9=81 ...
	
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%dX%d=%2d  ", i, j, i*j);
			}
			System.out.println(); //개행
		}
	}
	public void ex18() {
		// 2중 for문을 이용하여 다음 모양을 출력하세요.
		// 1
		// 12
		// 123
		// 1234
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			System.out.println();
			
		}
	}
	
	// 중첩 반복문 응용 사용법3
	public void ex19() {
		// 2중 for문을 이용하여 다음 모양을 출력하세요.
		
		// 4
		// 43
		// 432
		// 4321
		for(int i=4; i>=1; i--) {
			for(int j=4; j>=i; j--) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public void ex20() {
		// 입력된 정수 : 3
		// 321
		// 21
		// 1
		
		// 입력된 정수 : 4
		// 4321
		// 321
		// 21
		// 1
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력된 정수 : ");
		int input = sc.nextInt();
		for(int i=input; i>=1; i-- ) {
		for(int j=i; j>=1; j--) {
			System.out.print(j);
		}
		System.out.println();
		}
	}
	
	public void ex21() {
		// 1부터 20 사이의 3의 배수의 합과 개수를 출력
		int sum = 0;
		int cou = 0;
		for(int i=1; i<=20; i++) {
			if(i%3==0) { //3의 배수인 경우
				sum += i;
				cou += 1;
			}
		}
		System.out.println("sum : " + sum);
		System.out.println("count : " + cou);
		
		
	}
	
	//count를 이용한 2중 for문
	public void ex22() {
		//  1  2  3  4
		//  5  6  7  8
		//  9 10 11 12
		
		int count = 1;
		for(int row =1; row<=3; row++) { // 3행
			for(int col =1; col<=4; col++) { // 4열
				System.out.printf("%3d", count++); //출력 후 1 증가 (후위 연산)
			}
			System.out.println(); // 개행;
		}
	
	}
	
	
}


