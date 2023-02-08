package edu.kh.operator.practice;
import java.util.Scanner;
public class OperatorPractice2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해 주세요 ");
		String name = sc.next();
		
		System.out.print("학년을 입력해 주세요 ");
		int year = sc.nextInt();
		
		System.out.print("반을 입력해 주세요 ");
		int clas = sc.nextInt();
		
		System.out.print("번호를 입력해 주세요 ");
		int num = sc.nextInt();
		
		System.out.print("성별을 입력해 주세요 ");
		String gen = sc.next();
		
		System.out.print("점수를 입력해주세요 ");
		float gradu = sc.nextFloat();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.", year, clas, num, name, gen, gradu);
		

	}

}
