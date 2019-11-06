package com.ankit.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ankit.dao.Feedbackdao;
import com.ankit.model.feedback;

public class Feedbackdaoimpl implements Feedbackdao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void FeedbackdaoImpl() {
		
	}
	public void FeedbackdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public Void Add(feedback feed) {
		String sql="INSERT INTO feedback VALUES(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {feed.getEmail_id(),feed.getSuggestion(),feed.getUsername(),feed.getRating()});
		return null;
	}

}
