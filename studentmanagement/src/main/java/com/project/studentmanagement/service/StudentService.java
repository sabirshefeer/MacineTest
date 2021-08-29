package com.project.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.studentmanagement.model.Student;
import com.project.studentmanagement.reopositeries.StudentRepository;

@Service
public class StudentService {
	
	
	@Autowired
	StudentRepository studentRepository;

	public Student saveStudentDetails(Student student) {

		System.out.println("Saving Student to DB");
		Student savedStudent = studentRepository.save(student);
		System.out.println("Saved Student to DB");

		return savedStudent;
	}
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	public Student updateStudent(Student studentToUpdate) {
		
		System.out.println("Updating Student to DB");
		Student updatedStudent;
		Optional<Student> optionalValue = studentRepository.findById(studentToUpdate.getRollNo());
		if(optionalValue.isPresent()) {
			Student studentFromDb = optionalValue.get();
			//Copying deatils from studentToUpdate to sudentFromDB
			BeanUtils.copyProperties(studentToUpdate, studentFromDb);
			
			updatedStudent = studentRepository.save(studentFromDb);
		}else {
			updatedStudent = null;
		}
		System.out.println("Updated Student to DB");

		return updatedStudent;
	}
	public Student getStudent(String rollNo) {
		Optional<Student> optionalStudent = studentRepository.findById(rollNo);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}else {
			return null;
		}
	}

}
