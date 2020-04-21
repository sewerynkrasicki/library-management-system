/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Wydawnictwo;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class WydawnictwoDAO extends DAO{
     public Wydawnictwo createPublisher(String name, String city, String REGON, String NIP) throws Exception{
        try{
            begin();
            Wydawnictwo wydawnictwo = new Wydawnictwo(name, city, REGON, NIP);
            getSession().save(wydawnictwo);
            commit();
            return wydawnictwo;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć wydawnictwa");
        }
    }
    
public List<Wydawnictwo> readPublisher() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Wydawnictwo");
        List<Wydawnictwo> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć wydawnictwa",ex);
    }
}
    
    public void updatePublisher(int WydawnictwoID, String name, String city, String REGON, String NIP) throws Exception{
        try{
            begin();
            Wydawnictwo wydawnictwo = (Wydawnictwo)getSession().get(Wydawnictwo.class, WydawnictwoID);
            wydawnictwo.setNazwa(name);
            wydawnictwo.setMiasto(city);
            wydawnictwo.setREGON(REGON);
            wydawnictwo.setNIP(NIP);
            getSession().update(wydawnictwo);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować wydawnictwa");
        }	
    }
    
    public void deletePublisher(int WydawnictwoID) throws Exception{
        try{
            begin();
            Wydawnictwo wydawnictwo = (Wydawnictwo)getSession().get(Wydawnictwo.class, WydawnictwoID);
            getSession().delete(wydawnictwo);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć wydawnictwa");
        }	
    }
    
        public Wydawnictwo getPublisher(int wydawnictwoID) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Wydawnictwo where id = :wydawnictwoID");
            q.setString("wydawnictwoID", Integer.toString(wydawnictwoID));
            Wydawnictwo wyd = (Wydawnictwo)q.uniqueResult();
            commit();
            return wyd;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego wydawnictwa");
        }	
    }
}
