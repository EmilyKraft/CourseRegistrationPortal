package com.claim.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="invoices")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoiceID")
	private int invoiceID;
	
	@Column(name="total")
	private double total;
	
	@Column(name="agencyID")
	private int agencyID;
	
	@Transient
	private List<Enrollment> invoiceEnrollments;
	
	@Column(name="invoiceDate")
	private String invoiceDate;
	
	@Column(name="paymentStatus")
	private boolean paymentStatus;
	
	@OneToOne
	@JoinColumn(name="agencyID", insertable=false, updatable=false)
	private Agency agency;
	
	public Invoice(){}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}

	public List<Enrollment> getInvoiceEnrollments() {
		return invoiceEnrollments;
	}

	public void setInvoiceEnrollments(List<Enrollment> invoiceEnrollments) {
		this.invoiceEnrollments = invoiceEnrollments;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	
}
