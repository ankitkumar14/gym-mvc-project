package com.ankit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.Slotdash;

public interface slotdashdao {
	
	@Autowired
	public List<Slotdash> loadAll();
}
