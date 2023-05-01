package com.hspedu.mhl.domain;

public class Employee {
	private Integer id;
	private String empId;
	private String pwd;
	private String name;
	private String job;
	public Employee() {
		super();
	}
	public Employee(Integer id, String empId, String pwd, String name, String job) {
		super();
		this.id = id;
		this.empId = empId;
		this.pwd = pwd;
		this.name = name;
		this.job = job;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	

}
