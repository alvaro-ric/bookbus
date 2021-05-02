/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeneralDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Journey;
import model.Passenger;
import model.Ticket;
import model.TicketStatus;

/**
 *
 * @author Philip
 */
@WebServlet(name = "PassengerControl", urlPatterns = {"/PassengerControl"})
public class PassengerControl extends HttpServlet {

    GeneralDao<Passenger> passengerDao = new GeneralDao<>();
    GeneralDao<Journey> journeyDao = new GeneralDao<>();
    GeneralDao<Ticket> ticketDao = new GeneralDao<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        switch (action) {
            case "payticket":
                Passenger passenger = (Passenger) session.getAttribute("passenger");
                Journey journey = (Journey) session.getAttribute("journey");

                passengerDao.create(passenger);
                
                Ticket ticket = new Ticket();
                ticket.setAmount(journey.getPrice());

                java.util.Date date = new java.util.Date();
                Timestamp ts = new Timestamp(date.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ticket.setBoughtOn(Timestamp.valueOf(formatter.format(ts)));

                ticket.setJourney(journey);
                ticket.setPassenger(passenger);
                ticket.setTicketStatus(TicketStatus.UNUSED);
                ticket.setCompany(journey.getCompany());
                ticketDao.create(ticket);
                journey.setTaken(journey.getTaken()+1);
                journeyDao.update(journey);
                response.sendRedirect("confirmpayment.jsp");
                break;
            default:
                System.out.println("no action specified");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        switch (action) {
            case "addpassenger":
                Passenger passenger = new Passenger();
                passenger.setFirstName(request.getParameter("firstname"));
                passenger.setLastName(request.getParameter("lastname"));
                passenger.setPhoneNumber(request.getParameter("phonenumber"));
                session.setAttribute("passenger", passenger);
                response.sendRedirect("ticketpayment.jsp");
                break;
            case "payticket":
                passenger = (Passenger) session.getAttribute("passenger");
                Journey journey = (Journey) session.getAttribute("journey");

                passengerDao.create(passenger);
                journeyDao.create(journey);
                Ticket ticket = new Ticket();
                ticket.setAmount(journey.getPrice());

                java.util.Date date = new java.util.Date();
                Timestamp ts = new Timestamp(date.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ticket.setBoughtOn(Timestamp.valueOf(formatter.format(ts)));

                ticket.setJourney(journey);
                ticket.setPassenger(passenger);
                ticket.setTicketStatus(TicketStatus.UNUSED);
                ticketDao.create(ticket);
                response.sendRedirect("confirmpayment.jsp");
                break;
            default:
                System.out.println("no action specified");

        }

    }

}
