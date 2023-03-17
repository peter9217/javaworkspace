package edu.kh.jdbc.dto;

public class Employee2 {
	// 부서명, 직급명, 이름, 이메일
	String dept;
	String job;
	String name;
	String email;
	
	public Employee2() {}
	public Employee2(String dept, String job, String name, String email) {
		this.dept = dept;
		this.job = job;
		this.name = name;
		this.email = email;
	
	}
	public String getDeptName() {
		return dept;
	}
	public void setDeptName(String dept) {
		this.dept = dept;
	}
	public String getJobName() {
		return job;
	}
	public void setJobName(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
 
}
