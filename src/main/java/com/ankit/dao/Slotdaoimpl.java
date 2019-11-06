package com.ankit.dao;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ankit.model.Slotdash;
import com.ankit.model.User;
import com.ankit.model.slot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


public class Slotdaoimpl implements Slotdao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	
	private JdbcTemplate jdbcTemplate;
	
	public Slotdaoimpl() {
		
	}
	public Slotdaoimpl(DataSource datasource) {
		this.jdbcTemplate=new JdbcTemplate(datasource);
	}
	
	public Void saveOrUpdate(Integer id,String usr) {
		String sql = "INSERT INTO slot VALUES(?,?)";
		jdbcTemplate.update(sql,new Object[] {usr,id});
		sql="UPDATE slotdash SET no_of_stud=no_of_stud+1 WHERE slot_no=?";
		jdbcTemplate.update(sql,new Object[] {id});
		return null;
	}
	public slot getslot(String username) {
		String sql="SELECT * FROM slot WHERE username='"+username+"'";
		ResultSetExtractor<slot> extractor=new ResultSetExtractor<slot>() {
			
			public slot extractData(ResultSet rs) throws SQLException,DataAccessException{
				if(rs.next()) {
					slot slot=new slot();
					slot.setSlot_no(rs.getInt("slot_no"));
					slot.setUsername(rs.getString("username"));
					return slot;
				}
				return null;
			}
		};
		
		return jdbcTemplate.query(sql,extractor);
			
	}
	public List<Slotdash> loadAll() {
		String sql = "SELECT * FROM slotdash";
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Slotdash> >() {
		
		public List<Slotdash> extractData(ResultSet rs) throws SQLException,DataAccessException{

			List<Slotdash> ls=new ArrayList<Slotdash>();  
			while(rs.next()) {
				Slotdash slotdash= new Slotdash();
				slotdash.setSlot_no(rs.getInt("slot_no"));
				slotdash.setNo_of_stud(rs.getInt("no_of_stud"));
				ls.add(slotdash);
			}
			return ls;
		}
		
	});
}
	public Void delete(String username) {
		String sql="UPDATE slotdash SET no_of_stud=no_of_stud-1 WHERE slot_no=(SELECT slot_no FROM slot WHERE username=?)";
		jdbcTemplate.update(sql,username);
		sql = "DELETE FROM slot WHERE username=?";
		jdbcTemplate.update(sql,username);
		return null;
	}

}
