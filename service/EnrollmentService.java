package com.claim.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.entity.Course;
import com.claim.entity.CourseOffering;
import com.claim.entity.Enrollment;
import com.claim.entity.Invoice;
import com.claim.entity.User;
import com.claim.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Autowired
	private EnrollmentService courseOfferingRepository;

	private static final String courseListQuery="select C.* from courses C";
	private static final String courseOfferingQuery="select C.* from courseOfferings C";
	private static final String trainerCoursesQuery="select C.* from courseOfferings C where C.trainerID=:userID";
	private static final String invoiceEnrollmentQuery="SELECT E.* FROM enrollments as E INNER JOIN courseOfferings as C on C.courseOfferingID=E.courseOfferingID INNER JOIN users as U on U.userID=E.userID WHERE U.agencyID =:agencyID AND C.dateOffered LIKE :date AND E.attendance=1";
	private static final String upcomingUserEnrollmentQuery="SELECT E.* FROM enrollments E INNER JOIN courseOfferings as C on C.courseofferingID=E.courseOfferingID WHERE E.userID=:userID and C.dateOffered > NOW ORDER BY dateOffered";
	private static final String priorUserEnrollmentQuery="SELECT E.* FROM enrollments E INNER JOIN courseOfferings as C on C.courseofferingID=E.courseOfferingID WHERE E.userID=:userID and C.dateOffered < NOW and E.attendance=1 ORDER BY dateOffered";
	private static final String deleteEnrollmentQuery="DELETE E FROM enrollments E where E.enrollmentID=:enrollmentID";
	private static final String checkExistingEnrollmentQuery = "Select E.* from enrollments E where E.userID=:userID AND E.courseOfferingID=:courseOfferingID";
	private static final String updateAttendanceQuery = "update enrollments as E set attendance = 1 where E.enrollmentID=:enrollmentID";
	
	@Transactional
	public List<Course> getCourses(){
		return (List<Course>) entityManager.createNativeQuery(courseListQuery, Course.class)
				.getResultList();
	}
	
	@Transactional
	public List<CourseOffering> getCourseOfferings(){
		return (List<CourseOffering>) entityManager.createNativeQuery(courseOfferingQuery, CourseOffering.class)
				.getResultList();
	}
	

	
	@Transactional
	public void save(Enrollment newEnrollment){
		enrollmentRepository.save(newEnrollment);
	}
	
//	public List<CourseOffering> getTrainerCourses(User user){
//		return courseOfferingRepository.getTrainerCourses(user.getUserID());
//	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Enrollment> getUpcomingUserCourses(User user){
//		try{
//			return (List<Enrollment>) entityManager.createNativeQuery(upcomingUserEnrollmentQuery, Enrollment.class)
//				.setParameter("userID", user.getUserID())
//				.getResultList();
//		}
//		catch (NoResultException e){
//			return null;
//		}
		return enrollmentRepository.getUpcomingUserEnrollments(user.getUserID());
	}

	@Transactional
	public List<Enrollment> getCourseEnrollments(int courseOfferingID) {
		return enrollmentRepository.getCourseEnrollments(courseOfferingID);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Enrollment> getInvoiceEnrollments(String date, Invoice newInvoice) {
		
		return (List<Enrollment>) entityManager.createNativeQuery(invoiceEnrollmentQuery, Enrollment.class)
				.setParameter("agencyID", newInvoice.getAgencyID())
				.setParameter("date", date)
				.getResultList();
	}

	@Transactional
	public void cancelEnrollment(int enrollmentID) {
		entityManager.createNativeQuery(deleteEnrollmentQuery, Enrollment.class)
		.setParameter("enrollmentID", enrollmentID);
	}

	@Transactional
	public boolean checkForExistingEnrollment(int userID, int courseOfferingID) {
		try{
			Enrollment check = (Enrollment) entityManager.createNativeQuery(checkExistingEnrollmentQuery, Enrollment.class)
					.setParameter("userID", userID)
					.setParameter("courseOfferingID", courseOfferingID)
					.getSingleResult();
			return true;
			}
		catch(NoResultException e){
			return false;
		}

	}
	
	@Transactional
	public void submitAttendance(List<String> enrollmentsPresent) {
		for (String id : enrollmentsPresent){
			entityManager.createNativeQuery(updateAttendanceQuery, Enrollment.class)
			.setParameter("enrollmentID", Integer.parseInt(id))
			.executeUpdate();
		}
	}
	
	@Transactional
	public List<Enrollment> getPriorUserEnrollments(User user){
//		try{
//			return (List<Enrollment>) entityManager.createNativeQuery(priorUserEnrollmentQuery, Enrollment.class)
//				.setParameter("userID", user.getUserID())
//				.getResultList();
//		}
//		catch (NoResultException e){
//			return null;
//		}
		return enrollmentRepository.getPriorUserEnrollments(user.getUserID());
	}

	@Transactional
	public Enrollment getEnrollmentByID(int enrollmentID) {
		return enrollmentRepository.findOne(enrollmentID);
	}
	
}

		

