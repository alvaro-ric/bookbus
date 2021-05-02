/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CompanyState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Philip
 */
public class CompanyDao {
    SessionFactory sf=DBUtil.getSessionFactory(); 
    Session session=null;
    public List<CompanyState> getCompanyStates(long id) {
        session = sf.openSession();
        Query query = session.createQuery("FROM CompanyState where company_id='"+id+"'" );
        List<CompanyState> companyStates = (List<CompanyState>) query.list();
        session.close();
        return companyStates;
    }
}
