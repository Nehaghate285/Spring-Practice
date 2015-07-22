package dao;

import java.util.List;

import model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserProjectDAO 
{

	@Autowired
	CassandraOperations cassandraOperations;

	public List<Project> getProjects(String name) 
	{
		String query="select * from user_project_details where username='"+name+"'";
		return cassandraOperations.select(query, Project.class);
	}

	public void addProject(Project newproject) {
		cassandraOperations.insert(newproject);		
	}
	
	
}
