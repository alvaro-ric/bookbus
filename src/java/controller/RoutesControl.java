/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeneralDao;
import dao.RouteDao;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Company;
import model.CompanyRoute;
import model.ManagerAccount;
import model.Route;
import model.RouteStatus;
import model.Status;

/**
 *
 * @author Philip
 */
@WebServlet(name = "RoutesControl", urlPatterns = {"/RoutesControl"})
public class RoutesControl extends HttpServlet {

    GeneralDao<Route> routeDao = new GeneralDao<>();
    GeneralDao<CompanyRoute> CRDao = new GeneralDao<>();
    Route route;
    CompanyRoute companyRoute;
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "request":
                RouteDao rdao = new RouteDao();
                long id = Long.parseLong(request.getParameter("id"));
                route = routeDao.findOne(Route.class, id);
                ManagerAccount account = (ManagerAccount) request.getSession().getAttribute("user");
                Company company = account.getCompany();

                boolean status = rdao.checkRouteRequest(company.getId(), id);
                System.out.println("status is :" + status);

                if (status) {
                    request.setAttribute("message", "request has been sent before!!");
                    dispatcher = request.getRequestDispatcher("requestroute.jsp");
                    dispatcher.forward(request, response);

                } else {
                    CompanyRoute companyRoute = new CompanyRoute();
                    companyRoute.setRoute(route);
                    companyRoute.setCompany(company);
                    companyRoute.setRouteStatus(RouteStatus.REQUESTED);
                    Timestamp ts = new Timestamp(new Date().getTime());
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    companyRoute.setRegisteredDate(Timestamp.valueOf(formatter.format(ts)));
                    CRDao.create(companyRoute);
                    request.setAttribute("message", "request sent!!");
                    dispatcher = request.getRequestDispatcher("requestroute.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            case "approve":
                companyRoute = CRDao.findOne(CompanyRoute.class, Long.parseLong(request.getParameter("id")));
                companyRoute.setRouteStatus(RouteStatus.APPROVED);
                CRDao.update(companyRoute);
                request.setAttribute("message", "route request is approved successfully");
                dispatcher = request.getRequestDispatcher("requestroute.jsp");
                dispatcher.forward(request, response);
                break;
            case "suspend":
                companyRoute = CRDao.findOne(CompanyRoute.class, Long.parseLong(request.getParameter("id")));
                companyRoute.setRouteStatus(RouteStatus.SUSPENDED);
                CRDao.update(companyRoute);
                request.setAttribute("message", "route is successfully suspended");
                dispatcher = request.getRequestDispatcher("requestroute.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                System.out.println("no action specified");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "addroute":
                route = new Route();
                route.setSource(request.getParameter("source"));
                route.setDestination(request.getParameter("destination"));
                route.setStatus(Status.valueOf(request.getParameter("status")));
                routeDao.create(route);
                request.setAttribute("message", "route added successfully!!!");
                dispatcher = request.getRequestDispatcher("routes.jsp");
                dispatcher.forward(request, response);
                break;
            case "updateroute":
                route = routeDao.findOne(Route.class, Long.parseLong(request.getParameter("id")));
                route.setSource(request.getParameter("source"));
                route.setDestination(request.getParameter("destination"));
                route.setStatus(Status.valueOf(request.getParameter("status")));
                routeDao.update(route);
                request.setAttribute("message", "route updated successfully!!!");
                dispatcher = request.getRequestDispatcher("routes.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                System.out.println("no action specified");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
