package com.mastek.training.hrapp.apis;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.training.hrapp.entities.Department;
import com.mastek.training.hrapp.entities.Employee;
import com.mastek.training.hrapp.entities.Project;
import com.mastek.training.hrapp.repositories.EmployeeRepository;

//@COmponent: indicate to Spring to create an object of this class as component
//@Scope: singleton: one object for application [default]
//	      prototype: one object copy for each usage

@Component
@Scope("singleton")
@Path("/employees/") //map the URL pattern with the class as service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ProjectService projectService;
	
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}
	
	@POST //HTTP method to send the form data
	@Path("/register") //URL pattern
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //form data
	@Produces(MediaType.APPLICATION_JSON) //JSON data
	public Employee registerOrUpdateEmployee(@BeanParam Employee emp) { //input bean using form
		emp = employeeRepository.save(emp);
		System.out.println("Employee Registered " + emp);
		return emp;
	}
	
	//use find method using pathParam
	// /find/1122 -> empno to pass as param of this method
	@Path("/find/{empno}")
	@GET //HTTP method used to call the API
	@Produces({//declare all possible content types of returned value)
		MediaType.APPLICATION_JSON, //object to be given in JSON
		MediaType.APPLICATION_XML	//object to be given in XML
	})
	public Employee findByEmpno(@PathParam("empno") int empno) {
		//fetches the Employee details from DB by empno
		//use the Path parameter as the argument for the method
		try {
			return employeeRepository.findById(empno).get();			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GET //HTTP method
	@Path("/fetchBySalary") //URL pattern
	@Produces(MediaType.APPLICATION_JSON) //response content type
	public List<Employee> fetchEmployeesBySalaryRange(
			@QueryParam("min") double min, //param min
			@QueryParam("max") double max){ //param max
		return employeeRepository.findBySalary(min, max);
	}
	
	@DELETE //delete HTTP Method
	@Path("/delete/{empno}")
	public void deleteByEmpno(@PathParam("empno") int empno) {
		employeeRepository.deleteById(empno);
	}

	//spring ensures that db session is open until all the operations in this method across repositories are completed
	//used to fetch all collections which are initialised using Lazy initialisation 
	@Transactional
	@POST //HTTP method
	@Path("/assign/department") //URL 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	public Employee assignDepartment(@FormParam("empno") int empno,
									 @FormParam("deptno") int deptno) {
		try {
			//fetch the entities to be associated
			Employee emp = findByEmpno(empno);
			Department dept = departmentService.findByDeptno(deptno);
			//manage the associations
			dept.getMembers().add(emp); //one assigned with many
			emp.setCurrentDepartment(dept); //many assigned with one
				
			emp = registerOrUpdateEmployee(emp);
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@POST //HTTP method
	@Path("/assign/project") //URL 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) //input format
	@Produces(MediaType.APPLICATION_JSON) //output format
	public Set<Project> assignProject(@FormParam("empno") int empno,
									  @FormParam("projectId") int projectId) {
		try {
			Employee emp = findByEmpno(empno);
			Project proj = projectService.findByProjectId(projectId);
			//since it is Many to Many, we just need to assign in on direction
			emp.getAssignments().add(proj);
			//update the association in the join table
			emp = registerOrUpdateEmployee(emp);
			return emp.getAssignments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}