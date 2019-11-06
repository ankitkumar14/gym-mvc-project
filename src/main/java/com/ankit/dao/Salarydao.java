package com.ankit.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.salary;


public interface Salarydao {
	@Autowired
	public Void saveOrUpdate(salary sal);
}
