package com.ankit.model;

import java.sql.Date;


@SuppressWarnings("deprecation")
public class offline_pay {

	private String username;
	private Integer amount;
	private String d_ate;
	private String start_month;
	private String end_month;
	private String payment_id;

	public offline_pay() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getD_ate() {
		return d_ate;
	}
	public void setD_ate(String d_ate) {
		this.d_ate = d_ate;
	}
	public String getStart_month() {
		return start_month;
	}
	public void setStart_month(String start_month) {
		this.start_month = start_month;
	}
	public String getEnd_month() {
		return end_month;
	}
	public void setEnd_month(String end_month) {
		this.end_month = end_month;
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	
}
