package com.project.studentmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.studentmanagement.model.Student;
import com.project.studentmanagement.model.Users;
import com.project.studentmanagement.service.AdminService;
import com.project.studentmanagement.service.StudentService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	StudentService studentService;

	@GetMapping("/admin")
	public ModelAndView loginPage() {
		ModelAndView view = new ModelAndView("login");
		return view;
	}

	@PostMapping(value = "/admin/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView adminHome(Users user, HttpSession session) {

		Users admin = adminService.getUserDetails(user);
		ModelAndView view;
		if (admin != null) {
			List<Student> studentList = studentService.getAllStudents();
			view = new ModelAndView("adminHome");
			session.setAttribute("username", admin.getUsername());
			view.addObject("students", studentList);
		} else {
			view = new ModelAndView("error");
		}

		return view;
	}

	@ResponseBody
	@PostMapping("/admin/save")
	public Users saveAdmin(@RequestBody Users user) {
		return adminService.saveAdmin(user);
	}

}
