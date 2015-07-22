package controllers;

import javax.servlet.http.HttpServletRequest;

import model.Details;
import model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserDetailsManager;
import service.UserProjectManager;
import validators.ProjectValidator;

@Controller
public class UserDetailsController {
	
	
		@Autowired
		ProjectValidator projectValidator;
	
		@Autowired
		UserDetailsManager userDetailsManager;
		
		@Autowired
		UserProjectManager userProjectManager;
		

		@RequestMapping(value="userDetails.htm")
		public String getUserDetails(Model model)
		{
			model.addAttribute("userdetails", new Details());
			return "userDetails";
		}
		
		@RequestMapping(value="userDetails.htm",method=RequestMethod.POST)
		public String sendUserDetails(Model model,@ModelAttribute("userdetails") Details details)
		{
			model.addAttribute("userdetails", details);
			model.addAttribute("details",userDetailsManager.getUserDetails(details.getName()));
			return "userDetails";
		}
		
		@RequestMapping(value="addDetails.htm",method=RequestMethod.POST)
		public String addUser(Model model,@ModelAttribute("userdetails") Details details)
		{
			userDetailsManager.addUser(details);
			
			model.addAttribute("alldetails",userDetailsManager.getAllDetails());
			return "userDetails";
		}
		
		@RequestMapping(value="addDetails.htm")
		public String getallDetails(Model model)
		{
			model.addAttribute("userdetails", new Details());
			model.addAttribute("alldetails",userDetailsManager.getAllDetails());
			return "userDetails";
		}
		
		@RequestMapping(value="getDetails.htm")
		public String getDetails(@RequestParam(value="name")String name, Model model)
		{
			model.addAttribute("details",userDetailsManager.getUserDetails(name));
			return "user-profile";
		}

		@RequestMapping(value="getUserDetails.htm/name/{name}")
		public String getUserDetails(@PathVariable String name, Model model)
		{
			model.addAttribute("details",userDetailsManager.getUserDetails(name));
			return "user-profile";
		}
		
		@RequestMapping(value="getProjectDetails.htm")
		public String getProjectDetails(@RequestParam(value="name") String name, Model model,HttpServletRequest request)
		{
			request.getSession().setAttribute("username", name);
			
			model.addAttribute("details",userDetailsManager.getUserDetails(name));
			model.addAttribute("projects",userProjectManager.getProjects(name));
			model.addAttribute("newproject", new Project());
			
			return "user-profile";
		}
		
		@RequestMapping(value="addNewDetails.htm",method=RequestMethod.POST)
		public String addNewDetails(@ModelAttribute("newproject") Project newProject,BindingResult bindingResult, Model model,HttpServletRequest request)
		{
			
			projectValidator.validate(newProject, bindingResult);
			
			
			if(bindingResult.hasErrors()){
				model.addAttribute("details",userDetailsManager.getUserDetails( request.getSession().getAttribute("username").toString() ));
				model.addAttribute("projects",userProjectManager.getProjects( request.getSession().getAttribute("username").toString() ));
				return "user-profile";
			}
			
			userProjectManager.addProject(newProject);
			
			model.addAttribute("details",userDetailsManager.getUserDetails(newProject.getUsername()));
			model.addAttribute("projects",userProjectManager.getProjects(newProject.getUsername()));
			model.addAttribute("newproject", new Project());
			return "user-profile";
		}
		
		


}
