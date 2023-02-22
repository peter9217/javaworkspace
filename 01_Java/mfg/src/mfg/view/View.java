package mfg.view;

import java.security.Provider.Service;
import java.util.Scanner;


public class View {
	private Scanner sc = new Scanner(System.in);
	
	public Service service = new Service();
	
	public void displayMenu() {
		int input = 0;
		
		do {
			System.out.println("----- [학생 관리 프로그램] -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 조회(인덱스)");
			System.out.println("4. 학생 정보 조회(이름)");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 점수 합계, 평균, 최고점, 최저점 조회");
			System.out.println("0. 종료");
			System.out.println("-------------------------------");
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			System.out.println();
			
			switch(input) {
			case 1 : addStudent(); break;
			case 2 : selectAll(); break;
			case 3 : selectIndex(); break;
			case 4 : selectName(); break;
			case 5 : updateStudent(); break;
			case 6 : sumAvgMaxMin(); break;
			
			case 0 : System.out.println("[프로그램이 종료됩니다.]"); break;
			default : System.out.println("[잘못 입력 하셨습니다.");
			}
			
			
			
			System.out.println();
			
		}while(input !=0);
	}

}
