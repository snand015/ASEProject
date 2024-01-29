package com.community.exchange.skill.DAO;

import org.springframework.stereotype.Component;

@Component
public class Profile {
private String userName;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Skill getSkillSet() {
	return skillSet;
}
public void setSkillSet(Skill skillSet) {
	this.skillSet = skillSet;
}
private String firstName;
private String lastName;
private String address;
private Skill skillSet;
private String email;
private String msg;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
}
