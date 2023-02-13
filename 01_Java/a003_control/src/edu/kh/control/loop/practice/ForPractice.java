package edu.kh.control.loop.practice;

import java.util.Scanner;

// 실습문제용 클래스
public class ForPractice {
	private static final char[] i = null;



	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		for(int i=1; i<=input; i++) {
			if(i<0) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}else {
				System.out.printf("%d ",i);
			}
			
		}
	}
	
	

	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		for(int i=input; i>=1; i--) {
			if(i<0) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
			}else {
				System.out.printf("%d ",i);
			}
			
		}
	}
	
	

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=input; i++) {
			if (i==input) {
				sum += i;
				System.out.print(" + ");
				System.out.print(i);
				System.out.print(" = " + sum);
			}else if(i==1){
				System.out.print(1);
				sum += i;
			}else {
				System.out.print(" + ");
				System.out.print(i);
				sum += i;
			}
			
		}
		
	}
	
	

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		if (num1>num2) {
			for (int i = num2; i<=num1; i++) {
				if (num2 < 0 || num1 < 0) {
					System.out.println("1 이상의 숫자를 입력해주세요.");
				}else {
					System.out.print(i + " ");
				}
			}
		}else {
			for (int i = num1; i<=num2; i++) {
				if (num1 < 0 || num2 < 0) {
					System.out.println("1 이상의 숫자를 입력해주세요.");
				}else {
					System.out.print(i + " ");
				}
				
					
			}
			
		}
			
			
	}
		
	
	
	

	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		System.out.printf("===== %d단 =====\n",num);
		for (int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d\n",num,i,num*i);
		}
	}
	
	

	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		
		int num = sc.nextInt();
		if(num>9 || num<2) {
			System.out.println("2~9 사이 숫자만 입력해주세요.\n");
		}else {
			for(int j=num; j<=9; j++) {
				System.out.printf("===== %d단 =====\n",j);
				for (int i=1; i<=9; i++) {
					System.out.printf("%d * %d = %d\n",num,i,num*i);
				}
				System.out.println("");
			}
			
		}
		
		
		
	}
	
	

	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	

	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=input; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	

	public void practice9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1; i<=input; i++) {
			for (int k = input; i<=k; k--) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	

	public void practice10() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		int input2=(input-1);
		for(int i=input2; i>=1; i--) {
			for(int j=i; j>=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
				
				
	}	

	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1; i<=input; i++) {
			for (int k = input-1; i<=k; k--) {
				System.out.print(" ");
			}
			int num = input-1;
			for(int j=1; j<(i*2); j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
			
}
	
	

	public void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		for(int i=1; i<=input; i++) {
			for(int j=1; j<=input; j++) {
				if (i==1) {
					System.out.print("*");
				}else if (i==input) {
					System.out.print("*");
				}else {
					if(j==1) {
					System.out.print("*");
					}else if(j==input) {
					System.out.print("*");
					}else {
					System.out.print(" ");
					}
							
				}
					
			}
			System.out.println("");
				
		}
			
			
			
}
	
	
	

	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int count = 0;
		for (int i=1; i<=input; i++) {
			if (i%2==0 || i%3==0) {
				if (i%2==0 && i%3==0) {
					count +=1;
					System.out.print(i);
					System.out.print(" ");
				}else {
					System.out.print(i);
					System.out.print(" ");
				}	
			}else {
				
			}
		}
		System.out.println("");
		System.out.print("count : " + count);
	}
	
	

}
