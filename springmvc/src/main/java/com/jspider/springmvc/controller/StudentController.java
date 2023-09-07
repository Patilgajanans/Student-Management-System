package com.jspider.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.springmvc.pojo.StudentPOJO;
import com.jspider.springmvc.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/update")
	public String update() {
		return "Update";
	}
	
	@GetMapping("/add")
	public String add(ModelMap map) {
		List<StudentPOJO>students= service.displayStudents();
		if (!students.isEmpty()) {
			map.addAttribute("students",students);
		}
		return "Add";
	}
	
	//Add Student Details
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email,@RequestParam String contact, @RequestParam String address,ModelMap map ) 
	{
		
		StudentPOJO pojo = null;
		
		if (!name.isEmpty() && !email.isEmpty() && !(contact.isBlank()) && !address.isEmpty()) {
			pojo =service.addStudent(name,email,contact,address);
		}
				
				
		List<StudentPOJO>students= service.displayStudents();

		
		if (pojo != null) {
			map.addAttribute("msg","Details Saved Successfully......!");
			map.addAttribute("students",students);
			return "Add";
			
		}
		map.addAttribute("msg", "Details Is Not Saved ....!");
		map.addAttribute("students",students);
		return "Add";
		
	}
	@GetMapping("/search")
	public String search() {
		return "Search1";
	}
	
//	//Search Student Details
//	@PostMapping("/search")
//	public String searchStudent(@RequestParam int id, ModelMap map)
//	{
//		StudentPOJO studentpojo =  service.searchStudent(id);
//		
//		if (studentpojo != null) {
//			map.addAttribute("msg","Data Found in DataBase");
//			map.addAttribute("student",studentpojo);
//			return "Search";
//		}
//		map.addAttribute("msg","Data Is Not Found In DataBase");
//		return "Search";
//	}
	
	//Search Student Details
		@PostMapping("/search")
		public String searchStudent(@RequestParam("selectedOption") String attr,@RequestParam String value, ModelMap map)
		{
			List<StudentPOJO>students = null;
			if (attr.equals("All")) {
				students =  service.displayStudents();
			} 
			else if ( !attr.equals("All") && !value.isEmpty()) {
				students =  service.searchStudent(attr , value);
			}
			System.out.println(students);
			
			if (!students.isEmpty()) {
				map.addAttribute("msg","Data Found in DataBase");
				map.addAttribute("students",students);
				return "Search1";
			}
			map.addAttribute("msg","Data Is Not Found In DataBase");
			return "Search1";
		}
	
	@GetMapping("/delete")
	public String display(ModelMap map) {
		
		List<StudentPOJO>students= service.displayStudents();
		
		if (!students.isEmpty()) {
			map.addAttribute("students",students);
		}
		return "Delete";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam int id, ModelMap map) 
	{
		StudentPOJO student = service.deleteStudent(id);
		List<StudentPOJO>students= service.displayStudents();
		
		if (student != null) {
			map.addAttribute("msg","Data is Removed");
			map.addAttribute("students",students);
			return "Delete";
		}
		
		map.addAttribute("msg","Data is not Found");
		map.addAttribute("students",students);
		return "Delete";
	} 
	
	
	//update Value
	@PostMapping("/update")
	public String updateDetails(@RequestParam("selectedOption") String attr,@RequestParam String value, ModelMap map)
	{
		List<StudentPOJO>students = null;
		if (attr.equals("All")) {
			students =  service.displayStudents();
		} 
		else if ( !attr.equals("All") && !value.isEmpty()) {
			students =  service.searchStudent(attr , value);
		}
		System.out.println(students);
		
		if (!students.isEmpty()) {
			map.addAttribute("msg","Data Found in DataBase");
			map.addAttribute("students",students);
			return "Update";
		}
		map.addAttribute("msg","Data Is Not Found In DataBase");
		return "Update";
	}
	
	@PostMapping("/save")
	public String saveDetails(@RequestParam int []id,@RequestParam String []name,@RequestParam long []contact,@RequestParam String []email,@RequestParam String []address ,ModelMap map)
	{
		
		List<StudentPOJO>students = new ArrayList<StudentPOJO>();
		int num=0;
		for(int id2 : id) {
			students.add(service.editStudent(id[num], name[num], email[num],contact[num], address[num]));
			num++;
		}
		
		if (!students.isEmpty()) {
			map.addAttribute("msg","Details Saved Successfully......!");
			map.addAttribute("students",students);
			return "Update" ;
			
		}
		map.addAttribute("msg", "Details Is Not Saved ....!");
		return "Update";
	}
	
	
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}
	
}
