package com.ankit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ankit.model.User;
import com.ankit.model.office;

public class Officedaoimpl implements Officedao {

	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Officedaoimpl() {
		
	}
	public Officedaoimpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public Void saveOrUpdate(office ofc) {
		String sql = "INSERT INTO office(no, location,rating) VALUES (?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {ofc.getNo(),ofc.getLocation(),ofc.getRating()});
		return null;
	}

	public Void delete(Integer no) {
		String sql = "DELETE FROM office WHERE no=?";
		jdbcTemplate.update(sql,no);
		return null;
	}

	public List<office> loadAll() {
		List<office> list;
		String sql="select * from office";
		list=(List<office>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<office>(office.class));
		return list;
	}

}
