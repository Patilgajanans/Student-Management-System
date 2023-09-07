package com.jspider.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.springmvc.pojo.AdminPOJO;
import com.jspider.springmvc.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@GetMapping("/login")
	public String getLogin()
	{
		return "Login";
	}
	

	@GetMapping("/createAccount")
	public String getCreateAccount(ModelMap map)
	{
		AdminPOJO admin = null;
		admin = service.checkAdmin();
		if (admin == null) {
			return "CreateAccount";
		}
		
		map.addAttribute("msg","Accout is Already Present");
		return "Login";
		
	}
	
	@PostMapping("/check")
	public String postLogin(@RequestParam String username, @RequestParam String password,ModelMap map)
	{
		AdminPOJO admin= service.checkAdmin(username, password);
		
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg","Wrong Credential ! try Again ");
		return "Login";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username, @RequestParam String password, ModelMap map)
	{
		AdminPOJO admin= null;
		
		if (!username.isEmpty() && !password.isEmpty()) {
			admin =service.createAdmin(username, password);
		}
		
		if (admin != null) {
			map.addAttribute("msg","Account Created Successfully ! ");
			return "Login";
		}
		
		map.addAttribute("msg","Account is already present or another error ! ");
		return  "CreateAccount";
	}

}
