package com.ankit.model;


@SuppressWarnings("deprecation")
public class payment {

	private String payment_id;
	private String username;
	public payment() {
		super();
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
