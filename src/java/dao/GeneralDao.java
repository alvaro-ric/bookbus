/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Philip
 */
public class GeneralDao<O> {
    SessionFactory sf=DBUtil.getSessionFactory(); 
    Session session=null;
    O obj;

    public O create(O object) {
        session = sf.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
        return object;
    }

    public String delete(O object) {
        session = sf.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
        return "success";
    }

    public String update(O object) {
        session = sf.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
        return "success";
    }

    public List<O> findAll(O object) {
        session = sf.openSession();
        Query query = session.createQuery("from " + object.getClass().getName());
        List<O> list = query.list();
        session.close();
        return list;
    }

    public O findOne(Class cl, Serializable id) {
        session = sf.openSession();
        O object = (O) session.get(cl, id);
        session.close();
        return object;
    }
    
}
