/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeneralDao;
import dao.JourneyDao;
import dao.RouteDao;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Journey;
import model.JourneyStatus;
import model.ManagerAccount;
import model.Route;

/**
 *
 * @author Philip
 */
@WebServlet(name = "JourneyControl", urlPatterns = {"/JourneyControl"})
public class JourneyControl extends HttpServlet {

    GeneralDao<Route> routeDao = new GeneralDao<>();
    GeneralDao<Journey> journeyDao = new GeneralDao<>();
    Journey journey;
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        switch (action) {
            case "search":
                RouteDao routedao = new RouteDao();
                String from = request.getParameter("from");
                String to = request.getParameter("to");
                System.out.println(from + " : " + to);
                Route route = routedao.findRoute(from, to);
                try {
                    System.out.println("is:" + route.getSource());
                } catch (NullPointerException e) {
                    request.setAttribute("message", "We do not operate in such route");
                    dispatcher = request.getRequestDispatcher("availablejourneys.jsp");
                    dispatcher.forward(request, response);
                }

                JourneyDao journeydao = new JourneyDao();
                List<Journey> journeys = journeydao.availableJourneys(route.getId());
                if (journeys.size() > 0) {
                    session.setAttribute("journeys", journeys);
                    response.sendRedirect("availablejourneys.jsp");
                } else {
                    request.setAttribute("message", "There is no journey available for that route");
                    dispatcher = request.getRequestDispatcher("availablejourneys.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            case "proceed":
                Long id = Long.parseLong(request.getParameter("id"));
                journey = journeyDao.findOne(Journey.class, id);
                session.setAttribute("journey", journey);
                response.sendRedirect("passenger.jsp");
            default:
                System.out.println("no action specified");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm");
        String action = request.getParameter("action");

        switch (action) {
            case "addjourney":
                Route route = routeDao.findOne(Route.class, Long.parseLong(request.getParameter("route")));
                ManagerAccount account = (ManagerAccount) session.getAttribute("user");
                journey = new Journey();
                journey.setCompany(account.getCompany());
                journey.setRoute(route);

                Timestamp ts = new Timestamp(new java.util.Date().getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                journey.setCreatedAt(Timestamp.valueOf(formatter.format(ts)));

                journey.setJourneyStatus(JourneyStatus.valueOf(request.getParameter("journeystatus")));
                journey.setPlateNo(request.getParameter("plateno"));
                journey.setPrice(Double.parseDouble(request.getParameter("price")));
                journey.setSeats(Integer.parseInt(request.getParameter("seats")));
                journey.setTaken(0);

                journey.setDepartureDate(Date.valueOf(request.getParameter("departuredate")));
                try {
                    journey.setDepartureTime(sdftime.parse(request.getParameter("departuretime")));
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }

                journeyDao.create(journey);
                request.setAttribute("message", "journey added successfully!!!");
                dispatcher = request.getRequestDispatcher("addjourney.jsp");
                dispatcher.forward(request, response);
                break;
            case "updateroute":
                route = routeDao.findOne(Route.class, Long.parseLong(request.getParameter("id")));
                route.setSource(request.getParameter("source"));
                route.setDestination(request.getParameter("destination"));
                routeDao.update(route);
                request.setAttribute("message", "route updated successfully!!!");
                dispatcher = request.getRequestDispatcher("routes.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                System.out.println("no action specified");
        }
    }

}
