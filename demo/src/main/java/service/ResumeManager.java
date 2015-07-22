package service;

import java.util.List;

import model.Resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ResumeDAO;

@Service
public class ResumeManager {

	@Autowired
	ResumeDAO resumeDAO;
	
	public List<Resume> getResumes()
	{
		return resumeDAO.getResumes();
	}
	
	public Resume getResumeDetails(String name)
	{
		return resumeDAO.getResumeDetails(name);
	}

	public void addResumeDetails(Resume resume) {
		resumeDAO.addResumeDetails(resume);
	}
}
