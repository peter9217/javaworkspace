package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if(i==0 || i%2==0) {
				sum+=(i+1);
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
		
		
	}
	
	public void practice2() {
		int[] arr = new int[9];
		int sum = 0;
		for(int i=(arr.length-1); i>-1; i--) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if(i%2!=0) {
				sum+=(i+1);
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
		
		
		
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		for(int i=0; i<input; i++) {
			arr[i] = (i+1);
			System.out.print(arr[i] + " ");
		}
		
		
	}

	public void practice4() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		System.out.print("검색할 값 : ");
		int num = sc.nextInt();
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			if (arr[i] == num) {
				flag = true;
				System.out.printf("인덱스 : %d", i);
				break;
			}
		}
		if (flag == false) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		char[] cha = new char[input.length()];
		System.out.print("문자 : ");
		int how = 0;
		char index = (char)sc.next().charAt(0);
		String whe = "";
		for(int i=0; i<input.length(); i++ ) {
			cha[i] = input.charAt(i);
			if(cha[i]==index) {
				whe += i+" " ;
				how++;
			}
			
		}
		System.out.printf("%s에 %s가 존재하는 위치(인덱스) : %s\n",input, index, whe);
		System.out.printf("%s 개수 : %d", index, how);
		
	}
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int[] arr = new int[input];
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ",i);
			int num = sc.nextInt();
			arr[i] = num;
			
		}
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d ",arr[i]);
			sum += arr[i];
		}
		System.out.println();
		System.out.printf("총 합 : %d",sum);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String pNo = sc.next();
		char[] cha = new char[pNo.length()];
		for (int i = 0; i<pNo.length(); i++) {
			if(i>7) {
				cha[i] = '*';				
			}else {
				cha[i] = pNo.charAt(i);
			}
			
		}
		System.out.print(cha);
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int tar = 0;
		String arr = "";
		while(num<3 || num%2==0) {
			System.out.println("다시 입력하세요");
			System.out.print("정수 : ");
			num = sc.nextInt();
		}
		for (int i=1; i<=num; i++)
			
			if (i<=(num+1)/2) {
				tar += 1;
				arr += tar+", ";
			}else if(i<num){
				tar -= 1;
				arr += tar+", ";
			}else {
				arr += 1;
			}
		System.out.println(arr);
	}
	
	public void practice9() {
		int[] arr = new int[10];
		int ran = 0;
		for(int i=0; i<10; i++) {
			ran = (int)((Math.random())*11);
			arr[i] = ran;
		}
		System.out.print("발생한 난수 : ");
		for(int i=0; i<10; i++) {
			 System.out.print(arr[i] + " "); 
		}
		
			
		
	}
	
	public void practice10() {
		int[] arr = new int[10];
		int ran = 0;
		
		for(int i=0; i<10; i++) {
			ran = (int)((Math.random())*10+1);
			arr[i] = ran;
		}
		int min = arr[0];
		int max = arr[0]; 
		System.out.print("발생한 난수 : ");
		for(int i=0; i<10; i++) {
			 System.out.print(arr[i] + " "); 
		}
		
		for(int j=0; j<10; j++) {
			if(max<arr[(j)]) {
				min = arr[(j)];
			}
		}
		System.out.println();
		System.out.println("최대값 : " + max);

		
		for(int k=0; k<10; k++) {
			if(min>arr[(k)]) {
				min = arr[(k)];
			}
		}
		System.out.println("최소값 : " + min);

	}
	
	public void practice11() {
		int[] arr = new int[10];
		int ran = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)((Math.random())*10+1);
			for(int j=0; j<i; j++) {
				if(arr[j]==arr[i]) {
					i--;
					
				}
				
			}
				
		}
		for(int k=0; k<arr.length; k++) {
			System.out.print(arr[k] + " ");
		
	}
		
		
			
	}
}