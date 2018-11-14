package com.tcsion.java.Project1Backend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Feedbacks implements Serializable {

	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long feedback_id;
private String user_name;
private String email;
private Long phone;
private String Feedback;

@Override
public String toString() {
	return "Feedbacks [feedback_id=" + feedback_id + ", user_name=" + user_name + ", email=" + email + ", phone="
			+ phone + ", Feedback=" + Feedback + "]";
}

public Long getFeedback_id() {
	return feedback_id;
}
public void setFeedback_id(Long feedback_id) {
	this.feedback_id = feedback_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getPhone() {
	return phone;
}
public void setPhone(Long phone) {
	this.phone = phone;
}
public String getFeedback() {
	return Feedback;
}
public void setFeedback(String feedback) {
	Feedback = feedback;
}



}
