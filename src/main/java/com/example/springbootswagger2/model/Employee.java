package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Employee {

	private Long id;
	@ApiModelProperty(notes = "First Name of the Employee", name = "firstName", required = true, value = "test name")
	private String firstName;
	private String lastName;
	private String email;
	@ApiModelProperty(notes = "Mobile Number", name = "mobile", required = true, value = "8790982341")
	private String mobile;
	private Date dateOfBirth;
	@ApiModelProperty(notes = "Country of the Student",name="location",required=true,value="test location")
	private String location;

	public Employee(long id, String firstName, String lastName, String email, String mobile, String location) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.dateOfBirth = new Date();
		this.location = location;
	}

	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}