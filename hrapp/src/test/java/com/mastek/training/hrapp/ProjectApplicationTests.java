package com.mastek.training.hrapp;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.ProjectService;
import com.mastek.training.hrapp.entities.Project;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationTests {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	Project proj;
	
	@Test
	public void exampleProjectTest() {
		System.out.println("Project Test case scenarios");
	}
	
	@Test
	public void addProjectUsingService() {
		proj.setProjectId(1);
		proj.setName("Project test");
		proj.setCustomerName("Customer Example");
		proj = projectService.registerOrUpdateProject(proj);
		assertNotNull(proj);
	}
	
	@Test 
	public void findByProjectIDUsingService() {
		int projectId = 1;
		assertNotNull(projectService.findByProjectId(projectId));
	}
	
/*	@Test
	public void deleteByProjectIDUsingService() {
		int projectId = 2;
		projectService.deleteByProjectId(projectId);
		assertNull(projectService.findByProjectId(projectId));
	}*/
}

