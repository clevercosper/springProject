package br.com.season.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(ModelMap map) {
		map.addAttribute("nome","Zé das Cove");
		return "home";
	}

}
