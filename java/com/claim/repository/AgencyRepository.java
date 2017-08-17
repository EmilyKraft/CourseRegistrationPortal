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
import com.claim.entity.User;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, String>{

	@Query("SELECT A from Agency A where A.agencyID=:agencyID")
	public Agency findAgencyByID(@Param("agencyID") int agencyID);
	
}
