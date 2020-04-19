/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Kategoria;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class KategoriaDAO extends DAO{
    public Kategoria createCategory(String name) throws Exception{
        try{
            begin();
            Kategoria kategoria = new Kategoria(name);
            getSession().save(kategoria);
            commit();
            return kategoria;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć kategorii");
        }
    }
    
public List<Kategoria> readCategory() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Kategoria");
        List<Kategoria> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć kategorii",ex);
    }
}
    
    public void updateCategory(int KategoriaID, String nazwa) throws Exception{
        try{
            begin();
            Kategoria kategoria = (Kategoria)getSession().get(Kategoria.class, KategoriaID);
            kategoria.setNazwa(nazwa);
            getSession().update(kategoria);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować kategorii");
        }	
    }
    
    public void deleteCategory(int kategoriaID) throws Exception{
        try{
            begin();
            Kategoria kategoria = (Kategoria)getSession().get(Kategoria.class, kategoriaID);
            getSession().delete(kategoria);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć kategorii");
        }	
    }
}
