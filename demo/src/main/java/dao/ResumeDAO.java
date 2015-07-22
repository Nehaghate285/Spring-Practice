package dao;

import java.util.List;

import model.Resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ResumeDAO {

	@Autowired
	CassandraOperations cassandraOperations;
	
	public Resume getResumeDetails(String name)
	{
		//return cassandraOperations.queryForList("select name from resume_details", String.class);
		String query = "select * from resume_details where name='"+name+"'";
		return cassandraOperations.selectOne(query,Resume.class);
	}

	public List<Resume> getResumes() {
		return cassandraOperations.select("select * from resume_details", Resume.class);
	}

	public void addResumeDetails(Resume resume) {
		cassandraOperations.insert(resume);
	}
}
