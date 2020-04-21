/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Rola;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class RolaDAO extends DAO{
     public Rola createRole(String name) throws Exception{
        try{
            begin();
            Rola rola = new Rola(name);
            getSession().save(rola);
            commit();
            return rola;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć roli");
        }
    }
    
public List<Rola> readRole() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Rola");
        List<Rola> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć roli",ex);
    }
}
    
    public void updateRole(int RoleID, String nazwa) throws Exception{
        try{
            begin();
            Rola rola = (Rola)getSession().get(Rola.class, RoleID);
            rola.setUserType(nazwa);
            getSession().update(rola);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować roli");
        }	
    }
    
    public void deleteRole(int RoleID) throws Exception{
        try{
            begin();
            Rola rola = (Rola)getSession().get(Rola.class, RoleID);
            getSession().delete(rola);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć roli");
        }	
    }
    
        public Rola getRole(int roleID) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Rola where id = :roleID");
            q.setString("roleID", Integer.toString(roleID));
            Rola rol = (Rola)q.uniqueResult();
            commit();
            return rol;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnej roli");
        }	
    }
}
