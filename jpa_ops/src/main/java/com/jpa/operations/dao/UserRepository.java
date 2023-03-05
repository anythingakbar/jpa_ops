package com.jpa.operations.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.operations.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByProfession(String profession);
	
	public List<User> findByAge(int age);
	
	public List<User> findByProfessionAndAge(String profession, int age);
	
	@Query("select a from User a")
	public List<User> getAllUser(); 
	
	
}