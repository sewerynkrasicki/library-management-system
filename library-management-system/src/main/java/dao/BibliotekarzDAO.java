/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Adres;
import POJO.Bibliotekarz;
import POJO.Rola;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class BibliotekarzDAO extends DAO{
     public Bibliotekarz createLibrarian(String firstName, String secondName, String login, String password, 
           String email, int addressId, int roleId) throws Exception{
        try{
            AdresDAO adrd = new AdresDAO();
            RolaDAO rold = new RolaDAO();
            Adres adr = adrd.getAddress(addressId);
            Rola rol = rold.getRole(roleId);
            
            begin();
            Bibliotekarz bibliotekarz = new Bibliotekarz(firstName, secondName, login, password, email, adr, rol);
            getSession().save(bibliotekarz);
            commit();
            return bibliotekarz;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć bibliotekarza "+ex);
        }
    }
    
public List<Bibliotekarz> readLibrarian() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Bibliotekarz");
        List<Bibliotekarz> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć bibliotekarza",ex);
    }
}
    
    public void updateLibrarian(Bibliotekarz bibliotekarz, String firstName, String secondName, String login, String password, 
           String email, int addressId, int roleId) throws Exception{
        try{
            AdresDAO adrd = new AdresDAO();
            RolaDAO rold = new RolaDAO();
            Adres adr = adrd.getAddress(addressId);
            Rola rol = rold.getRole(roleId);
            begin();
            bibliotekarz.setImie(firstName);
            bibliotekarz.setNazwisko(secondName);
            bibliotekarz.setEmail(email);
            bibliotekarz.setLogin(login);
            bibliotekarz.setHaslo(email);
            bibliotekarz.setAdres(adr);
            bibliotekarz.setRola(rol);
            getSession().update(bibliotekarz);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować bibliotekarza");
        }	
    }
    
    public void deleteLibrarian(int librarianID) throws Exception{
        try{
            begin();
            Bibliotekarz bibliotekarz = (Bibliotekarz)getSession().get(Bibliotekarz.class, librarianID);
            getSession().delete(bibliotekarz);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć bibliotekarza");
        }	
    }
    
        public Bibliotekarz getLibrarian(int bibliotekarzID) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Bibliotekarz where id = :bibliotekarzID");
            q.setParameter("bibliotekarzID", bibliotekarzID);
            Bibliotekarz bibliotekarz = (Bibliotekarz)q.uniqueResult();
            commit();
            return bibliotekarz;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego bibliotekarza");
        }	
    }
        
        public boolean librarianExist(String login) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Bibliotekarz where login = :login");
            q.setParameter("login", login);
            Bibliotekarz bibliotekarz = (Bibliotekarz)q.uniqueResult();
            commit();
            if(bibliotekarz==null)
            {
                return false;
            }else{
                return true;
            }
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego bibliotekarza");
        }
        }
        
        public Bibliotekarz getLibrarianByLogin(String login) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Bibliotekarz where login = :login");
            q.setParameter("login", login);
            Bibliotekarz bibliotekarz = (Bibliotekarz)q.uniqueResult();
            commit();
            return bibliotekarz;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego bibliotekarza");
        }
        }        
}
