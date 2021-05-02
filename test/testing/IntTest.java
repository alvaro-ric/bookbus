/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import dao.DBUtil;
import dao.GeneralDao;
import dao.PassengerDao;
import java.util.Date;
import java.util.List;
import javax.servlet.Registration;
import model.AccountState;
import model.AdminAccount;
import model.Company;
import model.CompanyRoute;
import model.CompanyState;
import model.Gender;
import model.Journey;
import model.Manager;
import model.ManagerAccount;
import model.Passenger;
import model.Route;
import model.Status;
import model.Ticket;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Philip
 */
public class IntTest extends DBSetupConfig {
    GeneralDao<Company> studentDao = new GeneralDao<>();
    GeneralDao<CompanyRoute> comRouteDao = new GeneralDao<>();
    GeneralDao<AdminAccount> adminAccDao = new GeneralDao<>();
    GeneralDao<Manager> managerDao = new GeneralDao<>();
    GeneralDao<ManagerAccount> managerAccDao = new GeneralDao<>();
    GeneralDao<CompanyState> companyStateDao = new GeneralDao<>();
    GeneralDao<Company> companyDao = new GeneralDao<>();
    GeneralDao<Route> routeDao = new GeneralDao<>();
    GeneralDao<AccountState> accStateDao = new GeneralDao<>();
    GeneralDao<Ticket> ticketDao = new GeneralDao<>();
    GeneralDao<Passenger> passengerDao = new GeneralDao<>();
    PassengerDao passDao = new PassengerDao();
    GeneralDao<Journey> journeyDao = new GeneralDao<>();


    @BeforeTest
    public void init() {
        DBUtil.getSessionFactory();
        System.out.println("Tables created");
    }

    @BeforeMethod
    public void initializeTest() {
        executeOperation(TestData.INSERT_ADMIN_ACCOUNT);
        executeOperation(TestData.INSERT_MANAGER);
        executeOperation(TestData.INSERT_COMPANY);
        executeOperation(TestData.INSERT_COMPANY_STATE);
        executeOperation(TestData.INSERT_MANAGER_ACCOUNT);
        executeOperation(TestData.INSERT_ACCOUNT_STATE);
        executeOperation(TestData.INSERT_ROUTE);
        executeOperation(TestData.INSERT_COMPANY_ROUTE);
        executeOperation(TestData.INSERT_JOURNEY);
        executeOperation(TestData.INSERT_PASSENGER);
        executeOperation(TestData.INSERT_TICKET);
        System.out.println("test initialized");
    }

    @AfterMethod
    public void cleanTestData() {
        executeOperation(TestData.DELETE_TICKET);
        executeOperation(TestData.DELETE_PASSENGER);
        executeOperation(TestData.DELETE_JOURNEY);
        executeOperation(TestData.DELETE_COMPANY_ROUTE);
        executeOperation(TestData.DELETE_ROUTE);
        executeOperation(TestData.DELETE_ACCOUNT_STATE);
        executeOperation(TestData.DELETE_MANAGER_ACCOUNT);
        executeOperation(TestData.DELETE_COMPANY_STATE);
        executeOperation(TestData.DELETE_COMPANY);
        executeOperation(TestData.DELETE_MANAGER);
        executeOperation(TestData.DELETE_ADMIN_ACCOUNT);
        executeOperation(TestData.DELETE_TICKET);
        System.out.println("test data cleaned");
    }
    
    @Test
    public void testCreateRoute() {
        String result = routeDao.create(new Route("kayonza", "huye", Status.ACTIVE));
        Assert.assertEquals(result, "created");
        System.out.println("route created");
    }
    
    @Test
    public void testReadRoutes() {
        List<Journey> routelist = journeyDao.findAll(new Journey());
        Assert.assertEquals(routelist.size(), 2);
        System.out.println("routes viewed");
    }

    @Test
    public void testUpdateRoute() {
        Route route = routeDao.findOne(Route.class, 100L);
        route.setSource("nosource");
        String result = routeDao.update(route);
        Assert.assertEquals(result, "updated");
        System.out.println("route updated");
    }
    
    @Test
    public void testDeleteRoute() {
        Route route = routeDao.findOne(Route.class, 100L);
        String result = routeDao.delete(route);
        Assert.assertEquals(result, "deleted");
        System.out.println("route deleted");
    }
    
//    @Test(expectedExceptions = {NullPointerException.class})
//    public void testWrongCourseCode() {
//        Course course = courseDao.findOne(Course.class, "c11");
//        course.getName();
//        System.out.println("wrong course tested");
//    }

