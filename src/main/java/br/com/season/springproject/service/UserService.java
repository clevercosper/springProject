package br.com.season.springproject.service;

import java.util.List;

import br.com.season.springproject.entity.User;

public interface UserService {
	
	User findById(Integer id);
	
	List<User> findAll();
	
	void save(User save);
	
	User update(Integer userId, User Id);

	void delete(User user);
}