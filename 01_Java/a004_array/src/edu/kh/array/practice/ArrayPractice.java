package edu.kh.array.practice;

import java.util.Arrays;
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
			ran = (int)((Math.random())*10+1);
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
				max = arr[(j)];
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
	
	public void practice12() {
		int[] arr = new int[6];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)((Math.random())*46+1);
			for(int j=0; j<i; j++) {
				if(arr[j]==arr[i]) {
					i--;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i+1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {
					int num = arr[i];
					arr[i] = arr[j];
					arr[j] = num;
				}
			}			
		}
		
		
	for(int k=0; k<arr.length; k++) {
		System.out.print(arr[k] + " ");
		}
	}
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		String[] arr = new String[str.length()];
		char[] chr = new char[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			chr[i]=str.charAt(i);
		}
		int tar = 0;
		System.out.print("문자열에 있는 문자 : ");
		for(int k=0; k<arr.length; k++) {
			if (k!=arr.length-1) {
				System.out.print(chr[k] + ", ");
				tar++;
			}else {
				System.out.print(chr[k] + " ");
				tar++;
			}
			
		}
		System.out.println();
		System.out.print("문자 개수 : ");
		System.out.print(tar);
		
	}
	
	public void practice14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		int size1 = size;
		String[] arr1 = new String[size];
		String[] arr2 = new String[size];
		for (int i = 0; i < size; i++) {
			System.out.printf("%d번째 문자열 : ", (i + 1));
			arr1[i] = sc.next();

		}
		int num = 0;
		System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
		String flag = sc.next();

		while (flag.equals("y") || flag.equals("Y")) {

			System.out.print("더 입력하고 싶은 개수 : ");
			int num1 = sc.nextInt();
			size += num1;
			arr2 = new String[size];
			for (int i = size1; i < size; i++) {
				System.out.printf("%d번째 문자열  : ", i + 1);
				String tar = sc.next();

				System.arraycopy(arr1, 0, arr2, 0, arr1.length);
				arr2[i] = tar;

				size1 = size;

			}
			arr1 = arr2.clone();

			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			flag = sc.next();

		}
		System.out.print("[");
		for (int k = 0; k < arr1.length; k++) {
			if (k==(arr2.length-1)) {
				System.out.print(arr1[k] + "]");
				break;
			}
			System.out.print(arr1[k] + ", ");
		}

	}

	public void practice15() {
		String[][] arr = new String[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[j][i] = String.format("(%d, %d)", j,i);
				
			}
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(arr[i][j]);
				
			}
			System.out.println();
		}
	}
	
	public void practice16() {
		int[][] arr = new int[4][4];
		int n = 1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				
				arr[i][j] = n;
				n++;
				
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.printf("%3d",arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
	
	public void practice17() {
		int[][] arr = new int[4][4];
		int n = 16;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				
				arr[i][j] = n;
				n--;
				
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.printf("%3d",arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
	
	public void practice18() {
		int[][] arr = new int[4][4];
		
				
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				int n = (int)(Math.random()*10 +1);
				if(i==3) {
					arr[i][j] = arr[0][j]+arr[1][j]+arr[2][j];
				}else if(j==3) {
					arr[i][j] = arr[i][0]+arr[i][1]+arr[i][2];
				}else{
					arr[i][j] = n;
				
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.printf("%3d",arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
	public void practice19() {
		Scanner sc = new Scanner(System.in);
		int row = 0;
		int col = 0;
		
		
		do {
			System.out.print("행 크기 : ");
			row = sc.nextInt();
			System.out.print("열 크기 : ");
			col = sc.nextInt();
			
			if (row<0||row>10||col<0||col>10) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			}
			System.out.println("--------------------");
		}while(!(row>0&&row<11)||!(col>0&&col<11));
		char[][] arr = new char[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				int cha = (int)(Math.random()*(65+(row*col)));
				
				if(cha<65||cha>(90)) {
					j--;
				
				}else {
					arr[i][j] = (char)cha;
				}
			
				
			}
		}			
		System.out.println("--------------------");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}System.out.println("");
		}
		
	}
	
	
	public void practice20() {
		Scanner sc = new Scanner(System.in);
		int row = 0;
		int man = 0; 
		System.out.print("행 크기 : ");
		row = sc.nextInt();
		int[][] col = new int[row][0];
		int colarr = 0;
		char[][] arr = new char[row][0];
		for (int i = 0; i < row; i++) {
			System.out.printf("%d열 크기 : ",i);
			colarr = sc.nextInt();
			man += colarr*row;
			arr[i] = new char[colarr];
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < (arr[i].length); j++) {
				int cha = (int)(Math.random()*(97+man));
				
				
				if(cha<97||cha>(122)) {
					j--;
				
				}else {
					arr[i][j] = (char)cha;
				}
				
				
			}
		}			
		System.out.println("--------------------");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println("");
		}
		
	}
	
		

	
}