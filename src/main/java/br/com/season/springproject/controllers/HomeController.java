package br.com.season.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		// map.addAttribute("nome","Zé das Cove");
		return "home";
	}

	@RequestMapping("/test")
	public String getId(@RequestParam("id") String id, ModelMap map) {
		map.addAttribute("id", id);
		return "home";
	}
	@RequestMapping("/hello")
	public String hello(@RequestHeader("User-Agent") String agent, 
			@RequestHeader(value="Accept") String accept, ModelMap map){
		map.addAttribute("agent",agent);
		map.addAttribute("accept",accept);
		return "home";
	}
}
