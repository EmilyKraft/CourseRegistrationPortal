package com.claim.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.entity.Agency;
import com.claim.entity.Course;
import com.claim.entity.CourseOffering;
import com.claim.entity.Enrollment;
import com.claim.entity.Invoice;
import com.claim.entity.User;
import com.claim.repository.AgencyRepository;
import com.claim.repository.CourseOfferingRepository;
import com.claim.repository.CourseRepository;
import com.claim.repository.EnrollmentRepository;
import com.claim.repository.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class AgencyService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private AgencyRepository agencyRepository;
	
	
	@Transactional
	public List<Agency> getAllAgencies(){
		return agencyRepository.findAll();
	}
	
	@Transactional
	public Agency getAgencyByID(Invoice newInvoice){
		return agencyRepository.findAgencyByID(newInvoice.getAgencyID());
	}
}
	
	