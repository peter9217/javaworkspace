package edu.kh.objectarray.dto;


public class Student {
	
	// 필드 (멤버변수) (캡슐화 원칙에 의해 모두 private)
	private int grade; // 학년
	private int classRoom; // ㅂㄴ
	private int number; // 번호
	private String name; // 이름
	
	private int kor; // 국 
	private int eng; // 영
	private int math; // 수
	
	
	
	// 생성자
	public Student() { } //기본 생성자
	
	public Student(int grade, int classRoom, int number, String name) {
		
		// this 참조변수
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.name = name;
		
	}
	

	//getter / setter
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public void ClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	public int getNumber() {
		return number;
	}
	
	public void number(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public String toString() {
		return String.format("%d학년 %d반 %d번 %s [%d %d %d] ", grade, classRoom, number, name, kor, eng, math);
	}
	
	
}
