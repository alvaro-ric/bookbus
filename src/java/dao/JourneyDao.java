/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CompanyRoute;
import model.Journey;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Philip
 */
public class JourneyDao {
    SessionFactory sf=DBUtil.getSessionFactory(); 
    Session session=null;
    
    public List<Journey> getCompanyJourneys(long id) {
        session = sf.openSession();
        Query query = session.createQuery("FROM Journey where company_id='"+id+"'" );
        List<Journey> companyJourneys = (List<Journey>) query.list();
        session.close();
        return companyJourneys;
    }
    
    //check previous request
    public boolean checkRouteRequest(long company_id, long route_id) {
        session = sf.openSession();
        Query query = session.createQuery("FROM CompanyRoute where company_id='"+company_id+"' and route_id='"+route_id+"'" );
        CompanyRoute companyRoute = (CompanyRoute) query.uniqueResult();
        session.close();
        try {
            long id = companyRoute.getId();
            return true;
        } catch (NullPointerException e) {
            return false;
        } 
    }
    
    public List<CompanyRoute> approvedRoutes(long id) {
        session = sf.openSession();
        Query query = session.createQuery("FROM CompanyRoute where company_id='"+id+"' and routestatus='APPROVED'" );
        List<CompanyRoute> companyRoutes = (List<CompanyRoute>) query.list();
        session.close();
        return companyRoutes;
    }
    
    public List<Journey> availableJourneys(long id) {
        session = sf.openSession();
        Query query = session.createQuery("FROM Journey where route_id='"+id+"' and journeystatus='BOOKING'" );
        List<Journey> journeys = (List<Journey>) query.list();
        session.close();
        return journeys;
    }
}
