/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Adres;
import POJO.Czytelnik;
import POJO.Rola;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class CzytelnikDAO extends DAO{
     public Czytelnik createReader(String firstName, String secondName, String login, String password, 
           String email, int addressId, int roleId) throws Exception{
        try{
            AdresDAO adrd = new AdresDAO();
            RolaDAO rold = new RolaDAO();
            Adres adr = adrd.getAddress(addressId);
            Rola rol = rold.getRole(roleId);
            
            begin();
            Czytelnik czytelnik = new Czytelnik(firstName, secondName, login, password, email, adr, rol);
            getSession().save(czytelnik);
            commit();
            return czytelnik;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć czytelnika "+ex);
        }
    }
    
public List<Czytelnik> readReader() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Czytelnik");
        List<Czytelnik> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć czytelnika",ex);
    }
}
    
    public void updateReader(Czytelnik czytelnik, String firstName, String secondName, String login, String password, 
           String email, int addressId, int roleId) throws Exception{
        try{
          AdresDAO adrd = new AdresDAO();
            RolaDAO rold = new RolaDAO();
            Adres adr = adrd.getAddress(addressId);
            Rola rol = rold.getRole(roleId);
            begin();
            czytelnik.setImie(firstName);
            czytelnik.setNazwisko(secondName);
            czytelnik.setEmail(email);
            czytelnik.setLogin(login);
            czytelnik.setHaslo(email);
            czytelnik.setAdres(adr);
            czytelnik.setRola(rol);
            getSession().update(czytelnik);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować czytelnika");
        }	
    }
    
    public void deleteReader(int readerID) throws Exception{
        try{
            begin();
            Czytelnik czytelnik = (Czytelnik)getSession().get(Czytelnik.class, readerID);
            getSession().delete(czytelnik);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć czytelnika");
        }	
    }
    
        public Czytelnik getReader(int czytelnikID) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Czytelnik where id = :czytelnikID");
            q.setParameter("czytelnikID", czytelnikID);
            Czytelnik czytelnik = (Czytelnik)q.uniqueResult();
            commit();
            return czytelnik;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego czytelnika");
        }
        }
         
        public Czytelnik getReaderByLogin(String login) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Czytelnik where login = :login");
            q.setParameter("login", login);
            Czytelnik czytelnik = (Czytelnik)q.uniqueResult();
            commit();
            return czytelnik;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego czytelnika");
        }
        }
        
        public boolean readerExist(String login) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Czytelnik where login = :login");
            q.setParameter("login", login);
            Czytelnik czytelnik = (Czytelnik)q.uniqueResult();
            commit();
            if(czytelnik==null)
            {
                return false;
            }else{
                return true;
            }
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego czytelnika");
        }
        }
        public boolean emailExist(String email) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Czytelnik where email = :email");
            q.setParameter("email", email);
            Czytelnik czytelnik = (Czytelnik)q.uniqueResult();
            commit();
            if(czytelnik==null)
            {
                return false;
            }else{
                return true;
            }
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego czytelnika");
        }
        }        
}
