package com.tutorial.employeedemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
//@DiscriminatorValue("Macintosh")
public class MacLaptop extends Laptop {

	private String commandButton;
}
