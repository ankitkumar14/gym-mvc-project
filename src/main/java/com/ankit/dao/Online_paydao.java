package com.ankit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.offline_pay;
import com.ankit.model.online_pay;

public interface Online_paydao {
	@Autowired
	public Void saveOrUpdate(online_pay onpay);
	public List<online_pay> loadAll();
	public Void delete(String username);
	public online_pay getUser(String username);
}
