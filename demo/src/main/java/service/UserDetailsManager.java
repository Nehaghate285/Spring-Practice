package service;

import java.util.List;

import model.Details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDetailsDAO;

@Service
public class UserDetailsManager {

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	public Details getUserDetails(String name)
	{
		return userDetailsDAO.getUserDetails(name);
	}
	
	public void addUser(Details userDetails)
	{
		userDetailsDAO.addUser(userDetails);
	}
	
	public List<Details> getAllDetails()
	{
		return userDetailsDAO.getAllDetails();
		
	}
	
}
