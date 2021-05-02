/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Passenger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Philip
 */
public class PassengerDao {

    SessionFactory sf = DBUtil.getSessionFactory();
    Session session = null;
    public List<Passenger> findAll() {
        session = sf.openSession();
        Query query = session.createQuery("FROM Passenger" );
        List<Passenger> companyJourneys = (List<Passenger>) query.list();
        session.close();
        return companyJourneys;
    }
}
