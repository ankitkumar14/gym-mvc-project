package com.ankit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.Trainer;

public interface Trainerdao {
	@Autowired
	public Void saveOrUpdate(Trainer tr);
	public Void delete(String username);
	public List<Trainer> getUserbyname(String name);
	public List<Trainer> loadAll();
}
