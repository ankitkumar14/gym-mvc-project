package com.ankit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.User;
import com.ankit.model.offline_pay;

public interface Offline_paydao {
	@Autowired
	public Void saveOrUpdate(offline_pay user);
	public List<offline_pay> loadAll();
	public Void delete(String username);
	public List<offline_pay> getUser(String username);
}
