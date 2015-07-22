package dao;

import java.util.List;

import model.Details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDAO {

	@Autowired
	CassandraOperations cassandraOperations;

	public Details getUserDetails(String name)
	{
		String query= "select * from resume_details where name='"+name+"'";
		return cassandraOperations.selectOne(query, Details.class);
	}

	public void addUser(Details userDetails) 
	{
		cassandraOperations.insert(userDetails);		
	}

	public List<Details> getAllDetails() 
	{
		String query="select * from resume_details";
		return cassandraOperations.select(query,Details.class);
	}
	
}
