/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RouteDao;

/**
 *
 * @author Philip
 */
public class main {
    public static void main(String[] args) {
//        SessionFactory sf=DBUtil.getSessionFactory(); 
       RouteDao dao = new RouteDao();
       boolean stat = dao.checkRouteRequest(2, 0);

        System.out.println("status : "+ stat);

    }
}
