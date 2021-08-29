package com.project.studentmanagement.reopositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.studentmanagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>  {

}
