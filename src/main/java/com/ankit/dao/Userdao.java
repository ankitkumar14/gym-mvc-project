package com.ankit.dao;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.User;

public interface Userdao{
	@Autowired
	public Void saveOrUpdate(User user);
	public Void delete(String username);
	public User getUser(String username);
	public List<User> loadAll();
	public List<User> getUserbyname(String name);
}