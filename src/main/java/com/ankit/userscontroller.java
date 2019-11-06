package com.ankit;

import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ankit.dao.Officedao;
import com.ankit.dao.Slotdao;
import com.ankit.dao.Trainerdao;
import com.ankit.dao.Userdao;
import com.ankit.model.Slotdash;
import com.ankit.model.Trainer;
import com.ankit.model.User;
import com.ankit.model.office;

@Controller
public class userscontroller {
	@Autowired
	public Userdao usrdao;
	@Autowired
	public Trainerdao trdao;
	@Autowired
	public Officedao ofcdao;
	@Autowired
	public Slotdao sltdao;
	@RequestMapping("admin/alusers")
	public String userdash()
	{
		return "userdash";
	}
	
	@RequestMapping(value = "success", method = { RequestMethod.GET, RequestMethod.POST })
	public String succ()
	{
		return "success";
	}
	
	@RequestMapping("admin/alluser")
	public String allusers(Model model) throws SQLException
	{
		
		List<User> list=usrdao.loadAll();
		model.addAttribute("list",list);
		return "userall";
	}
	@RequestMapping("admin/deleteusr{username}")
	public String usrdel(@PathVariable(value="username") String username) throws  SQLException
	{
		
		usrdao.delete(username);
		//conn.close();
		return "success";
	}
	@RequestMapping("admin/usrsearch")
	public String searchusr(Model model) throws SQLException
	{
		
		User user = new User();
		model.addAttribute("user",user);
		return "userfind";
	}
	@RequestMapping(value = "admin/usrshow", method = RequestMethod.POST)
	public String userShow(@ModelAttribute("user") User user,Model model) throws SQLException
	{
		List<User> list=usrdao.getUserbyname(user.getName());
		model.addAttribute("list",list);
		return "userall";
		
	}
	@RequestMapping("admin/newusr")
	public String Newuser(Model model)
	{
		User user=new User();
		model.addAttribute("user",user);
		return "usernew";
	}
	@RequestMapping(value = "admin/adduser", method = RequestMethod.POST)
	public String Adduser(@ModelAttribute("user") User user,Model model, HttpServletRequest request) throws SQLException
	{
		usrdao.saveOrUpdate(user);
		return "success";
	}
	@RequestMapping("user/useralltrainer")
	public String useralltrainer()
	{
		return "useralltrainerdash";
	}
	@RequestMapping("user/usertrainer")
	public String allusrtr(Model model) throws SQLException
	{
		
		List<Trainer> list=trdao.loadAll();
		model.addAttribute("list",list);
		return "useralltr";
	}
	@RequestMapping("user/usertrainersearch")
	public String usrsearchtrainer(Model model) throws SQLException
	{
		
		Trainer trainer = new Trainer();
		model.addAttribute("trainer",trainer);
		return "usertrainerfind";
	}
	@RequestMapping(value = "user/usrtrainershow", method = RequestMethod.POST)
	public String usrtrainerShow(@ModelAttribute("trainer") Trainer trainer,Model model) throws SQLException
	{
		List<Trainer> list=trdao.getUserbyname(trainer.getName());
		model.addAttribute("list",list);
		return "usrtrainerall";
	}
	@RequestMapping("user/useroffice")
	public String oficedash()
	{
		return "userofficedash";
	}
	@RequestMapping("user/usraloffice")
	public String usralloffice(Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/1H8x5l0hIE","1H8x5l0hIE","zt9MF9W73V");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<office> list=ofcdao.loadAll();
		conn.close();
		model.addAttribute("list",list);
		return "usrofficeall";
	}
	@RequestMapping("user/userslot")
	public String userslotdash()
	{
		return "usrsltdash";
	}
}
