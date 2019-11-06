package com.ankit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ankit.dao.Slotdao;
import com.ankit.dao.slotdashdao;
import com.ankit.model.Slotdash;
import com.ankit.model.User;
import com.ankit.model.slot;

@Controller
public class slotcontroller {

	@Autowired
	public Slotdao sltdao;
	@Autowired
	public slotdashdao sltdashdao;
	@RequestMapping("admin/slots")
	public String slotdash()
	{
		return "sltdash";
	}
	
	@RequestMapping("admin/allslot")
	public String allssslot(Model model) throws SQLException
	{
	  List<Slotdash> list=sltdashdao.loadAll();
	   model.addAttribute("list",list);
		return "slotall";
	}
	@RequestMapping("admin/slotsearch")
	public String searchslot(Model model) throws SQLException
	{
		
		slot slot = new slot();
		model.addAttribute("slot",slot);
		return "slotfind";
	}
	@RequestMapping(value = "admin/slotshow", method = RequestMethod.POST)
	public String slotShow(@ModelAttribute("slot") slot slot,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","ab","abc@abc123");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<slot> list=new ArrayList<slot>();  
		conn.close();
		slot slot1=sltdao.getslot(slot.getUsername());
		list.add(slot1);
		model.addAttribute("list", list);
		
		//model.addAttribute("id", employee.getId());
		return "sall";
	}
	@RequestMapping("admin/deleteslot{username}")
	public String usrdel(@PathVariable(value="username") String username) throws  SQLException
	{
		
		sltdao.delete(username);
		//conn.close();
		return "success";
	}
	@RequestMapping("admin/newslot")
	public String Newslot(Model model)
	{
		slot slot=new slot();
		model.addAttribute("slot",slot);
		return "slotnew";
	}
	@RequestMapping(value = "admin/addslot", method = RequestMethod.POST)
	public String Adduser(@ModelAttribute("slot") slot slot,Model model, HttpServletRequest request) throws SQLException
	{
		sltdao.saveOrUpdate(slot.getSlot_no(),slot.getUsername());
		return "success";
	}
	@RequestMapping("user/usrslotsearch")
	public String usrsearchslot(Model model) throws SQLException
	{
		
		slot slot = new slot();
		model.addAttribute("slot",slot);
		return "usrslotfind";
	}
	@RequestMapping("user/usrallslot")
	public String allslot(Model model) throws SQLException
	{
		List<Slotdash> list=sltdashdao.loadAll();
		model.addAttribute("list",list);
		return "usrslotall";
	}
	@RequestMapping(value = "user/usrslotshow", method = RequestMethod.POST)
	public String usrslotShow(@ModelAttribute("slot") slot slot,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/1H8x5l0hIE","1H8x5l0hIE","zt9MF9W73V");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<slot> list=new ArrayList<slot>();  
		conn.close();
		slot slot1=sltdao.getslot(slot.getUsername());
		list.add(slot1);
		model.addAttribute("list", list);
		return "usrsall";
	}
}
