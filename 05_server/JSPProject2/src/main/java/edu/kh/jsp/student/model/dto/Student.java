package edu.kh.jsp.student.model.dto;

public class Student {
	private String studentNo;			// 학번
	private String studentName;		// 이름
	private String studnetAddress;	// 주소
	private String departmentName;	// 학과명
	
	public Student() {}

	public Student(String studentNo, String studentName, String studnetAddress, String departmentName) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studnetAddress = studnetAddress;
		this.departmentName = departmentName;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudnetAddress() {
		return studnetAddress;
	}

	public void setStudnetAddress(String studnetAddress) {
		this.studnetAddress = studnetAddress;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studnetAddress=" + studnetAddress
				+ ", departmentName=" + departmentName + "]";
	}
	
	
	
	
}
