package edu.kh.operator.practice;
import java.util.Scanner;
public class OperatorPractice3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		System.out.println("정수 입력 :" + num);
		System.out.println(num == 0 ? "0 입니다." : num > 0 ? "양수 입니다." : "음수 입니다.");
		

	}

}
