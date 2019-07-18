package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component

@Entity
@Table(name="JPA_Project")
@Scope("prototype") // one copy for each test case
@XmlRootElement
public class Project implements Serializable {

	private int projectId;
	
	@FormParam("name")
	private String name;
	
	@FormParam("customerName")
	private String customerName;
	
	//Many to Many
	private Set<Employee> team = new HashSet<>();
	
	
	//Many to Many - configuring the association for both the entities Employee and Project
	//mapped by - check the configuration for Many to Many association in Employee class getAssignments() method
	@ManyToMany(mappedBy="assignments")
	@XmlTransient //ignore the collections while using api
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
