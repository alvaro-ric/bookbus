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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountState;
import model.AccountStatus;
import model.ManagerAccount;

/**
 *
 * @author Philip
 */
@WebServlet(name = "AccountControl", urlPatterns = {"/AccountControl"})
public class AccountControl extends HttpServlet {

    RequestDispatcher dispatcher;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        GeneralDao<ManagerAccount> accountDao = new GeneralDao<>();
        ManagerAccount managerAccount;
        AccountState accountState;
        ManagerAccount account;
        GeneralDao<AccountState> accountStateDao = new GeneralDao<>();
        
        java.util.Date date = new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        switch(action){
            case "approve":
                account = (ManagerAccount)session.getAttribute("user");
                accountState = new AccountState();
                
                managerAccount = accountDao.findOne(ManagerAccount.class, Long.parseLong(request.getParameter("id")));
                managerAccount.setAccountStatus(AccountStatus.APPROVED);
                accountDao.update(managerAccount);
                
                accountState.setAccountStatus(AccountStatus.APPROVED);
                accountState.setDoneBy(account.getManager());
                accountState.setManagerAccount(managerAccount);
                accountState.setUpdateOn(Timestamp.valueOf(formatter.format(ts)));
                
                accountStateDao.create(accountState);
                request.setAttribute("message", "company is approved successfully");
                dispatcher = request.getRequestDispatcher("accountspercompany.jsp");
                dispatcher.forward(request, response);
                break;
                
            case "suspend":
                account = (ManagerAccount)session.getAttribute("user");
                accountState = new AccountState();
                managerAccount = accountDao.findOne(ManagerAccount.class, Long.parseLong(request.getParameter("id")));
                managerAccount.setAccountStatus(AccountStatus.SUSPENDED);
                accountDao.update(managerAccount);
                
                accountState.setAccountStatus(AccountStatus.SUSPENDED);
                accountState.setDoneBy(account.getManager());
                accountState.setManagerAccount(managerAccount);
                accountState.setUpdateOn(Timestamp.valueOf(formatter.format(ts)));
                
                accountStateDao.create(accountState);
                request.setAttribute("message", "company is suspended successfully");
                dispatcher = request.getRequestDispatcher("accountspercompany.jsp");
                dispatcher.forward(request, response);
                break;

            default:
                System.out.println("no action specified");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
