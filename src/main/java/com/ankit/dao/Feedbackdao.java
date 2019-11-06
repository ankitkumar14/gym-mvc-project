package com.ankit.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.ankit.model.feedback;

public interface Feedbackdao {
	@Autowired
	public Void Add(feedback feed);
}
