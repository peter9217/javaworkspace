package edu.kh.collection.list.service;

import java.util.ArrayList;
import java.util.List;

import edu.kh.collection.list.dto.Student;

public class StudentService {
	
	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentService() {
		studentList.add(new Student("홍길동", 3, 5, 17, "서울시 청계", 'M', 75));
		studentList.add(new Student("s길동", 1, 6, 18, "서울시 한강", 'M', 55));
		studentList.add(new Student("d길동", 2, 7, 19, "대전시", 'M', 65));
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
	
	public ArrayList<String> searchAddress(String address) {
		ArrayList st = new ArrayList(0);
		int num = 0;
		for(Student s:studentList) {
			if(s.getAddress().contains(address)) {
				st.add(s);
			}
		}
		return st;
	}

}
