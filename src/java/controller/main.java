/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeneralDao;
import dao.RouteDao;
import model.AccountStatus;
import model.AdminAccount;
import model.Role;

/**
 *
 * @author Philip
 */
public class main {
    public static void main(String[] args) {
//        SessionFactory sf=DBUtil.getSessionFactory(); 
       AdminAccount admin = new AdminAccount();
       admin.setAccountRole(Role.SUPER_ADMIN);
       admin.setEmail("super@gmail.com");
       admin.setAccountStatus(AccountStatus.APPROVED);
       admin.setPassword("super@pass");
       GeneralDao<AdminAccount> generalDao = new GeneralDao<>();
       generalDao.create(admin);

    }
}
