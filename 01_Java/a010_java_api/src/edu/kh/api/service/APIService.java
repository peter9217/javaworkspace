package edu.kh.api.service;

import edu.kh.api.dto.Student;

public class APIService {
	
	// API(Application Programming Interface)
	// 		  응용		프로그래밍	 접점
	// -> 프로그래밍 언어가 이미 가지고 있는 클래스/기능/기술을
	//	사용자가 쉽게 사용할 수 있도록 제공하는 것
	
	private Student[] studentList = new Student[10];
	
	public APIService() {
		studentList[0] = new Student(1, 1, 1, "김영희");
		studentList[1] = new Student(1, 2, 3, "홍길동");
		studentList[2] = new Student(4, 5, 12, "박민지");
		
	}
	
	
	public boolean addStudent(int grade, int classRoom, int number, String name) {
		int index = 0;
		for(Student s : studentList) {
			if(s == null)break;
			boolean check1 = s.getGrade() == grade;
			boolean check2 = s.getClassRoom() == classRoom;
			boolean check3 = s.getNumber() == number;
			boolean check4 = s.getName().equals(name);
			
			// 학생 배열에 입력 받은 학생이 존재한다면
			if(check1 && check2 && check3 && check4) 
				return false;
			index++;
		}
		
		// 학생 배열에 학생이 가득 찬 경우
		if(index == studentList.length) return false;
		
		// 지정된 index
		studentList[index] = new Student(grade, classRoom, number, name);
		return true;
	}
	
	
	
	public boolean addStudent2 (int grade, int classRoom, int number, String name) {
		// 1. equals() 를 이용한 비교
		//	1) 전달 받은 값을 임시 학생 객체 생성
		Student temp = new Student(grade, classRoom, number, name);
		
		// 2) 학생 배열을 순차 접근하면서 동등한 학생이 있는지 검사
		int index = 0;
		for(Student s : studentList) {
			if(s == null) break;
			if(s.equals(temp)) { //s가 참조하는 학생과 temp가 참조하는 학생의 필드값이 같을 경우 (동등한 경우)
				return false;
			}
			index++;
			
		}
		// 3) 학생 배열에 학생이 가득 찬 경우
		if(index == studentList.length) return false;
		// 4) 임시 학생 객체를 학생 배열에 추가
		studentList[index] = temp;
		
		return true;
	}
	
	
	
	
	
	

}
