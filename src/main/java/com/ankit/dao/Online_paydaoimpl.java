package com.ankit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ankit.model.Trainer;
import com.ankit.model.offline_pay;
import com.ankit.model.online_pay;

public class Online_paydaoimpl implements Online_paydao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void Online_paydaoImpl() {
		
	}
	public void Online_paydaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public Void saveOrUpdate(online_pay onpay) {
		String sql="INSERT INTO payment VALUES(?,?)";
		jdbcTemplate.update(sql,new Object[] {onpay.getPayment_id(),onpay.getUsername()});
		sql="INSERT INTO online_pay VALUES(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {onpay.getUsername(),onpay.getAmount(),onpay.getD_ate(),onpay.getVia(),onpay.getStart_month(),onpay.getEnd_month(),onpay.getPayment_id()});
		return null;
	}
	public Void delete(String username) {
		String sql = "DELETE FROM online_pay WHERE username=?";
		jdbcTemplate.update(sql,username);
		return null;
	}
	public List<online_pay> getUser(String username) {
		
		List<online_pay> list;
		String sql = "SELECT * FROM online_pay WHERE username='"+username+"'";
		list=(List<online_pay>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<online_pay>(online_pay.class));
		return list;
	}
	public List<online_pay> loadAll() {
		List<online_pay> list;
		String sql="select * from online_pay";
		list=(List<online_pay>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<online_pay>(online_pay.class));
		return list;
	}
}
