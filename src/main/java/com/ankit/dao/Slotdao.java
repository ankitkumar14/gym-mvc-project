package com.ankit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.Slotdash;
import com.ankit.model.slot;

public interface Slotdao {
	@Autowired
	public Void saveOrUpdate(Integer id,String usr);
	public slot getslot(String username);
	public List<Slotdash> loadAll();
	public Void delete(String username);
}

