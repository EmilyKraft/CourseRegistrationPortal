package com.claim.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//
//import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {
	
	
	//@Pattern(regexp = "([a-zA-Z0-9]+([ ][a-zA-Z0-9])*)+",message="First Name Required")
	@Column(name="firstName")
	private String firstName;
	//@Pattern(regexp = "([a-zA-Z0-9]+([ ][a-zA-Z0-9])*)+",message="Last Name Required")
	@Column(name="lastName")
	private String lastName;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userID", updatable=false, nullable=false)
	private int userID;
	
	//@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="Invalid Email Use - Format abc123@gmail.com")
	@Column(name="email")
	private String email;
	//@Size(min=8, max=15,message="The length must be between {min} and {max}")
	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="agencyID")
	private int agencyID;
	
	@OneToOne
	@JoinColumn(name="agencyID", insertable=false, updatable=false)
	private Agency agency;
	
	public User(){}

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

	public String getPassword() throws Exception {
		return password;
	}

	public void setPassword(String password) throws Exception {
		this.password = AESencrp.encrypt(password);
	}
	
	
	
	public String toString(){
		return firstName + " " + lastName + " " + email + " " + password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public int getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}
}
