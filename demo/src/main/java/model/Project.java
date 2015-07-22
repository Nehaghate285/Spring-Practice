package model;

import java.util.Date;
import java.util.List;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value="user_project_details")
public class Project {
	
	@PrimaryKeyColumn(name = "username", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	 private String username;

	@PrimaryKeyColumn(name = "project_name", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	 private String projectName;
	
	@Column(value="currently_working")
	 private boolean currentlyWorking;
	 
	@Column(value="start_date") 
	private  Date startDate;
	 
	@Column(value="end_date") 
	private Date endDate;
	 
	@Column(value="environment")
	 private List<String> environments;
	 
	@Column(value="work_description") 
	private String workDescription;
	 
	@Column(value="project_description") 
	private String projectDescription;
	
	 
	 public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public boolean isCurrentlyWorking() {
		return currentlyWorking;
	}

	public void setCurrentlyWorking(boolean currentlyWorking) {
		this.currentlyWorking = currentlyWorking;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<String> getEnvironments() {
		return environments;
	}

	public void setEnvironments(List<String> environments) {
		this.environments = environments;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	 
}