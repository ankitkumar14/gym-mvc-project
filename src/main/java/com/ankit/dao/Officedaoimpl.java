package com.ankit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
		String sql = "SELECT * FROM office";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<office> >() {
		
		public List<office> extractData(ResultSet rs) throws SQLException,DataAccessException{

			List<office> ls=new ArrayList<office>();  
			while(rs.next()) {
				office office = new office();
				office.setNo(rs.getInt("no"));
				office.setLocation(rs.getString("location"));
				office.setRating(rs.getInt("rating"));
				ls.add(office);
			}
			return ls;
		}
		
	});
}

}
