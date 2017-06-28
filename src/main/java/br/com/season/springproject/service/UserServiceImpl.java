package br.com.season.springproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.season.springproject.dao.UserDAO;
import br.com.season.springproject.entity.User;


@Service
@Transactional //spring
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	List<User> users = new ArrayList<>();

	@Override
	public User findById(Integer id) {

		return userDAO.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public void save(User user) {
		//regras para salvamento são definidas nessa camada(service) a DAO somente executa a tarefa de salvamento. 
		userDAO.save(user);

	}

	@Override
	public User update(Integer userId, User user) {

		User foundUser = findById(userId);
		
		BeanUtils.copyProperties(user, foundUser);
		
		userDAO.update(foundUser);
		
		return foundUser;
	}

	@Override
	public void delete(User user) {
		
		userDAO.delete(user);

	}

}
