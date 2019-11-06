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

import com.ankit.model.User;
import com.ankit.model.offline_pay;

public class Offline_payimpl implements Offline_paydao {

	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void Online_paydaoImpl() {
		
	}
	public void Offline_paydaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public Void saveOrUpdate(offline_pay offpay) {
		String sql="INSERT INTO payment VALUES(?,?)";
		jdbcTemplate.update(sql,new Object[] {offpay.getPayment_id(),offpay.getUsername()});
		sql="INSERT INTO offline_pay VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {offpay.getUsername(),offpay.getAmount(),offpay.getD_ate(),offpay.getStart_month(),offpay.getEnd_month(),offpay.getPayment_id()});
		return null;
	}
	public Void delete(String username) {
		String sql = "DELETE FROM offline_pay WHERE username=?";
		jdbcTemplate.update(sql,username);
		return null;
	}
	public offline_pay getUser(String username) {
		String sql = "SELECT * FROM offline_pay WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<offline_pay>() {
		
		public offline_pay extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				offline_pay offline_pay = new offline_pay();
				offline_pay.setUsername(rs.getString("username"));
				offline_pay.setAmount(rs.getInt("amount"));
				return offline_pay;
			}
			return null;
		}
		
	});
}
	public List<offline_pay> loadAll() {
		List<offline_pay> list;
		String sql="select * from offline_pay";
		list=(List<offline_pay>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<offline_pay>(offline_pay.class));
		return list;
	}
}
