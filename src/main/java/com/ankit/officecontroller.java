package com.ankit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ankit.dao.Officedao;
import com.ankit.model.User;
import com.ankit.model.office;

@Controller
public class officecontroller {
	@Autowired
	public Officedao ofcdao;
	@RequestMapping("admin/aloff")
	public String oficedash()
	{
		return "officedash";
	}
	
	
	@RequestMapping("admin/aloffice")
	public String alloffice(Model model) throws SQLException
	{
		List<office> list=ofcdao.loadAll();
		model.addAttribute("list",list);
		return "officeall";
	}
	@RequestMapping("admin/deleteoffice{no}")
	public String officedel(@PathVariable(value="no") Integer no) throws  SQLException
	{
		
		ofcdao.delete(no);
		return "success";
	}
	@RequestMapping("admin/newoffice")
	public String Newoffice(Model model)
	{
		office office=new office();
		model.addAttribute("office",office);
		return "officenew";
	}
	@RequestMapping(value = "admin/addoffice", method = RequestMethod.POST)
	public String Adduser(@ModelAttribute("office") office office,Model model, HttpServletRequest request) throws SQLException
	{
		ofcdao.saveOrUpdate(office);
		return "success";
		}
}
