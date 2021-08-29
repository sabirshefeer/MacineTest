package com.project.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.studentmanagement.model.Student;
import com.project.studentmanagement.service.StudentService;



@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping(value = "/student/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView save(Student student) {
		// Pass The student details from request to service in Student object format
		Student savedStudent = studentService.saveStudentDetails(student);
		List<Student> studentList = studentService.getAllStudents();
		ModelAndView view = new ModelAndView("adminHome");
		view.addObject("students", studentList);
		return view;

	}
	
	@PostMapping(value = "/student/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView update(Student student) {
		// Pass The student details from request to service in Student object format
		Student savedStudent = studentService.updateStudent(student);
		List<Student> studentList = studentService.getAllStudents();
		ModelAndView view = new ModelAndView("adminHome");
		view.addObject("students", studentList);
		return view;

	}
	
	@GetMapping("/getStudent")
	public ModelAndView getStudentDetails(@RequestParam("rollNo") String rollNo) {
		Student student = studentService.getStudent(rollNo);
		ModelAndView view;
		if (student != null) {
			view = new ModelAndView("studentData");
			view.addObject("title", "Details of Student wtih roll no: " + student.getRollNo());
			view.addObject("student", student);
		} else {
			view = new ModelAndView("error");
		}
		return view;
	}
	
	@GetMapping("/getStudent/{rollNo}")
	public ModelAndView getStudentDetailsByRollNo(@PathVariable("rollNo") String rollNo) {
		Student student = studentService.getStudent(rollNo);
		ModelAndView view;
		if (student != null) {
			view = new ModelAndView("studentData");
			view.addObject("title", "Details of Student wtih roll no: " + student.getRollNo());
			view.addObject("student", student);
		} else {
			view = new ModelAndView("error");
		}
		return view;
	}

}
