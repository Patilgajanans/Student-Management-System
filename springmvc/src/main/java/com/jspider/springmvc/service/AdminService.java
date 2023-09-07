package com.jspider.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springmvc.pojo.AdminPOJO;
import com.jspider.springmvc.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository repository;

	public AdminPOJO checkAdmin(String username, String password) {
		
		AdminPOJO admin= repository.checkAdmin(username, password);
		
		return admin;
	}

	public AdminPOJO createAdmin(String username, String password) {
		AdminPOJO admin = repository.createAdmin(username,password);
		return admin;
	}

	public AdminPOJO checkAdmin() {
		AdminPOJO pojo = repository.checkAdmin();
		return pojo;
	}

}
