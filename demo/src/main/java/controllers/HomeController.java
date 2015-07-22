package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping(value="home.htm")
	String loadHomePage(){
		return "home";
	}
	
	
}
