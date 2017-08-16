package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.CourseOffering;
import com.claim.entity.Enrollment;
import com.claim.entity.Invoice;
import com.claim.entity.User;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, String>{
	
	@Query("Select C from CourseOffering C where C.trainerID=:userID and C.dateOffered >= NOW() and C.attendanceSubmitted <> 1 ORDER BY dateOffered")
	public List<CourseOffering> getTrainerCourses(@Param("userID") int userID);
	
	@Query("Select E from Enrollment E where E.courseOfferingID=:courseOfferingID")
	public List<Enrollment> getEnrollments(@Param("courseOfferingID") int courseOfferingID);
	
	@Query("Delete from Enrollment E where E.courseOfferingID=:courseOfferingID")
	public void deleteEnrollments(@Param("courseOfferingID") int courseOfferingID);
	
	@Query("Delete from CourseOffering C where C.courseOfferingID=:courseOfferingID")
	public void deleteCourseOffering(@Param("courseOfferingID") int courseOfferingID);

	@Query("Select C from CourseOffering C where C.courseOfferingID=:courseOfferingID")
	public CourseOffering getCourseOfferingByID(@Param("courseOfferingID") int courseOfferingID);
	

}
