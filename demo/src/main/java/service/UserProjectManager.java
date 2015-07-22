package service;

import java.util.List;

import model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserProjectDAO;

@Service
public class UserProjectManager 
{
	@Autowired
	UserProjectDAO userProjectDAO;
	
	public List<Project> getProjects(String name)	
	{
		return userProjectDAO.getProjects(name);
	}

	public void addProject(Project newproject) {
		userProjectDAO.addProject(newproject);
	}
	

}
