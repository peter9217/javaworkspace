package edu.kh.operator.practice;
import java.util.Scanner;
public class OperatorPractice4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력해주세요 ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력해주세요 ");
		int egl = sc.nextInt();
		System.out.print("수학 점수를 입력해주세요 ");
		int math = sc.nextInt();
		float result = (float)kor + egl + math;
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + egl);
		System.out.println("수학 : " + math);
		
		System.out.printf("합계 : %.1f", result);
		System.out.println("");
	    float fresult = result / 3;
		System.out.printf("평균 : %.1f", fresult);
		System.out.println("");
		String ccc = kor < 40 || egl < 40 || math < 40 ? "불합격" : fresult >= 60 ? "합격" : "불합격";
		System.out.println(ccc); 
				

	}

}
