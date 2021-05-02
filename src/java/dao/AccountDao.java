/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.ManagerAccount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Philip
 */
public class AccountDao<O> {
    SessionFactory sf=DBUtil.getSessionFactory(); 
    Session session=null;

    private final Class<O> type;
//

    public AccountDao(Class<O> type) {
        this.type = type;
    }

    public O getAccount(String email, String password) {
        String className = type.getCanonicalName().substring(type.getCanonicalName().lastIndexOf(".")+1);
        session = sf.openSession();
        Query query = session.createQuery("FROM "+ className +" where email='"+email+"' and password='"+password+"'" );
        O account = (O) query.uniqueResult();
        session.close();
        return account;
    }
    
    public List<ManagerAccount> getCompanyAccounts(long id) {
        session = sf.openSession();
        Query query = session.createQuery("FROM ManagerAccount where company_id='"+id+"'" );
        List<ManagerAccount> companyAccounts = (List<ManagerAccount>) query.list();
        session.close();
        return companyAccounts;
    }
    
    public List<O> getAccountStates(long id) {
        session = sf.openSession();
        Query query = session.createQuery("FROM AccountState where manageraccount_id='"+id+"'" );
        List<O> companyAccounts = (List<O>) query.list();
        session.close();
        return companyAccounts;
    }
}
