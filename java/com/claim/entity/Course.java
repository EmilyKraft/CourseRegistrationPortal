package com.claim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;




@Entity
@Table(name="courses")
public class Course {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="courseID")
		private Integer courseID;
		
		@Column(name="courseTitle")
		private String courseTitle;

	    @Column(name="price")
	    private double price;
	    
		@Column(name="skillset")
		private String skillset;
		
		@Column(name="description")
		private String courseDescription;
		
		public Course() {}

		public Integer getCourseID() {
			return courseID;
		}

		public void setCourseID(Integer courseID) {
			this.courseID = courseID;
		}

		public String getCourseTitle() {
			return courseTitle;
		}

		public void setCourseTitle(String courseTitle) {
			this.courseTitle = courseTitle;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getSkillset() {
			return skillset;
		}

		public void setSkillset(String skillset) {
			this.skillset = skillset;
		}

		public String getCourseDescription() {
			return courseDescription;
		}

		public void setCourseDescription(String courseDescription) {
			this.courseDescription = courseDescription;
		}

		@Override
		public String toString() {
			return "courseID=" + courseID + ", courseTitle=" + courseTitle + ", price=" + price + ", skillset=" + skillset + ", courseDescription=" + courseDescription;
		}

		
		

		
}
