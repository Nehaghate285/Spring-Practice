package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProfileDAO;

@Service
public class ProfileManager {

	@Autowired
	ProfileDAO profileDAO;
	
	public List<String> getEmailIds() {
		return profileDAO.getEmailIds();
	}

}
