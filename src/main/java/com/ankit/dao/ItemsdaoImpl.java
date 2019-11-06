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

import com.ankit.model.Items;
import com.ankit.model.User;

public class ItemsdaoImpl implements Itemsdao {
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Items> getItems(Integer kid) {
		List<Items> list;
		String sql="select * from kit WHERE kid='"+kid+"'";
		list=(List<Items>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Items>(Items.class));
		return list;
}
	public void addItems(Items items) {
		String sql="insert into kit set name=?,kid=?,size=?";
		Object object[]= {items.getName(),items.getKid(),items.getSize()};
		jdbcTemplate.update(sql,object);
	}
	public List<Items> admingetitems(Integer kid) {
		List<Items> list;
		String sql="select * from kit where kid= "+kid+"order by size";
		list=(List<Items>) jdbcTemplate.query(sql,new BeanPropertyRowMapper<Items>(Items.class));
		return list;
	}
	public void deleteItems(Integer kid) {
		String sql="delete from kit where kid= "+kid;
		jdbcTemplate.update(sql);
	}
	public List<Items> loadAll() {
		List<Items> list;
		String sql="select * from kit";
		list=(List<Items>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Items>(Items.class));
		return list;
	}
	public Items getItemsname(String name) {
		String sql = "SELECT * FROM kit WHERE name='"+name+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Items>() {
		
		public Items extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Items items = new Items();
				items.setKid(rs.getInt("kid"));
				items.setSize(rs.getInt("size"));
				return items;
			}
			return null;
		}
		
	});
}
}
