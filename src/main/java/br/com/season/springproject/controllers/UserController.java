package br.com.season.springproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.season.springproject.entity.User;

@Controller
public class UserController {
	
	private List<User> users = new ArrayList<>();

	@RequestMapping("/users")
	public String users(ModelMap map){
		
		User user = new User();
		
		map.addAttribute("user",user);
		
		map.addAttribute("users",users);
		
		
		
		return "user";
	}
	
	@RequestMapping("/user/save")
	public String save(User user, ModelMap map){
		
	System.out.println("First name: " +user.getNome());
	System.out.println("Last name: " +user.getSobrenome());
	System.out.println("Address: " +user.getEndereco());
	System.out.println("Birthdate: " +user.getDatanasc());
	System.out.println("CPF: " +user.getCpf());
	
	users.add(user);
	
	user = new User();
	
	map.addAttribute("user",user);
	map.addAttribute("users",users);
	return "user";
	}
	
}
