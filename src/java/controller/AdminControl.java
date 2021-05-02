/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AccountStatus;
import model.AdminAccount;
import model.Role;

/**
 *
 * @author Philip
 */
@WebServlet(name = "AdminControl", urlPatterns = {"/AdminControl"})
public class AdminControl extends HttpServlet {

    RequestDispatcher dispatcher;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDao<AdminAccount> accountDao = new AccountDao<>(AdminAccount.class);
        String action = request.getParameter("action");
        String email = null;
        String password=null;
        switch (action) {
            case "login":
                try {
                    email = request.getParameter("email");
                    password = request.getParameter("password");
                } catch (NullPointerException e) {
                    request.setAttribute("message", "Null fields are not allowed!!");
                    dispatcher = request.getRequestDispatcher("adminlogin.jsp");
                    dispatcher.forward(request, response);
                }
                AdminAccount account = accountDao.getAccount(email, password);
                if (account == null) {
                    request.setAttribute("message", "username or password is invalid!!");
                    dispatcher = request.getRequestDispatcher("adminlogin.jsp");
                    dispatcher.forward(request, response);
                } else if (account.getAccountStatus().toString().equals("CREATED")) {
                    request.setAttribute("message", "your account has not been approved yet");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                } else if (account.getAccountStatus().toString().equals("SUSPENDED")) {
                    request.setAttribute("message", "your account has been suspended");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    request.getSession().setAttribute("user", account);
                    response.sendRedirect("admin.jsp");
                }
                break;
            case "logout":
                request.getSession().removeAttribute("user");
                response.sendRedirect("adminlogin.jsp");
                break;
            case "createAccount":
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
