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

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.repositories.DepartmentRepository;

//@COmponent: indicate to Spring to create an object of this class as component
//@Scope: singleton: one object for application [default]
//	      prototype: one object copy for each usage

@Component
@Scope("singleton")
@Path("/departments/")
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentService() {
		System.out.println("Department Service Created");
	}
	
	@POST 
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Department registerOrUpdateDepartment(@BeanParam Department dept) {
		dept = departmentRepository.save(dept);
		System.out.println("Department Registered "+dept);
		return dept;
	}

	@Path("/find/{deptno}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Department findByDeptno(@PathParam("deptno") int deptno) {
		// fetches the Department details from DB by deptno
		try {
			return departmentRepository.findById(deptno).get();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("/delete/{deptno}")
	public void deleteByEmpno(int deptno) {
		departmentRepository.deleteById(deptno);
	}
}


