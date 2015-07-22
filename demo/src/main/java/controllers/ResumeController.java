package controllers;

import model.Resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ResumeManager;

@Controller
public class ResumeController {

	@Autowired
	ResumeManager resumeManager;
	
	@RequestMapping(value="resume.htm")
	 public String loadResumePage(Model model)
	 {
		model.addAttribute("resumeDetails", new Resume());
		model.addAttribute("resume",resumeManager.getResumeDetails("Neha"));
		return "resume";
	 }
	
	
	@RequestMapping(value="resume.htm",method=RequestMethod.POST)
	 public String addResumePage(@ModelAttribute("resumeDetails") Resume resume,Model model)
	 {
		resumeManager.addResumeDetails(resume);
		
		//model.addAttribute("resumeDetails",resume);
		model.addAttribute("resume",resumeManager.getResumeDetails(resume.getName()));
		return "resume";
	 }
	
}
