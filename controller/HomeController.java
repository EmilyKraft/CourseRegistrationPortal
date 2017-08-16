package com.claim.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.claim.entity.Agency;
import com.claim.entity.Course;
import com.claim.entity.CourseOffering;
import com.claim.entity.Enrollment;
import com.claim.entity.Invoice;
import com.claim.entity.User;
import com.claim.repository.UserRepository;
import com.claim.service.AgencyService;
import com.claim.service.CourseService;
import com.claim.service.EnrollmentService;
import com.claim.service.InvoiceService;
import com.claim.service.SendMail;
import com.claim.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	EnrollmentService enrollmentService;
	
	@Autowired
	AgencyService agencyService;
	
	@Autowired
	SendMail sendEmail;
	private final static String welcomeSubject = "Thanks for Signing Up";
	private final static String welcomeMessage = "Hello there!\n\nWe're so glad you decided to create an account. Please take a look at the courses we have available. Spaces fill up quickly, so don't wait too long to register!";
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(Model model) {
		List<Agency> agencyList = agencyService.getAllAgencies();
		model.addAttribute("agencyList", agencyList);
		System.out.println("In registration page redirection controller");
		return new ModelAndView("register", "userSignUp", new User());
	}
	
	@RequestMapping(value = "/submitRegistrationForm", method = RequestMethod.POST)
	public ModelAndView handleRegistration(Model model, @ModelAttribute("userRegistration") User newPerson){
		newPerson.setRole("Student");
		userService.save(newPerson);
		sendEmail.sendMail(newPerson.getEmail(), welcomeSubject, welcomeMessage);
		return signIn(model);
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public ModelAndView signIn(Model model) {
		System.out.println("In sign in page redirection controller");
		return new ModelAndView("signIn", "userLogin", new User());
	}
	
	@RequestMapping(value="/submitLoginForm", method=RequestMethod.POST)
	public String handleLogin(Model model, @ModelAttribute("userLogin") User loginPerson, HttpSession session) throws Exception{
		User user = this.userService.login(loginPerson.getEmail(), loginPerson.getPassword());
		if (user.equals(null)){
			model.addAttribute("loginError", "Email or password is invalid.");
			return "signIn";
		}
		else {
			session.setAttribute("loggedInUser", user);
			if (user.getRole().equals("Trainer")){
				session.setAttribute("sideCourseList", courseService.getTrainerCourses(user));
				return "adminPortal";
			}
			else{
				return "userPortal";
			}
		}
	}
	
	@RequestMapping(value = "/availableCourses", method = RequestMethod.GET)
	public String courseListing(Model model) {
		System.out.println("In registration page redirection controller");
		return "availableCourses";
	}
	
	
	@RequestMapping(value = "/submitNewCourseOffering", method = RequestMethod.POST)
	public ModelAndView submitNewCourseOffering(Model model, @ModelAttribute("newCourseOffering") CourseOffering newCourseOffering) {
		newCourseOffering.setAttendanceSubmitted(false);
		courseService.save(newCourseOffering);
		System.out.println("In submit new course offering controller");
		model.addAttribute("successMsg", "Course successfully added to schedule");
		model.addAttribute("courseList", courseService.getCourses());
		return new ModelAndView("scheduleCourse", "newCourseOffering", new CourseOffering());
	}
	
	@RequestMapping(value = "/scheduleCourse", method = RequestMethod.GET)
	public ModelAndView scheduleNewCourseOffering(Model model, HttpSession session) {
		System.out.println("In redirect new course controller");
		List<Course> courseList = courseService.getCourses();
		model.addAttribute("courseList", courseList);
		session.setAttribute("sideCourseList", courseService.getTrainerCourses((User)session.getAttribute("loggedInUser")));
		return new ModelAndView("scheduleCourse", "newCourseOffering", new CourseOffering());
	}
	
	@RequestMapping(value = "/upcomingCourses", method = RequestMethod.GET)
	public ModelAndView viewUpcoming(Model model) {
		List<CourseOffering> courses = courseService.getAllCourseOfferings();
		model.addAttribute("courses", courses);
		System.out.println("In redirect upcoming courses controller");
		return new ModelAndView("upcomingCourses", "newEnrollment", new Enrollment());
	}
	
	@RequestMapping(value = "/submitEnrollment", method = RequestMethod.POST)
	public ModelAndView submitEnrollment(Model model, @ModelAttribute("newEnrollment") Enrollment newEnrollment) {
		boolean alreadyExists = enrollmentService.checkForExistingEnrollment(newEnrollment.getUserID(), newEnrollment.getCourseOfferingID());
		if (alreadyExists){
			model.addAttribute("alreadyExistsMsg", "You have already enrolled in this course. Please select another course");
			return viewUpcoming(model);
		}
		else{
		enrollmentService.save(newEnrollment);
		System.out.println("In submit new enrollment controller");
		model.addAttribute("successMsg", "Enrollment successfully submitted");
		List<CourseOffering> courses = courseService.getAllCourseOfferings();
		model.addAttribute("courses", courses);
		return new ModelAndView("upcomingCourses", "newEnrollment", new Enrollment());
		}
	}
	
	@RequestMapping(value = "/cancelCourseOffering", method = RequestMethod.GET)
	public String sendCancellationMessage(@RequestParam("courseOfferingID") int courseOfferingID, Model model, HttpSession session) {
		System.out.println("In course cancellation controller");
		System.out.println(courseOfferingID);
		   courseService.courseCancellation(courseOfferingID);
		   session.setAttribute("sideCourseList", courseService.getTrainerCourses((User)session.getAttribute("loggedInUser")));
			return viewUpcomingSchedule(model, session);
	}
	
	@RequestMapping(value = "/sendReminder", method = RequestMethod.GET)
	public String submitReminder(@RequestParam("courseOfferingID") int courseOfferingID, Model model, HttpSession session) {
		System.out.println("In reminder controller");
		System.out.println(courseOfferingID);
	   courseService.sendReminderText(courseOfferingID);
		return viewUpcomingSchedule(model, session);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return index();
	}
	
	@RequestMapping(value = "/upcomingSchedule", method = RequestMethod.GET)
	public String viewUpcomingSchedule(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		List<CourseOffering> courses = courseService.getTrainerCourses(user);
		model.addAttribute("courses", courses);
		System.out.println("In redirect upcoming courses controller");
		return "upcomingSchedule";
	}
	
	//controller to get new course creation page
	@RequestMapping(value = "/newCourse", method = RequestMethod.GET)
	public ModelAndView newCoursePage(Model model) {
		System.out.println("In redirect new course controller");
		return new ModelAndView("newCourse", "newCourse", new Course());
	}
	
	//controller to submit data from new course creation page
	@RequestMapping(value = "/submitNewCourse", method = RequestMethod.GET)
	public ModelAndView submitNewCourse(Model model, @ModelAttribute Course newCourse) {
		System.out.println("In redirect new course controller");
		courseService.save(newCourse);
		model.addAttribute("successNewCourseMsg", "Course successfully created");
		return newCoursePage(model);
	}
	
	//controller to show student all the courses he or she is enrolled in
	@RequestMapping(value = "/viewUserEnrollments", method = RequestMethod.GET)
	public String viewUserEnrollments(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		List<Enrollment> enrollmentList = enrollmentService.getUpcomingUserCourses(user);
		System.out.println(enrollmentList);
		model.addAttribute("enrollmentList", enrollmentList);
		System.out.println("In redirect view enrollments controller");
		return "viewUserEnrollments";
	}
	
	//controller to show student all the courses he or she attended
	@RequestMapping(value = "/viewUserHistory", method = RequestMethod.GET)
	public String viewUserHistory(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		List<Enrollment> enrollmentList = enrollmentService.getPriorUserEnrollments(user);
		System.out.println(enrollmentList);
		model.addAttribute("enrollmentList", enrollmentList);
		System.out.println("In redirect view enrollments controller");
		return "viewUserHistory";
	}
		
	//controller for trainer to view enrollments and mark attendance
	@RequestMapping(value = "/viewEnrollments", method = RequestMethod.GET)
	public String viewCourseEnrollments(@RequestParam("cID") int courseOfferingID, Model model, HttpSession session) {
		System.out.println("In redirect view course enrollments controller");
		System.out.println(courseOfferingID);
		List<Enrollment> courseEnrollmentList = enrollmentService.getCourseEnrollments(courseOfferingID);
		System.out.println(courseEnrollmentList);
		model.addAttribute("courseEnrollmentList", courseEnrollmentList);
		model.addAttribute("thisCourse", courseService.getCourseOfferingByID(courseOfferingID));
		return "viewEnrollments";
	}
	
	//controller to get to unpaid invoice table
	@RequestMapping(value="/viewOutstanding", method=RequestMethod.GET)
	public String viewOutstanding(Model model){
		System.out.println("In redirect view unpaid invoices controller");
		List<Invoice> unpaidInvoices = invoiceService.getUnpaidInvoices();
		model.addAttribute("unpaidInvoices", unpaidInvoices);
		return "viewOutstanding";
	}
	
	@RequestMapping(value = "/generateInvoice", method = RequestMethod.GET)
	public ModelAndView generateInvoices(Model model) {
		System.out.println("In redirect generate invoice controller");
		List<Agency> agencyList = agencyService.getAllAgencies();
		model.addAttribute("agencyList", agencyList);
		return new ModelAndView("generateInvoice", "newInvoice", new Invoice());
	}
	
	@RequestMapping(value = "/createNewInvoice", method = RequestMethod.POST)
	public ModelAndView createInvoice(Model model, @ModelAttribute("newInvoice") Invoice newInvoice, @RequestParam("month") String month, @RequestParam("year") String year) {
		System.out.println("In redirect generate invoice controller");
		List<Enrollment> enrollments = enrollmentService.getInvoiceEnrollments(year+ "-" + month + "-__", newInvoice);
		if (enrollments.isEmpty()){
			model.addAttribute("noEnrollmentsMsg", "This agency has no enrollments for this month");
			return generateInvoices(model);
		}
		else {	
			String invoiceDate = month+"/"+year;
			if (invoiceService.checkForExistingInvoice(newInvoice.getAgencyID(), invoiceDate)){
				model.addAttribute("duplicateMsg", "This invoice already exists");
				return generateInvoices(model);
			}
		newInvoice.setInvoiceDate(invoiceDate);
		newInvoice.setInvoiceEnrollments(enrollments);
		newInvoice.setAgency(agencyService.getAgencyByID(newInvoice));
		newInvoice.setTotal(invoiceService.getInvoiceTotal(enrollments));
		invoiceService.save(newInvoice);
		return new ModelAndView("invoice", "newInvoice", newInvoice);
	}
}
	
	//cancel course enrollment on user side
	@RequestMapping(value = "/cancelUserEnrollment", method = RequestMethod.POST)
	public String cancelUserEnrollment(@RequestParam("enrollmentID") int enrollmentID, Model model, HttpSession session) {
		System.out.println("In redirect cancel user enrollments controller");
		System.out.println(enrollmentID);
		enrollmentService.cancelEnrollment(enrollmentID);
		return viewUserEnrollments(model, session);
	}
	
	//controller for process payments on outstanding invoice page
	@RequestMapping(value = "/processPaid", method = RequestMethod.POST)
	public String viewCourseEnrollments(@RequestParam("invoiceIDS") List<String> invoiceIDS, Model model, HttpSession session) {
		System.out.println("In process payments controller");
		System.out.println(invoiceIDS.size());
		invoiceService.processPayments(invoiceIDS);
		return viewOutstanding(model);
	}
	
	//controller to re-view generated invoice
	@RequestMapping(value="/reviewInvoice", method=RequestMethod.GET)
	public ModelAndView reviewInvoice(@RequestParam("invoiceID") int invoiceID, Model model){
		Invoice newInvoice = invoiceService.findInvoiceByID(invoiceID);
		String month = newInvoice.getInvoiceDate().substring(0,2);
		String year = newInvoice.getInvoiceDate().substring(3,7);
		List<Enrollment> enrollments = enrollmentService.getInvoiceEnrollments(year+ "-" + month + "-__", newInvoice);
		newInvoice.setInvoiceEnrollments(enrollments);
		return new ModelAndView("invoice", "newInvoice", newInvoice);	
	}
	
	//controller for submitting attendance
	@RequestMapping(value = "/submitAttendance", method = RequestMethod.POST)
	public String submitAttendance(@RequestParam("enrollmentsPresent") List<String> enrollmentsPresent, @RequestParam("courseOfferingID") int courseOfferingID, Model model, HttpSession session) {
		System.out.println("In attendance submitting controller");
		System.out.println(enrollmentsPresent.size());
		enrollmentService.submitAttendance(enrollmentsPresent);
		CourseOffering course = courseService.getCourseOfferingByID(courseOfferingID);
		course.setAttendanceSubmitted(true);
		courseService.save(course);
		session.setAttribute("sideCourseList", courseService.getTrainerCourses((User)session.getAttribute("loggedInUser")));
		return "adminPortal";
	}
	
	//controller to get course certificate
	@RequestMapping(value="/getCertificate", method=RequestMethod.GET)
	public String getCertificate(@RequestParam("eID") int enrollmentID, Model model){
		model.addAttribute("enrollment", enrollmentService.getEnrollmentByID(enrollmentID));
		return "certificate";
	}
}
