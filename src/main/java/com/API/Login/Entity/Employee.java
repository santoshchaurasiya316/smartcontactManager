package com.API.Login.Entity;
/*
 * this class has been made to practice Stream API method in main()
 */
public class Employee {

	private int empId;
	private String empName;
	private String empStatus;
	private float empSalary;
	
	
	
	public Employee(int empId, String empName, String empStatus, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empStatus = empStatus;
		this.empSalary = empSalary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empStatus=" + empStatus + ", empSalary="
				+ empSalary + "]";
	}
	
	
}
