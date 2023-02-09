package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num<0) {
			System.out.println("양수만 입력해주세요.");
		}else if (num>0 && num % 2==0) {
			System.out.println("짝수입니다.");
		}else {
		    System.out.println("홀수입니다.");
		}		
		
		
		
		
		
	}

	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		int sum = kor + math + eng;
		Double avg = (double)sum / 3;
				
		if ((kor<40 || math<40 || eng<40) || avg<60 ) {
			System.out.print("불합격입니다.");
		}else {
			System.out.printf("국어 : %d",kor);
			System.out.println("");
			System.out.printf("수학 : %d",math);
			System.out.println("");
			System.out.printf("영어 : %d",eng);
			System.out.println("");
			System.out.printf("합계 : %d",sum);
			System.out.println("");
			System.out.printf("평균 : %.1f",avg);
			System.out.println("");
			System.out.print("축하합니다, 합격입니다!");
		}
		
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int input = sc.nextInt();
		
		switch(input) {
		case 1 :  case 3 :  case 5 :  case 7 :   case 8 :  case 10 :  case 12 : System.out.printf("%d월은 31일까지 있습니다.",input); break;
		case 4 :  case 6 :  case 9 :  case 11 : System.out.printf("%d월은 31일까지 있습니다.",input); break;
		case 2 : System.out.printf("%d월은 28일까지 있습니다.", input); break;
		default : System.out.printf("%d월은 잘못 입력된 달입니다.", input); break;
		}
		
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("키(m)를 입력해 주세요 : ");
		Double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		Double kg = sc.nextDouble();
		Double bmi = kg/(height*height);
		System.out.println("Bmi 지수 : " + bmi);
		if (bmi >= 30) {
			System.out.print("고도 비만");
		}else if (bmi >= 25) {
			System.out.print("비만");
		}else if (bmi >= 23) {
			System.out.print("과체중");
		}else if (bmi >= 18.5) {
			System.out.print("정상체중");
		}else {
			System.out.print("저체중");
		}
		
	}
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();
		Double midj = (mid * 0.2);
		System.out.print("기말 고사 점수 : ");
		int last = sc.nextInt();
		Double lastj = (last * 0.3);
		System.out.print("과제 점수 : ");
		int home = sc.nextInt();
		Double homej = (home * 0.3);
		System.out.print("출석 횟수 : ");
		int atten = sc.nextInt();
		Double attenj = (atten * 0.2);
		Double sum = midj + lastj + homej + atten;
		System.out.println("================= 결과 =================");
		if (atten < 15) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", atten);
		}else if(sum < 70) {
			System.out.printf("중간 고사 점수(20) : %.1f",midj);
			System.out.println("");
			System.out.printf("기말 고사 점수(30) : %.1f",lastj);
			System.out.println("");
			System.out.printf("과제 점수     (30) : %.1f",homej);
			System.out.println("");
			System.out.printf("출석 점수     (20) : %.1f",(double)atten);
			System.out.println("");
			System.out.printf("총점 : %.1f",sum);
			System.out.println("");
			System.out.print("Fail [점수 미달]");
		}else {
			System.out.printf("중간 고사 점수(20) : %.1f",midj);
			System.out.println("");
			System.out.printf("기말 고사 점수(30) : %.1f",lastj);
			System.out.println("");
			System.out.printf("과제 점수     (30) : %.1f",homej);
			System.out.println("");
			System.out.printf("출석 점수     (20) : %.1f",(double)atten);
			System.out.println("");
			System.out.printf("총점 : %.1f",sum);
			System.out.println("");
			System.out.print("PASS");
		}
		
		
		
	}

		
}