    @Test
    public void testReadTickets() {
        List<Ticket> ticketlist = ticketDao.findAll(new Ticket());
        Assert.assertEquals(ticketlist.size(), 2);
        System.out.println("tickets viewed");
    }

    @Test
    public void testUpdateTicket() {
        Ticket ticket = ticketDao.findOne(Ticket.class, 1L);
        ticket.setAmount(2000);
        String result = ticketDao.update(ticket);
        Assert.assertEquals(result, "updated");
        System.out.println("tickets updated");
    }
    
    @Test
    public void testDeleteTicket() {
        Ticket ticket = ticketDao.findOne(Ticket.class, 1L);
        String result = ticketDao.delete(ticket);
        Assert.assertEquals(result, "deleted");
        System.out.println("ticket deleted");
    }
    
    @Test
    public void testReadJourney() {
        List<Journey> journeylist = journeyDao.findAll(new Journey());
        Assert.assertEquals(journeylist.size(), 2);
        System.out.println("journeys viewed");
    }

    @Test
    public void testUpdateJourney() {
        Journey journey = journeyDao.findOne(Journey.class, 1L);
        journey.setPrice(2000);
        String result = journeyDao.update(journey);
        Assert.assertEquals(result, "updated");
        System.out.println("journey updated");
    }
    
    @Test
    public void testDeleteJourney() {
        Journey journey = journeyDao.findOne(Journey.class, 1L);
        String result = journeyDao.delete(journey);
        Assert.assertEquals(result, "deleted");
        System.out.println("Journey deleted");
    }
    
    

//    @Test
//    public void testCreateStudent() {
//        String result = studentDao.create(new Student("21100", "blue", Gender.MALE, new Date(2000, 05, 23)));
//        Assert.assertEquals(result, "success");
//        System.out.println("student created");
//    }
//    
//    @Test
//    public void testReadStudents() {
//        List<Student> studentlist = studentDao.findAll(new Student());
//        Assert.assertEquals(studentlist.size(), 3);
//        System.out.println("students viewed");
//    }
//
//    @Test
//    public void testUpdateStudent() {
//        Student student = studentDao.findOne(Student.class, "21208");
//        student.setName("philip");
//        String result = studentDao.update(student);
//        Assert.assertEquals(result, "success");
//        System.out.println("student updated");
//    }
//    
//    @Test(expectedExceptions = {NullPointerException.class})
//    public void testFindWrongStudent() {
//        Student student = studentDao.findOne(Student.class, "111111");
//        student.getName();
//        System.out.println("student not found");
//    }
//
//    @Test
//    public void testDeleteStudent() {
//        Student student = studentDao.findOne(Student.class, "21208");
//        List<Registration> registrations = registrationDao.findbyStudent(Registration.class, "21208");
//        registrations.forEach((reg) -> {
//            registrationDao.delete(reg);
//        });
//        String result = studentDao.delete(student);
//        Assert.assertEquals(result, "success");
//        System.out.println("student deleted");
//    }
//    
//    
//
//    @Test
//    public void testCreateRegistration() {
//        Student student = studentDao.findOne(Student.class, "21208");
//        Course course = courseDao.findOne(Course.class, "INSY312");
//        String result = registrationDao.create(new Registration(24L, student, course));
//        Assert.assertEquals(result, "success");
//        System.out.println("registered successfully");
//    }
//    
//    @Test
//    public void testReadRegistration() {
//        List<Registration> registrations = registrationDao.findAll(new Registration());
//        Assert.assertEquals(registrations.size(), 3);
//        System.out.println("registrations viewed");
//    }
//
//    @Test
//    public void testUpdateRegistration() {
//        Student student = studentDao.findOne(Student.class, "21179");
//        Registration registration = registrationDao.findOne(Registration.class, 24L);
//        registration.setStudent(student);
//        String result = registrationDao.update(registration);
//        Assert.assertEquals(result, "success");
//        System.out.println("registration updated");
//    }
//
//    @Test
//    public void testDeleteRegistration() {
//        Registration registration = registrationDao.findRegistration(Registration.class, 24L);
//        String result = registrationDao.delete(registration);
//        Assert.assertEquals(result, "success");
//        System.out.println("registration deleted");
//    }
//    
//    @Test(expectedExceptions = {NullPointerException.class})
//    public void testDeleteWrongRegistration() {
//        Registration registration = registrationDao.findRegistration(Registration.class, 4L);
//        registration.getCourse();
//        System.out.println("wrong registration");
//    }

}
