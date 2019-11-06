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

public class UserdaoImpl implements Userdao {

	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserdaoImpl() {
		
	}
	public UserdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	public Void saveOrUpdate(User user) {
		String sql = "INSERT INTO users(username, password,name,email,phone,age,address) VALUES (?,?,?,?,?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getPhone(),user.getAge(),user.getAddress()});
		 sql = "INSERT INTO users_roles(user,role) VALUES(?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),"ROLE_USER"});
		return null;
		
	}

	public Void delete(String username) {
		String sql = "DELETE FROM users WHERE username=?";
		jdbcTemplate.update(sql,username);
		return null;
	}

	public User getUser(String username) {
		String sql = "SELECT * FROM users WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		}
		
	});
	}

	public List<User> loadAll() {
		List<User> list;
		String sql="select * from users";
		list=(List<User>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}

	public List<User> getUserbyname(String name) {
		List<User> list;
		String sql="select * from users WHERE name='"+name+"'";
		list=(List<User>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return list;
	}
}
