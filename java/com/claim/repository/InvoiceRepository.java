package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.Agency;
import com.claim.entity.Course;
import com.claim.entity.CourseOffering;
import com.claim.entity.Enrollment;
import com.claim.entity.Invoice;
import com.claim.entity.User;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

	@Query("Select I from Invoice I where I.paymentStatus=0")
	public List<Invoice> getUnpaidInvoices();

	@Query("Select I from Invoice I where I.agencyID=:agencyID AND I.invoiceDate=:invoiceDate")
	public List<Invoice> checkForExistingInvoice(@Param("agencyID") int agencyID, @Param("invoiceDate") String invoiceDate);

}
