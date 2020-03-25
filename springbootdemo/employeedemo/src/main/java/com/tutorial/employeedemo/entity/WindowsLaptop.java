package com.tutorial.employeedemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
//@DiscriminatorValue("Windows")
public class WindowsLaptop extends Laptop {
	
	private String controlButton;

}
