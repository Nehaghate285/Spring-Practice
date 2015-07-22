package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAO {

	@Autowired
	CassandraOperations cassandraOperations;

	public List<String> getEmailIds() {
		return cassandraOperations.queryForList("select username from user", String.class);
	}
}
