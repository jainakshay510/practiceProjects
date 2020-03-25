package com.tutorial.employeedemo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employee {

	@Id
	private int id;
	
	@Column(name="empName")
	private String empName;
	
//	@Column(name="department")
//	@ElementCollection(fetch=FetchType.EAGER)
//	@JoinTable(name="EMPLOYEE_DEPT",joinColumns= {@JoinColumn(name="empId")})
	//@GenericGenerator(name = "sequence-gen", strategy = "increment")
	//@CollectionId(columns = { @Column(name="deptsequence") }, generator = "sequence-gen", type = @Type(type="long"))
	//private Collection<Department> listOfDepartment=new ArrayList();
	
	//@OneToMany(mappedBy="employee")
	@JoinTable(name="Employee_Laptop",
	joinColumns=@JoinColumn(name="USER_ID"),
	inverseJoinColumns=@JoinColumn(name="LAPTOP_ID"))
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Laptop> laptopList=new ArrayList();
	
	@Column(name="salary")
	private Long salary;
	
}
