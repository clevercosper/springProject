package br.com.season.springproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.season.springproject.entity.User;

@Service
public class UserServiceImpl implements UserService {

	List<User> users = new ArrayList<>();
	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public void save(User user) {
		users.add(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

}
