package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.CourseOffering;
import com.claim.entity.Enrollment;
import com.claim.entity.Invoice;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

//	@Query("Select U from User U where U.email=:email and U.password=:password")
//	public User login(@Param("email") String email, @Param("password") String password);
	
//	@Query("Select E from Enrollment E where E.userID=:userID AND E.courseOffering.")
//	public List<Enrollment> getUpcomingUserEnrollments(@Param("userID") int userID);

	@Query("Select E from Enrollment E where E.courseOfferingID=:courseOfferingID")
	public List<Enrollment> getCourseEnrollments(@Param("courseOfferingID") int courseOfferingID);

	@Query("Select E from Enrollment E where E.userID=:userID AND E.courseOfferingID=:courseOfferingID")
	public List<Invoice> checkForExistingEnrollment(@Param("userID") int userID, @Param("courseOfferingID") int courseOfferingID);

	@Query("Select E from Enrollment E where E.userID=:userID and E.courseOffering.dateOffered >= NOW() ORDER BY dateOffered")
	public List<Enrollment> getUpcomingUserEnrollments(@Param("userID") int userID);
	
	@Query("Select E from Enrollment E where E.userID=:userID and E.attendance=1 ORDER BY E.courseOffering.dateOffered")
	public List<Enrollment> getPriorUserEnrollments(@Param("userID") int userID);
}
