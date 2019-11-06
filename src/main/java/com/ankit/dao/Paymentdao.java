package com.ankit.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.payment;

public interface Paymentdao {
	@Autowired
	public Void saveOrUpdate(payment pay);
}
