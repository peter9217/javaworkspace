package edu.kh.api.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.api.service.APIService;

public class APIView {
	
	private Scanner sc = new Scanner(System.in);
	private APIService service = new APIService();

	public void displayMenu() {
		int input = 0;

		do {
			System.out.println("--- API 테스트 프로그램 ---");
			System.out.println("1. equals() + hashCode()");
			System.out.println("2. String 클래스");

			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴 선택 : ");

			try {
				input = sc.nextInt();
				sc.nextLine(); // 버퍼에 남은 개행문자 제거

				switch (input) {
				case 1:
					ex1();
					break;
				case 2:
					break;
				case 0:
					break;
				default:
					System.out.println("메뉴에 존재하는 번호만 입력 해주세요");
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못 입력함. 다시 입력 ㄱ");
				String i = sc.nextLine();
				System.out.println("잘못 입력한 문자 = " + i);
				input = -1;
			}

		} while (input != 0);
		

	}
	private void ex1() {
		
		// 한 학생의 정보를 입력받아 Service의 학생 배열에 추가 닽, 중복된 학생은 제외
		System.out.println("\n--- 학생 정보 입력 ---\n");
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classRoom = sc.nextInt();
		System.out.println("번호 : ");
		int number = sc.nextInt();
		sc.nextLine(); // 입력된 버퍼에 남아 있는 개행문자 제거
		System.out.println("이름 : ");
		String name = sc.next();
		
		if(service.addStudent(grade, classRoom, number, name)) {
			System.out.println("[추가되었습니다]");
		}else {
			System.out.println("중복되는 학생이 존재하거나 배열이 가득 찼습니다.");
		}

	}

	

}
