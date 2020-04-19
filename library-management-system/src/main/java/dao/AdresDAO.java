/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Adres;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class AdresDAO extends DAO{
    public Adres createAddress(String city, String street, String postalCode, String houseNr) throws Exception{
        try{
            begin();
            Adres adres = new Adres(city, street, postalCode, houseNr);
            getSession().save(adres);
            commit();
            return adres;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć adresu");
        }
    }
    
public List<Adres> readAddress() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Adres");
        List<Adres> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć adresu",ex);
    }
}
    
    public void updateAddress(int addressID, String city, String street, String postalCode, String houseNr) throws Exception{
        try{
            begin();
            Adres adres = (Adres)getSession().get(Adres.class, addressID);
            adres.setMiasto(city);
            adres.setUlica(street);
            adres.setKodPocztowy(postalCode);
            adres.setNumerDomu(houseNr);
            getSession().update(adres);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować adresu");
        }	
    }
    
    public void deleteAddress(int addressID) throws Exception{
        try{
            begin();
            Adres adres = (Adres)getSession().get(Adres.class, addressID);
            getSession().delete(adres);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć adresu");
        }	
    }
}
