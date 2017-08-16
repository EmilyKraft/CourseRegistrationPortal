package com.claim.entity;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Data
@Entity
@Table(name="courseOfferings")
public class CourseOffering {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="courseOfferingID")
	private int courseOfferingID;
	
	@Column(name="trainerID")
	private int trainerID;
	
	@Column(name="courseID")
	private int courseID;

	@Column(name="streetAddress")
	private String streetAddress;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="dateOffered")
	@Temporal(TemporalType.DATE)
	private Date dateOffered;
	
	@Column(name="courseTime")
	private String courseTime;
	
	@OneToOne
	@JoinColumn(name="courseID", insertable=false, updatable=false)
	private Course course;
	
	@Column(name="attendanceSubmitted")
	private boolean attendanceSubmitted;
	
	
	public CourseOffering(){}

	public int getCourseOfferingID() {
		return courseOfferingID;
	}

	public void setCourseOfferingID(int courseOfferingID) {
		this.courseOfferingID = courseOfferingID;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public Date getDateOffered() {
	      return dateOffered;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDateOffered(Date dateOffered) {
		this.dateOffered = dateOffered;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public boolean isAttendanceSubmitted() {
		return attendanceSubmitted;
	}

	public void setAttendanceSubmitted(boolean attendanceSubmitted) {
		this.attendanceSubmitted = attendanceSubmitted;
	}
	

}
