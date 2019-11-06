package com.ankit.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ankit.model.payment;

public class Paymentdaoimpl implements Paymentdao {

	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Paymentdaoimpl() {
		
	}
	public Paymentdaoimpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public Void saveOrUpdate(payment pay) {
		String sql="INSERT INTO payment VALUES(?,?)";
		jdbcTemplate.update(sql,new Object[] {pay.getPayment_id(),pay.getUsername()});
		return null;
	}

}
