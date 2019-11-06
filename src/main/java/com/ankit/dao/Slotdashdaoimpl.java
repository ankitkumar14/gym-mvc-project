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

import com.ankit.model.Slotdash;
import com.ankit.model.User;

public class Slotdashdaoimpl implements slotdashdao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Slotdashdaoimpl() {
		
	}
	public Slotdashdaoimpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	/*
	 * public List<Slotdash> loadAll() {
	 * 
	 * String sql = "SELECT * FROM slotdash"; return jdbcTemplate.query(sql,new
	 * ResultSetExtractor<List<Slotdash> >() {
	 * 
	 * public List<Slotdash> extractData(ResultSet rs) throws
	 * SQLException,DataAccessException{
	 * 
	 * List<Slotdash> ls=new ArrayList<Slotdash>(); while(rs.next()) { Slotdash
	 * slotdash = new Slotdash(); slotdash.setSlot_no(rs.getInt("slot_no"));
	 * slotdash.setNo_of_stud(rs.getInt("no_of_stud"));
	 * slotdash.getStart_time(rs.getString("start_time"));
	 * slotdash.getEnd_time(rs.getString("end_time")); ls.add(slotdash); } return
	 * ls; }
	 * 
	 * }); }
	 */
	public List<Slotdash> loadAll() {
		List<Slotdash> list;
		String sql="select * from slotdash";
		list=(List<Slotdash>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Slotdash>(Slotdash.class));
		return list;
	}
}
