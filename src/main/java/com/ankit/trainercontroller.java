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

import com.ankit.dao.Trainerdao;
import com.ankit.model.Trainer;


@Controller
public class trainercontroller {

	@Autowired
	public Trainerdao trdao;
	
	@RequestMapping("admin/altr")
	public String trainerdash()
	{
		return "trainerdash";
	}
	
	@RequestMapping("admin/alltrainer")
	public String alltrainer(Model model) throws SQLException
	{
		
		List<Trainer> list=trdao.loadAll();
		model.addAttribute("list",list);
		return "trainerall";
	}
	
	@RequestMapping("admin/deletetrainer{username}")
	public String traineredel(@PathVariable(value="username") String username) throws  SQLException
	{
		
		trdao.delete(username);
		//conn.close();
		return "success";
	}
	@RequestMapping("admin/trainersearch")
	public String searchtrainer(Model model) throws SQLException
	{
		
		Trainer trainer = new Trainer();
		model.addAttribute("trainer",trainer);
		return "trainerfind";
	}
	
	@RequestMapping(value = "admin/trainershow", method = RequestMethod.POST)
	public String trainerShow(@ModelAttribute("trainer") Trainer trainer,Model model) throws SQLException
	{
		List<Trainer> list=trdao.getUserbyname(trainer.getName());
		model.addAttribute("list",list);
		return "trainerall";
	}
	
	@RequestMapping("admin/newtrainer")
	public String Newtrainer(Model model)
	{
		Trainer trainer=new Trainer();
		model.addAttribute("trainer",trainer);
		return "trainernew";
	}
	@RequestMapping(value = "admin/addtrainer", method = RequestMethod.POST)
	public String Adduser(@ModelAttribute("trainer")  Trainer trainer,Model model, HttpServletRequest request) throws SQLException
	{
		trdao.saveOrUpdate(trainer);
		return "success";
	}
}
