package validators;

import model.Project;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object pojo, Errors error) {

		Project projectPOJO = (Project) pojo;
		
		if(projectPOJO.getProjectName() == null || projectPOJO.getProjectName().isEmpty()){
			error.rejectValue("projectName", "projectName", "Please Enter Project name");
		}
	}

}
