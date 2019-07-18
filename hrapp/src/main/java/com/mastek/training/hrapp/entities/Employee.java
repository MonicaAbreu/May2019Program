package com.mastek.training.hrapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component -> disabled for form parameter processing 

@Scope("prototype") //one copy for each test case
@Entity  //declares the class as an Entity
@Table(name="JPA_EMPLOYEE") // declaring the table name for the class
@EntityListeners({EmployeeLifecycleListener.class})
@NamedQueries({
  @NamedQuery(name="Employee.findBySalary",
   query="select e from Employee e where e.salary between :min and :max")	
})

@XmlRootElement
public class Employee implements Serializable { //manage serialization of Objects
	
	@Value("-1")
	private int empno;
	
	@Value("Default Employee")
	@FormParam("name") //name of params passed via HTML Form defined in EmployeeService line42
	private String name;
	
	@FormParam("salary")
	@Value("100.0")
	private double salary;
	
	//Many to Many
	private Set<Project> assignments = new HashSet<>();
	
	//Many to Many - configuring the association for both the entities Employee and Project
	//join table - provides all the configuration for the association table
	////name - name of the join table
	//join columns - foreign key column name for current class
	//inverse join columns - foreign key column for other class
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="JPA_ASSIGNMENTS",
				joinColumns=@JoinColumn(name="FK_EMPNO"), 
				inverseJoinColumns=@JoinColumn(name="FK_PROJECTID"))
	@XmlTransient //ignore the collections while using api
	public Set<Project> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Project> assignments) {
		this.assignments = assignments;
	}

	
	
	//Many to One - each employee belongs to one department
	private Department currentDepartment; 
	
	
	//Many to One - associating the parent class with one object
	//join column - configure the FK column for the association between two entities
	@ManyToOne
	@JoinColumn(name="FK_DepartmentId")
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}

	public Employee() {
		System.out.println("Employee Created");
	}
	
	@Id	//declare the property as Primary Key
	@Column(name="employee_number") //declare the column name 
	@GeneratedValue(strategy=GenerationType.AUTO) //Auto-numbering
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	@Column(name="employee_name",nullable=false,length=45)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() { //JPA will default configurations 
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + "]";
	}


}
