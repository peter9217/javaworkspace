package edu.kh.jdbc.dto;

import java.util.Objects;

// DTO (Data Transfer Object) : 값 전달용 객체
public class Employee1 {
	private String empId;
	private String empName;
	private int salary;
	private String departmentTitle;
	
	public Employee1() {}
	
	public Employee1(String empId, String empName, int salary, String departmentTitle) {
		this.empId = empId;
		this.empName = empName;
		this.salary =salary;
		this.departmentTitle = departmentTitle;
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartmentTitle() {
		return departmentTitle;
	}

	public void setDepartmentTitle(String departmentTitle) {
		this.departmentTitle = departmentTitle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentTitle, empId, empName, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee1 other = (Employee1) obj;
		return Objects.equals(departmentTitle, other.departmentTitle) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName) && salary == other.salary;
	}
	
	

}
