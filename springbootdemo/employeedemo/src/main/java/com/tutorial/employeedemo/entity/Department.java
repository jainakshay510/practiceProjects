package com.tutorial.employeedemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Embeddable
public class Department {

	//@Id
	private String deptId;
	
	//@Column(name="deptName")
	private String deptName;

//	@Column(name="employeeList")
//	private List<Employee> employeeList;


}
