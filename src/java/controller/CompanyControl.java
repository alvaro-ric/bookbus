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
import model.AccountState;
import model.AccountStatus;
import model.AdminAccount;
import model.Company;
import model.CompanyState;
import model.CompanyStatus;
import model.Manager;
import model.ManagerAccount;
import model.Role;

/**
 *
 * @author Philip
 */
@WebServlet(name = "CompanyControl", urlPatterns = {"/CompanyControl"})
public class CompanyControl extends HttpServlet {

    GeneralDao<CompanyState> companyStateDao = new GeneralDao<>();
    GeneralDao<AccountState> AccountStateDao = new GeneralDao<>();
    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDao<ManagerAccount> accountDao = new AccountDao<>(ManagerAccount.class);
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        GeneralDao<Company> companyDao = new GeneralDao<>();
        java.util.Date date = new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AdminAccount adminAccount;
        CompanyState companyState;
        Company company;
        switch (action) {
            case "login":
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                ManagerAccount account = accountDao.getAccount(email, password);
                if (account == null) {
                    request.setAttribute("message", "username or password is invalid!!");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                } else if (account.getCompany().getCompanyStatus().toString().equals("CREATED")) {
                    request.setAttribute("message", "Company account has not been approved yet");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                } else if (account.getCompany().getCompanyStatus().toString().equals("SUSPENDED")) {
                    request.setAttribute("message", "Company account has been suspended");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                } else if (account.getAccountStatus().toString().equals("CREATED")) {
                    request.setAttribute("message", "your account has not been approved yet");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                } else if (account.getAccountStatus().toString().equals("SUSPENDED")) {
                    request.setAttribute("message", "your account has been suspended");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                } else {
                    session.setAttribute("user", account);
                    String location = (String) session.getAttribute("trigger");
                    session.removeAttribute("trigger");
                    if (location == null) {
                        response.sendRedirect("dashboard.jsp");
                    } else {
                        response.sendRedirect(location + ".jsp");
                    }
                }

                break;

            case "logout":
                request.getSession().removeAttribute("user");
                response.sendRedirect("dashboard.jsp");
                break;

            case "approve":

                adminAccount = (AdminAccount) session.getAttribute("user");
                companyState = new CompanyState();

                company = companyDao.findOne(Company.class, Long.parseLong(request.getParameter("id")));
                company.setCompanyStatus(CompanyStatus.APPROVED);
                companyDao.update(company);

                companyState.setCompany(company);
                companyState.setCompanyStatus(CompanyStatus.APPROVED);
                companyState.setDoneBy(adminAccount);

                companyState.setUpdateOn(Timestamp.valueOf(formatter.format(ts)));
                companyStateDao.create(companyState);

                request.setAttribute("message", "company is approved successfully");
                dispatcher = request.getRequestDispatcher("allcompanies.jsp");
                dispatcher.forward(request, response);
                break;

            case "suspend":
                adminAccount = (AdminAccount) session.getAttribute("user");
                companyState = new CompanyState();

                company = companyDao.findOne(Company.class, Long.parseLong(request.getParameter("id")));
                company.setCompanyStatus(CompanyStatus.SUSPENDED);
                companyDao.update(company);

                companyState.setCompany(company);
                companyState.setCompanyStatus(CompanyStatus.SUSPENDED);
                companyState.setDoneBy(adminAccount);
                companyState.setUpdateOn(Timestamp.valueOf(formatter.format(ts)));
                companyStateDao.create(companyState);

                request.setAttribute("message", "company is suspended successfully");
                dispatcher = request.getRequestDispatcher("allcompanies.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                System.out.println("no action specified");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GeneralDao<Company> companyDao = new GeneralDao<>();
        GeneralDao<Manager> managerDao = new GeneralDao<>();
        GeneralDao<ManagerAccount> accountDao = new GeneralDao<>();
        AccountDao<AdminAccount> adminaccDao = new AccountDao<>(AdminAccount.class);
        AdminAccount account = adminaccDao.getAccount("super@gmail.com", "super@pass");
        SimpleDateFormat sdftime = new SimpleDateFormat("hh:mm");
        String action = request.getParameter("action");
        
        java.util.Date date = new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Company company;
        Manager manager;
        ManagerAccount managerAccount;
        AccountState accountState;
        switch (action) {
            case "addcompany":
                company = new Company();
                manager = new Manager();
                managerAccount = new ManagerAccount();
                CompanyState companyState = new CompanyState();

                manager.setFirstName(request.getParameter("firstName"));
                manager.setLastName(request.getParameter("lastName"));
                manager.setPhoneNumber(request.getParameter("phoneNumber"));

                managerDao.create(manager);

                company.setName(request.getParameter("companyName"));
                company.setCompanySize(request.getParameter("companySize"));
                company.setCompanyStatus(CompanyStatus.CREATED);

                company.setCreatedOn(Timestamp.valueOf(formatter.format(ts)));
                company.setManager(manager);
                companyDao.create(company);

                companyState.setCompany(company);
                companyState.setCompanyStatus(CompanyStatus.CREATED);
                companyState.setDoneBy(account);
                companyState.setUpdateOn(Timestamp.valueOf(formatter.format(ts)));
                companyStateDao.create(companyState);
                
                

                managerAccount.setManager(manager);
                managerAccount.setCompany(company);
                managerAccount.setAccountStatus(AccountStatus.APPROVED);
                managerAccount.setEmail(request.getParameter("email"));
                managerAccount.setPassword(request.getParameter("password"));
                managerAccount.setAccountRole(Role.COMPANY);

                accountDao.create(managerAccount);
                
                accountState = new AccountState();
                accountState.setAccountStatus(AccountStatus.CREATED);
                accountState.setDoneBy(manager);
                accountState.setManagerAccount(managerAccount);
                accountState.setUpdateOn(Timestamp.valueOf(formatter.format(ts)));
                
                AccountStateDao.create(accountState);

                response.sendRedirect("login.jsp");
                break;
            case "createaccount":
                company = ((ManagerAccount) request.getSession().getAttribute("user")).getCompany();
                
                manager = new Manager();
                managerAccount = new ManagerAccount();
                manager.setFirstName(request.getParameter("firstname"));
                manager.setLastName(request.getParameter("lastname"));
                manager.setPhoneNumber(request.getParameter("phonenumber"));

                managerDao.create(manager);

                managerAccount.setManager(manager);
                managerAccount.setCompany(company);
                managerAccount.setAccountStatus(AccountStatus.valueOf(request.getParameter("accountstatus")));
                managerAccount.setEmail(request.getParameter("email"));
                managerAccount.setPassword(request.getParameter("password"));
                managerAccount.setAccountRole(Role.COMPANY);
                accountDao.create(managerAccount);
                
                accountState = new AccountState();
                accountState.setAccountStatus(AccountStatus.CREATED);
                accountState.setDoneBy(manager);
                accountState.setManagerAccount(managerAccount);
                accountState.setUpdateOn(Timestamp.valueOf(formatter.format(ts)));
                
                AccountStateDao.create(accountState);
                response.sendRedirect("dashboard.jsp");
                break;

            default:
                System.out.println("no action specified");
        }

    }

}
