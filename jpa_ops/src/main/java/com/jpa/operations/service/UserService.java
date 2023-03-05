package com.jpa.operations.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.SortControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jpa.operations.dao.UserRepository;
import com.jpa.operations.model.User;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@PostConstruct
	public void initDB() {
		List<User> userList = new ArrayList<>();
		userList.add(new User(111,"Ali","IT",32));
		userList.add(new User(222,"Sami","CSC",30));
		userList.add(new User(333,"Rafi","MECH",32));
		userList.add(new User(444,"waqar","ECE",21));
		userRepository.save(userList.get(0));
		userRepository.save(userList.get(1));
		userRepository.save(userList.get(2));
		userRepository.save(userList.get(3));
		
	}
	
	
	public List<User> getUserByProfession(String profession) {
		return userRepository.findByProfession(profession);
	}
	
	public List<User> getUserByAge(int age) {
		return userRepository.findByAge(age);
	}

	public void deleteUserById(int id) {
		 userRepository.deleteById(id);
	}
	
	public List<User> getUserByProfessionAndAge(String profession,int age){
		return userRepository.findByProfessionAndAge(profession, age);
	}
	
	public List<User> getAllUsers(){
		return userRepository.getAllUser();
	}
	
	public List<User> getSortedUsers(String field,String direction){
		if("ASC".equalsIgnoreCase(direction)) {
			return userRepository.findAll(Sort.by(field));
		}else {
			return userRepository.findAll(Sort.by(Direction.DESC,field));
		}
	}
}
