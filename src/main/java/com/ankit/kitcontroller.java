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

import com.ankit.dao.Itemsdao;
import com.ankit.dao.Userdao;
import com.ankit.model.Items;
import com.ankit.model.User;

@Controller
public class kitcontroller {
	
	@Autowired
	public Itemsdao itmdao;
	@RequestMapping("admin/kits")
	public String itemdash()
	{
		return "itemdash";
	}
	
	@RequestMapping("admin/allitem")
	public String allitem(Model model) throws SQLException
	{
		
		List<Items> list=itmdao.loadAll();
		model.addAttribute("list",list);
		return "itemall";
	}
	@RequestMapping("admin/deleteitm{kid}")
	public String itmdel(@PathVariable(value="kid") Integer kid) throws  SQLException
	{
		
		itmdao.deleteItems(kid);
		//conn.close();
		return "success";
	}
	@RequestMapping("admin/itemsearch")
	public String searchitm(Model model) throws SQLException
	{
		Items items = new Items();
		model.addAttribute("items",items);
		return "itemfind";
	}
	@RequestMapping(value = "admin/itmshow", method = RequestMethod.POST)
	public String itmShow(@ModelAttribute("items") Items items,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/1H8x5l0hIE","1H8x5l0hIE","zt9MF9W73V");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<Items> list=new ArrayList<Items>();  
		conn.close();
		Items items1=itmdao.getItems(items.getKid());
		list.add(items1);
		model.addAttribute("list", list);
		
		//model.addAttribute("id", employee.getId());
		return "itemall";
	}
	@RequestMapping("admin/newitem")
	public String Newitm(Model model)
	{
		Items items=new Items();
		model.addAttribute("items",items);
		return "itemnew";
	}
	@RequestMapping(value = "admin/additem", method = RequestMethod.POST)
	public String Additem(@ModelAttribute("items") Items items,Model model, HttpServletRequest request) throws SQLException
	{
		itmdao.addItems(items);
		return "success";
	}
	@RequestMapping("user/useritem")
	public String useritemdash()
	{
		return "usritemdash";
	}
	@RequestMapping("user/usrallitem")
	public String usrallitem(Model model) throws SQLException
	{
		
		List<Items> list=itmdao.loadAll();
		model.addAttribute("list",list);
		return "usritemall";
	}
	@RequestMapping("user/usritemsearch")
	public String usrsearchitm(Model model) throws SQLException
	{
		Items items = new Items();
		model.addAttribute("items",items);
		return "usritemfind";
	}
	@RequestMapping(value = "user/usritmshow", method = RequestMethod.POST)
	public String usritmShow(@ModelAttribute("items") Items items,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/1H8x5l0hIE","1H8x5l0hIE","zt9MF9W73V");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<Items> list=new ArrayList<Items>();  
		conn.close();
		Items items1=itmdao.getItemsname(items.getName());
		list.add(items1);
		model.addAttribute("list", list);
		
		//model.addAttribute("id", employee.getId());
		return "usritemall";
	}
}
