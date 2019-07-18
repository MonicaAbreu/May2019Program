package com.mastek.training.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.ProjectRepository;

//@COmponent: indicate to Spring to create an object of this class as component
//@Scope: singleton: one object for application [default]
//	      prototype: one object copy for each usage

@Component
@Scope("singleton")
@Path("/projects/")
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public ProjectService() {
		System.out.println("Project Service Created");
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Project registerOrUpdateProject(@BeanParam Project prj) {
		prj = projectRepository.save(prj);
		System.out.println("Project Registered "+prj);
		return prj;
	}

	@Path("/find/{projectId}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Project findByProjectId(@PathParam("projectId") int projectId) {
		try {
			return projectRepository.findById(projectId).get();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("/delete/{projectId}")
	public void deleteByProjectId(@PathParam("projectId") int projectId) {
		projectRepository.deleteById(projectId);
	}
}


