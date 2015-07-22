package controllers;

import model.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ProfileManager;

@Controller
public class ProfileController {
	
	@Autowired 
	ProfileManager profileManager;
	
	@RequestMapping(value="profile.htm", method = RequestMethod.GET)
	String loadProfilePage(Model model)
	{
		model.addAttribute("users", profileManager.getEmailIds());
		model.addAttribute("profile", new Profile());
		return "profile";
	}
	
	@RequestMapping(value="profile.htm", method = RequestMethod.POST)
	String fillProfile(@ModelAttribute("profile") Profile profile,Model model)
	{
		model.addAttribute("profile", profile);
		return "profile";
	}

}
