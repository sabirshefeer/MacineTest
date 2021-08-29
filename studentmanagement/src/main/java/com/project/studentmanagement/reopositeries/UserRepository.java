package com.project.studentmanagement.reopositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.studentmanagement.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsernameAndPassword(String username, String password);
}
