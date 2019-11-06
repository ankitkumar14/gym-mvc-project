package com.ankit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.User;
import com.ankit.model.office;

public interface Officedao {
	@Autowired
	public Void saveOrUpdate(office ofc);
	public Void delete(Integer no);
	public List<office> loadAll();
}
