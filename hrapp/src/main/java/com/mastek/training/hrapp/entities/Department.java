package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component

@Entity
@Table(name="JPA_Department")
@Scope("prototype") // one copy for each test case

@XmlRootElement
public class Department implements Serializable{

	private int deptno;
	
	@FormParam("name")
	private String name;
	
	@FormParam("location")
	private String location;
	
	//One to Many - One department -> Many employees
	private Set<Employee> members = new HashSet<>();
	
	//One to Many
	//used on the get method of set to configure association
	//fetch lazy: delay the initialisation until method getMembers()is called [default option]
	///////eager: initialise the collection on entity 
	//cascade: all the entity operation done on Department would be performed on each associated employee object
	////all[persist, merge, delete, refresh]
	//mappedBy: identifies the property name in child class where the join column(aka FK) configuration is present
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="currentDepartment")
	@XmlTransient //ignore the collections while using api
	public Set<Employee> getMembers() {
		return members;
	}

	public void setMembers(Set<Employee> members) {
		this.members = members;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
