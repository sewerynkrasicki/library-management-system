/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Autor;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class AutorDAO extends DAO{
    public Autor createAuthor(String firstName, String secondName, String country, String century) throws Exception{
        try{
            begin();
            Autor autor = new Autor(firstName, secondName, country, century);
            getSession().save(autor);
            commit();
            return autor;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć autora");
        }
    }
    
public List<Autor> readAuthor() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Autor");
        List<Autor> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć autora",ex);
    }
}
    
    public void updateAuthor(int authorID, String firstName, String secondName, String country, String century) throws Exception{
        try{
            begin();
            Autor autor = (Autor)getSession().get(Autor.class, authorID);
            autor.setImie(firstName);
            autor.setNazwisko(secondName);
            autor.setMiejsceUrodzenia(country);
            autor.setWiekDzialania(century);
            getSession().update(autor);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować autora");
        }	
    }
    
    public void deleteAuthor(int authorID) throws Exception{
        try{
            begin();
            Autor autor = (Autor)getSession().get(Autor.class, authorID);
            getSession().delete(autor);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć autora");
        }	
    }
}
