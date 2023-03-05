package com.jpa.operations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.operations.model.User;
import com.jpa.operations.service.UserService;

@RestController
@RequestMapping("/springdata")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/profession/{profession}")
	public List<User> getByProfession(@PathVariable String profession){
		return service.getUserByProfession(profession);
	}
	
	@GetMapping("/age")
	public List<User> getByProfession(@RequestParam("age") int age){
		return service.getUserByAge(age);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteUserById(id);
	}
	
	@GetMapping("/byProfessionAndAge/{profession}/{age}")
	public List<User> getUserByProfessionAndAge(@PathVariable String profession,@PathVariable int age){
		return service.getUserByProfessionAndAge(profession, age);
	}
	
	@GetMapping("/all")
	public List<User> getUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/sort/{field}/{direction}")
	public List<User> getUsersBySort(@PathVariable String field,@PathVariable String direction){
		return service.getSortedUsers(field,direction);
	}
}
