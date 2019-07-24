package com.mastek.training.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

//create the Jersey server configuration class
@Component
public class APIConfig extends ResourceConfig{
	public APIConfig() {
		//register each service class in ResourceConfig
		register(EmployeeService.class);
		register(ProjectService.class);
		register(DepartmentService.class);
		
		//register the CORS Settings on the server
		register(CORSFilter.class);
	}

}
