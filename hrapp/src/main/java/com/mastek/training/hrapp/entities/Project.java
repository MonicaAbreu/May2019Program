package com.mastek.training.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="JPA_Project")
@Component
@Scope("prototype") // one copy for each test case
public class Project {

	private int projectId;
	private String name;
	private String customerName;
	
	//Many to Many
	private Set<Employee> team = new HashSet<>();
	
	
	//Many to Many - configuring the association for both the entities Employee and Project
	//mapped by - check the configuration for Many to Many association in Employee class getAssignments() method
	@ManyToMany(mappedBy="assignments")
	public Set<Employee> getTeam() {
		return team;
	}
	public void setTeam(Set<Employee> team) {
		this.team = team;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", customerName=" + customerName + "]";
	}
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
}
