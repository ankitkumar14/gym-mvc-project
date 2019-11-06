package com.ankit.model;

import java.sql.Date;


@SuppressWarnings("deprecation")
public class salary {
	private String username;
	private String name;
	private String exp;
	private Integer amount;
	private Integer work_time;
	private Date join_date;
	private String given_till;
	public salary(String username, String name, String exp, Integer amount, Integer work_time, Date join_date,
			String given_till) {
		super();
		this.username = username;
		this.name = name;
		this.exp = exp;
		this.amount = amount;
		this.work_time = work_time;
		this.join_date = join_date;
		this.given_till = given_till;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getWork_time() {
		return work_time;
	}
	public void setWork_time(Integer work_time) {
		this.work_time = work_time;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getGiven_till() {
		return given_till;
	}
	public void setGiven_till(String given_till) {
		this.given_till = given_till;
	}
	
}
