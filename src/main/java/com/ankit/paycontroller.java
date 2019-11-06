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

import com.ankit.dao.Offline_paydao;
import com.ankit.dao.Online_paydao;
import com.ankit.dao.Paymentdao;
import com.ankit.model.User;
import com.ankit.model.offline_pay;
import com.ankit.model.online_pay;



@Controller
public class paycontroller {

	@Autowired
	public Offline_paydao offdao;
	@Autowired
	public Online_paydao ondao;
	@RequestMapping("admin/pay")
	public String paydash()
	{
		return "paydash";
	}
	@RequestMapping("admin/offpay")
	public String ofpay()
	{
		return "offpaydash";
	}
	@RequestMapping("admin/onpay")
	public String onpay()
	{
		return "onpaydash";
	}
	@RequestMapping("admin/alloffpay")
	public String alloffpay(Model model) throws SQLException
	{
		
		List<offline_pay> list=offdao.loadAll();
		model.addAttribute("list",list);
		return "offpayall";
	}
	@RequestMapping("admin/allonpay")
	public String allonpay(Model model) throws SQLException
	{
		
		List<online_pay> list=ondao.loadAll();
		model.addAttribute("list",list);
		return "onpayall";
	}
	@RequestMapping("admin/deleteoffpay{username}")
	public String offpaydel(@PathVariable(value="username") String username) throws  SQLException
	{
		
		offdao.delete(username);
		//conn.close();
		return "success";
	}
	@RequestMapping("admin/deleteonpay{username}")
	public String onpaydel(@PathVariable(value="username") String username) throws  SQLException
	{
		
		ondao.delete(username);
		//conn.close();
		return "success";
	}
	@RequestMapping("admin/offpaysearch")
	public String searchoffpay(Model model) throws SQLException
	{
		
		offline_pay offline_pay= new offline_pay();
		model.addAttribute("offline_pay",offline_pay);
		return "offpayfind";
	}
	@RequestMapping("admin/onpaysearch")
	public String searchonpay(Model model) throws SQLException
	{
		
		online_pay online_pay= new online_pay();
		model.addAttribute("online_pay",online_pay);
		return "onpayfind";
	}
	@RequestMapping(value = "admin/offpayshow", method = RequestMethod.POST)
	public String offpayShow(@ModelAttribute("offline_pay") offline_pay offline_pay,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","ab","abc@abc123");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<offline_pay> list=new ArrayList<offline_pay>();  
		conn.close();
		offline_pay offline_pay1=offdao.getUser(offline_pay.getUsername());
		list.add(offline_pay1);
		model.addAttribute("list", list);
		
		//model.addAttribute("id", employee.getId());
		return "offpayall";
	}
	@RequestMapping(value = "admin/onpayshow", method = RequestMethod.POST)
	public String onpayShow(@ModelAttribute("online_pay") online_pay online_pay,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","ab","abc@abc123");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<online_pay> list=new ArrayList<online_pay>();  
		conn.close();
		online_pay online_pay1=ondao.getUser(online_pay.getUsername());
		list.add(online_pay1);
		model.addAttribute("list", list);
		
		//model.addAttribute("id", employee.getId());
		return "onpayall";
	}
	@RequestMapping("admin/newoffpay")
	public String Newoffpay(Model model)
	{
		offline_pay offline_pay=new offline_pay();
		model.addAttribute("offline_pay",offline_pay);
		return "offpaynew";
	}
	@RequestMapping("admin/newonpay")
	public String Newonpay(Model model)
	{
		online_pay online_pay=new online_pay();
		model.addAttribute("online_pay",online_pay);
		return "onpaynew";
	}
	@RequestMapping(value = "admin/addoff", method = RequestMethod.POST)
	public String Addoff(@ModelAttribute("offline_pay") offline_pay offline_pay,Model model, HttpServletRequest request) throws SQLException
	{
		offdao.saveOrUpdate(offline_pay);
		return "success";
	}
	@RequestMapping(value = "admin/addon", method = RequestMethod.POST)
	public String Addon(@ModelAttribute("online_pay") online_pay online_pay,Model model, HttpServletRequest request) throws SQLException
	{
		ondao.saveOrUpdate(online_pay);
		return "success";
	}
	@RequestMapping("user/userpayment")
	public String userpaydash()
	{
		return "usrpaydash";
	}
	@RequestMapping("user/usroffpay")
	public String usrofpay()
	{
		return "usroffpaydash";
	}
	@RequestMapping("user/usroffpaysearch")
	public String usrsearchoffpay(Model model) throws SQLException
	{
		
		offline_pay offline_pay= new offline_pay();
		model.addAttribute("offline_pay",offline_pay);
		return "usroffpayfind";
	}
	@RequestMapping(value = "user/usroffpayshow", method = RequestMethod.POST)
	public String usroffpayShow(@ModelAttribute("offline_pay") offline_pay offline_pay,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","ab","abc@abc123");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<offline_pay> list=new ArrayList<offline_pay>();  
		conn.close();
		offline_pay offline_pay1=offdao.getUser(offline_pay.getUsername());
		list.add(offline_pay1);
		model.addAttribute("list", list);
		
		//model.addAttribute("id", employee.getId());
		return "usroffpayall";
	}
	@RequestMapping("user/usronpay")
	public String usronpay()
	{
		return "usronpaydash";
	}
	@RequestMapping("user/usronpaysearch")
	public String usrsearchonpay(Model model) throws SQLException
	{
		
		online_pay online_pay= new online_pay();
		model.addAttribute("online_pay",online_pay);
		return "usronpayfind";
	}
	@RequestMapping(value = "user/usronpayshow", method = RequestMethod.POST)
	public String usronpayShow(@ModelAttribute("online_pay") online_pay online_pay,Model model) throws SQLException
	{
		Connection conn =null;
		try {conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","ab","abc@abc123");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		List<online_pay> list=new ArrayList<online_pay>();  
		conn.close();
		online_pay online_pay1=ondao.getUser(online_pay.getUsername());
		list.add(online_pay1);
		model.addAttribute("list", list);
		
		//model.addAttribute("id", employee.getId());
		return "usronpayall";
	}
}
