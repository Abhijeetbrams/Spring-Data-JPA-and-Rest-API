package com.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="bonus")
public class Bonus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WORKER_REF_ID")
	private int id;
	
	@Column(name="BONUS_AMOUNT")
	private int amount;
	
	@Column(name="BONUS_DATE")
	@Temporal(TemporalType.DATE)
	private Date bonusDate;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER,
			 cascade=CascadeType.ALL)
	@JoinColumn(name="worker_id")
	private Worker worker;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getBonusDate() {
		return bonusDate;
	}

	public void setBonusDate(Date bonusDate) {
		this.bonusDate = bonusDate;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Bonus(int amount, Date bonusDate) {
		
		this.amount = amount;
		this.bonusDate = bonusDate;
	}

	public Bonus() {
		
	}

	@Override
	public String toString() {
		return "Bonus [id=" + id + ", amount=" + amount + ", bonusDate=" + bonusDate + "]";
	}

	
	
	
	
}
