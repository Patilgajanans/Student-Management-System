package com.jspider.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springmvc.pojo.StudentPOJO;
import com.jspider.springmvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(String name, String email, String contact, String address) {
		StudentPOJO pojo = repository.addStudent(name,email,contact,address);
		return pojo;
	}

	public StudentPOJO searchStudent(int id) {
		StudentPOJO student = repository.searchStudent(id);
		return student;
	}

	public List<StudentPOJO> displayStudents() {
		List<StudentPOJO> students = repository.displayStudents();
		
		return students;
	}

	public StudentPOJO deleteStudent(int id) {
		StudentPOJO student = repository.deleteStudent(id);
		return student;
	}

	public List<StudentPOJO> searchStudent(String attr, String value) {
		List<StudentPOJO>students =  repository.searchStudent(attr , value);
		return students;
	}

	public StudentPOJO editStudent(int id, String name, String email, long contact, String address) {
		StudentPOJO pojo = repository.editStudent(id,name,email,contact,address);
		return pojo;
	}

}
