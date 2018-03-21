package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springdemo.dao.StudentDAO;
import com.springdemo.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
		
		@Autowired
		private StudentDAO studentDAO;

		@RequestMapping("/list")
		public String listStudents(Model theModel) {
			
			// getting students from the studentDAO
			List<Student> theStudents = studentDAO.getStudents();
			
			theModel.addAttribute("students", theStudents);
			
			return "list-students";
		}
		
	}





