/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import reg.backend.utils.HibernateUtil;

/**
 *
 * @author duncan
 * @param <K>
 */
public class GeneralDao<K> {
     Session session =null;
    private final Class<K> type;

    public GeneralDao(Class<K> type) {
        this.type = type;
    }
    
    public Session createSession(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }
    public void closeSession(){
        session.getTransaction().commit();
        session.close();
    }
    
    
    public void save(K obj){
        createSession().save(obj);
        closeSession();
    }
    
    public void update(K obj){
        createSession().update(obj);
        closeSession();
    }
    public void delete(K obj){
        createSession().delete(obj);
        closeSession();
    }
    public K  findById(Serializable id){
        K obj = (K) createSession().get(type, id);
        closeSession();
        return obj;
    }
    public List<K>  findAll(){
        List<K> obj = createSession().createCriteria(type.getName()).list();
        closeSession();
        return obj;
    }
}
