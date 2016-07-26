package com.niit.shoppingcartbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class User {

private String id;

private String name;

private String rollnum ;

private String mobile;

private String location;

@Id
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getRollnum() {
	return rollnum;
}

public void setRollnum(String rollnum) {
	this.rollnum = rollnum;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}
}


