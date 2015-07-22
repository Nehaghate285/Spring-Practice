package controllers;

import model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserLoginController {

	@RequestMapping(value="userLogin.htm",  method = RequestMethod.GET)
	String loadLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "userLogin" ;
	}
	
	@RequestMapping(value="userLogin.htm", method = RequestMethod.POST)
	String submitLoginPage(Model model,@ModelAttribute("user") User user,BindingResult bindingResult) {
		
		model.addAttribute("user",user);
		return "userLogin" ;
	}
	
}
