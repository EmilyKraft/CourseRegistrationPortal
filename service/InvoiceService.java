package com.claim.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.entity.Enrollment;
import com.claim.entity.Invoice;

import com.claim.repository.InvoiceRepository;


@Service
public class InvoiceService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	private static final String updatePaymentStatusQuery = "update invoices as I set paymentStatus = 1 where I.invoiceID=:invoiceID";
	private static final String checkExistingInvoiceQuery = "Select I.* from invoices I where I.agencyID=:agencyID AND I.invoiceDate=:invoiceDate";
	
	@Transactional
	public List<Invoice> getUnpaidInvoices(){
		return invoiceRepository.getUnpaidInvoices();
	}
	
	@Transactional
	public void save(Invoice newInvoice){
		invoiceRepository.save(newInvoice);
	}
	
	public double getInvoiceTotal(List<Enrollment> enrollments){
		double total = 0;
		for (int i = 0; i < enrollments.size(); i++){
			total += enrollments.get(i).getCourseOffering().getCourse().getPrice();
		}	
		return total;
	}

//	@Transactional
//	public boolean checkForExistingInvoice(int agencyID, String invoiceDate) {
//		if (invoiceRepository.checkForExistingInvoice(agencyID, invoiceDate).equals(null)){
//			return false;
//		}
//		else{
//			return true;
//		}
//	}
	
	@Transactional
	public boolean checkForExistingInvoice(int agencyID, String invoiceDate) {
		try{
			Invoice check = (Invoice) entityManager.createNativeQuery(checkExistingInvoiceQuery, Invoice.class)
					.setParameter("agencyID", agencyID)
					.setParameter("invoiceDate", invoiceDate)
					.getSingleResult();
			return true;
			}
		catch(NoResultException e){
			return false;
		}

	}

	@Transactional
	public void processPayments(List<String> invoiceIDS) {
		for (String id : invoiceIDS){
			entityManager.createNativeQuery(updatePaymentStatusQuery, Invoice.class)
			.setParameter("invoiceID", Integer.parseInt(id))
			.executeUpdate();
		}
	}

	@Transactional
	public Invoice findInvoiceByID(int invoiceID) {
		return invoiceRepository.findOne(invoiceID);
	}
}
	
	