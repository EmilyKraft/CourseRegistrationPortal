package com.claim.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="enrollments")
public class Enrollment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enrollmentID")
	private int enrollmentID;
	
	@Column(name="courseOfferingID")
	private int courseOfferingID;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="attendance")
	private String attendance;
	
	@Column(name="enrollmentDate")
	@CreationTimestamp
	private Timestamp enrollmentDate;
	
	@Column(name="cancellationDate")
	@CreationTimestamp
	private Timestamp cancellationDate;
	
	@OneToOne
	@JoinColumn(name="userID", insertable=false, updatable=false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="courseOfferingID", insertable=false, updatable=false)
	private CourseOffering courseOffering;
	
	public Enrollment(){}

	public int getEnrollmentID() {
		return enrollmentID;
	}

	public void setEnrollmentID(int enrollmentID) {
		this.enrollmentID = enrollmentID;
	}

	public int getCourseOfferingID() {
		return courseOfferingID;
	}

	public void setCourseOfferingID(int courseOfferingID) {
		this.courseOfferingID = courseOfferingID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public Timestamp getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Timestamp enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Timestamp getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(Timestamp cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CourseOffering getCourseOffering() {
		return courseOffering;
	}

	public void setCourseOffering(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}
	
	
}
