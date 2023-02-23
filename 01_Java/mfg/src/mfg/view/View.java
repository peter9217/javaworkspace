package mfg.view;

import mfg.dto.Citi;
import mfg.service.*;
import java.util.Scanner;


public class View {
	private Scanner sc = new Scanner(System.in);
	
	public MfService service = new MfService();
	
	public void displayMenu() {
		int input = 0;
		
		do {
			System.out.println("----- [게임] -----");
			System.out.println("1. 멤버 추가");
			System.out.println("2. 공격");
			System.out.println("0. 종료");
			System.out.println("-------------------------------");
			
			System.out.print("메뉴 선택 : ");
			input = sc.nextInt();
			System.out.println();
			
			switch(input) {
			case 1 : addMem(); break;
			case 2 : shot(); break;
//			case 3 : selectIndex(); break;
//			case 4 : selectName(); break;
//			case 5 : updateStudent(); break;
//			case 6 : sumAvgMaxMin(); break;
			
			case 0 : System.out.println("[프로그램이 종료됩니다.]"); break;
			default : System.out.println("[잘못 입력 하셨습니다.");
			}
			
			
			
			System.out.println();
			
		}while(input !=0);
	}
	public void addMem() {
		System.out.println("[멤버 추가]");
		System.out.print("이름 : ");
		String name = sc.next();
	
	
		//멤버 추가 서비스 호출
		boolean result = service.addMem(name);
		
		if(result) { // true인 경우 == 멤버 추가 성공
			System.out.println(name + " 멤버이 추가되었습니다!");
			
		} else { //false인 경우 == 멤버 추가 실패
			System.out.println("더 이상 멤버을 추가할 수 없습니다.");
		}
	}
	
	public void shot() {
		System.out.println("수행자 : ");
		String name = sc.next();
		System.out.println("샷 타겟 : ");
		String target = sc.next();
		boolean result = service.Shot(name, target);

		if (result) { // true인 경우 == 학생 추가 성공
			System.out.println(name + "이 " + target + "을 공격했습니다.");
			
			

		} else { // false인 경우 == 실패
			System.out.println("");
		}
	}

}
