/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDao;
import dao.GeneralDao;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountStatus;
import model.Company;
import model.Manager;
import model.ManagerAccount;

/**
 *
 * @author Philip
 */
@WebServlet(name = "CompanyControl", urlPatterns = {"/CompanyControl"})
public class CompanyControl extends HttpServlet {

    RequestDispatcher dispatcher;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDao<ManagerAccount> accountDao = new AccountDao<>(ManagerAccount.class);
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ManagerAccount account = accountDao.getAccount(email, password);
        if(account == null){
            request.setAttribute("message", "username or password is invalid!!");
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            session.setAttribute("user", account);
            String location = (String) session.getAttribute("trigger");
            session.removeAttribute("trigger");
            response.sendRedirect(location+".jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneralDao<Company> companyDao = new GeneralDao<>();
        GeneralDao<Manager> managerDao = new GeneralDao<>();
        GeneralDao<ManagerAccount> accountDao = new GeneralDao<>();
        SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm");
        String action = request.getParameter("action");
        switch (action) {
            case "addcompany":
                Company company = new Company();
                Manager manager = new Manager();
                ManagerAccount managerAccount = new ManagerAccount();
                company.setName(request.getParameter("companyName"));
                company.setCompanySize(request.getParameter("companySize"));
                
                java.util.Date date = new java.util.Date();
                Timestamp ts = new Timestamp(date.getTime());
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                
                company.setCreatedOn(Timestamp.valueOf(formatter.format(ts)));
                
                companyDao.create(company);
                
                manager.setFirstName(request.getParameter("firstName"));
                manager.setLastName(request.getParameter("lastName"));
                manager.setPhoneNumber(request.getParameter("phoneNumber"));
                
                managerDao.create(manager);
                
                managerAccount.setManager(manager);
                managerAccount.setCompany(company);
                managerAccount.setAccountStatus(AccountStatus.APPROVED);
                managerAccount.setEmail(request.getParameter("email"));
                managerAccount.setPassword(request.getParameter("password"));
                
                accountDao.create(managerAccount);
                
                response.sendRedirect("login.jsp");
                break;
            case "updateflight":
                
                response.sendRedirect("Dashboard.jsp");
                break;

            default:
                System.out.println("no action specified");
        }

    }


}
