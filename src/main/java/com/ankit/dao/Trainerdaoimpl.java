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

public class Trainerdaoimpl implements Trainerdao {
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Trainerdaoimpl() {
		
	}
	public Trainerdaoimpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public Void saveOrUpdate(Trainer tr) {
		String sql = "INSERT INTO trainer(username,name,address,email_id,contact_no,age,achievement,studies,slot_no) VALUES (?,?,?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {tr.getUsername(),tr.getName(),tr.getAddress(),tr.getEmail_id(),tr.getContact_no(),tr.getAge(),tr.getAchievement(),tr.getStudies(),tr.getSlot_no()});

		return null;
	}

	public Void delete(String username) {
		String sql = "DELETE FROM trainer WHERE username=?";
		jdbcTemplate.update(sql,username);
		return null;
	}


	public List<Trainer> getUserbyname(String name) {
		List<Trainer> list;
		String sql="select * from trainer WHERE name='"+name+"'";
		list=(List<Trainer>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Trainer>(Trainer.class));
		return list;
	}
	public List<Trainer> loadAll() {
		List<Trainer> list;
		String sql="select * from trainer";
		list=(List<Trainer>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Trainer>(Trainer.class));
		return list;
	}

}
