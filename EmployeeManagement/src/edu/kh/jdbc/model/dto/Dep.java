package edu.kh.jdbc.model.dto;

public class Dep {
	
	String name;
	int members;
	
	int salary;
	public Dep() {};
	public Dep(String name, int members, int salary) {
		super();
		this.name = name;
		this.members = members;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}



}
