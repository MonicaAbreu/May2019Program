package com.mastek.training.hrapp;

import static org.junit.Assert.assertNotNull;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastek.training.hrapp.apis.DepartmentService;

import com.mastek.training.hrapp.entities.Department;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentApplicationTests {
	
	@Autowired
	DepartmentService departmentService;
	
	//@Autowired
	//Department dept;
	

	@Test
	public void exampleDepartmentTest() {
		System.out.println("Department Test case scenarios");
	}
	
	@Test
	public void addDepartmentUsingService() {
		Department dept = new Department();
		//dept.setDeptno(1);;
		dept.setLocation("Location Example");
		dept.setName("Department Name");
		dept = departmentService.registerOrUpdateDepartment(dept);
		assertNotNull(dept);
	}
	
	@Test 
	public void findByDepartmentNoUsingService() {
		int departmentno = 3;
		assertNotNull(departmentService.findByDeptno(departmentno));
	}
	
/*	@Test
	public void deleteByDepartmentNoUsingService() {
		int departmentno = 1;
		departmentService.deleteByEmpno(departmentno);
		assertNull(departmentService.findByDeptno(departmentno));
	}*/
}


