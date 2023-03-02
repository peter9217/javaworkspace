package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService {
	
	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentService() {
		studentList.add(new Student("홍길동", 3, 5, 17, "서울시 청계", 'M', 75));
		studentList.add(new Student("s길동", 1, 6, 18, "서울시 한강", 'F', 55));
		studentList.add(new Student("d길동", 2, 7, 19, "대전시", 'F', 65));
		studentList.add(new Student("a길동", 3, 8, 10, "대구시", 'M', 35));
		studentList.add(new Student("e길동", 4, 9, 20, "울산시", 'M', 75));
	}
	
	
	
	public boolean addStudent(Student std) {
		return studentList.add(std);
	}
	
	/** 학생 전체 조회 서비스
	 * @return studentList
	 */
	public List<Student> selectAll() {
		return studentList;
	}



	/** 학생 정보 수정 서비스
	 * @param index
	 * @param std
	 * @return s:Student(수정되기 전 학생 정보)
	 */
	public Student updateStudent(int index, Student std) {
		
		// e2 set(int index, E e) : 1) index에 위치하는 요소를 e로 변경
		//							2) 기존에 있던 요소 e2를 반환
		
		return studentList.set(index, std);
	}



	/** 학생 정보 제거 서비스
	 * @param index
	 * @return s: Student (제거된 학생 정보)
	 */
	public Student removeStudent(int index) {
		
		// E remove(int index) : index번째 요소를 List에서 제거하여 반환
		// boolean remove(E e) : List에서 E와 일치하는 요소를 찾아서 
		//						 있으면 제거하고 true 없으면 false
		
		return studentList.remove(index);
	}



	public String searchName(String name) {
		String st = new String();
		for(Student s:studentList) {
			if(s.getName().equals(name)) {
				st = s.toString();
			}
		}
		return st;
	}
	
	
	public List<Student> searchAddress(String address) {
		List st = new ArrayList(0);
		int num = 0;
		for(Student s:studentList) {
			if(s.getAddress().contains(address)) {
				st.add(s);
			}
		}
		return st;
	}



	public List<Student> searchGrade(int grade) {
		List<Student> list = new ArrayList<>();
		// 제네릭의 타입 추론
		// - 생성되는 컬렉션 객체의 제네릭을 별도 작성하지 않아도
		// 참조 변수의 제네릭을 통해 제한되는 타입을 유추(추론)
		for(Student s:studentList) {
			if(s.getGrade()==(grade)) list.add(s);
		}
		return list;
	}



	public List<Student> seachGender(char gender) {
		List<Student> list = new ArrayList<>();
		for(Student s : studentList) {
			if(s.getGender()==gender) {
				list.add(s);
			}
			
		}
		return list;
	}



	/** 성적 순서 조회 서비스
	 * 
	 */
	public List<Student> sortScore() {
		// studentList 정렬(score 내림 차순)
		// - Collections 클래스 : 컬렉션에 도움되는 유용한 기능을 모은 클래스
		// - Comparable<T> 인터페이스
		//	-> 객체의 기본 정렬 기준을 제공하는 인터페이스
		
		
		// <?> : 모든 타입
		// <?> void Collections.sort(List<?> list)
		Collections.sort(studentList);
		// studentList에 저장된 객체 Student의 오버라이딩된 compareTo() 메서드를 이용해서 정렬
		// -> 현재 큰 숫자가 오른쪽으로 이동하도록 오버라이딩 되어 있다.
		// -> 오름차순 정렬 
		
		// - list 순서를 반대로 뒤집음
		// -> 오름차순 --> 내림차순
//		Collections.reverse(studentList);
		
		return studentList;
	}

}
