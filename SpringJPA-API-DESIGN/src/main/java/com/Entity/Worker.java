package com.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="worker")
public class Worker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="worker_id")
	private int workerId;
	
	@Column(name="FIRST_NAME")
	private String fname;
	
	@Column(name="LAST_NAME")
	private String lname;
	
	@Column(name="SALARY")
	private int salary;
	
	@Column(name="JOINING_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Jdate;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@JsonManagedReference
	@OneToMany(mappedBy="worker",fetch=FetchType.LAZY,
			cascade= CascadeType.ALL,orphanRemoval = true)
	private List<Bonus> bonuses;

	public Worker(String fname, String lname, int salary, Date jdate, String department) {
		
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		Jdate = jdate;
		this.department = department;
	}

	public Worker() {
		
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getJdate() {
		return Jdate;
	}

	public void setJdate(Date jdate) {
		Jdate = jdate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	

	
	public List<Bonus> getBonuses() {
		return bonuses;
	}

	public void setBonuses(List<Bonus> bonuses) {
		this.bonuses = bonuses;
	}

	
	

	public void add(Bonus bonus)
	{
		if(bonuses==null)
		{
			bonuses=new ArrayList<Bonus>();
		}
		bonuses.add(bonus);
		bonus.setWorker(this);
	}
	
	
	
	
}
