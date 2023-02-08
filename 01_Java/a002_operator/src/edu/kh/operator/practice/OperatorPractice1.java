package edu.kh.operator.practice;
import java.util.Scanner;
public class OperatorPractice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("인원을 입력해주세요 ");
		int manInput = sc.nextInt();
		System.out.print("사탕 개수를 입력해주세요 ");
		int canInput = sc.nextInt();
		
		System.out.println("사탕을 나눠주고 남은 사탕의 개수는 " + manInput%canInput + "개 입니다.");

	}

}
