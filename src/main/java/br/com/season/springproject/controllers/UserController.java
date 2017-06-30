package br.com.season.springproject.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.season.springproject.entity.User;
import br.com.season.springproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	// private List<User> users = new ArrayList<>();

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getUsers(ModelMap map) {

		ModelAndView view = new ModelAndView("user");
		User user = new User();

		List<User> users = userService.findAll();
		map.addAttribute("user", user);

		map.addAttribute("users", users);

		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(User user, ModelMap map) {
		userService.save(user);

		user = new User();

		map.addAttribute("user", user);
		map.addAttribute("users", userService.findAll());
		return "user";
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ModelAndView update(@PathVariable("userId") Integer userId, User user) {
		ModelAndView view = new ModelAndView("redirect:/user");
		User foundUser = userService.findById(userId);

		BeanUtils.copyProperties(user, foundUser, "id");

		foundUser = userService.update(foundUser);

		view.addObject("user", foundUser);

		return view;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String getById(@PathVariable("userId") Integer userId, ModelMap map) {
	
		User found = userService.findById(userId);

		List<User> list = userService.findAll();

		if (list.contains(found)) {
			found = list.get(list.indexOf(found));
		}
		map.addAttribute("user", found);

		return "user";
	}

	@RequestMapping("/getCpf/{cpf}")
	public @ResponseBody User findByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);

	}

}
