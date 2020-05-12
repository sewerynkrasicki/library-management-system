/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Autor;
import POJO.Kategoria;
import POJO.Ksiazka;
import POJO.Wydawnictwo;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class KsiazkaDAO extends DAO{
    public Ksiazka createBook(String name, String about, int year, double price, 
            int categoryId, int authorId, int wydawnictwoId) throws Exception{
        try{
            KategoriaDAO katd = new KategoriaDAO();
            AutorDAO autd = new AutorDAO();
            WydawnictwoDAO wydd = new WydawnictwoDAO();
            Kategoria kat = katd.getCategory(categoryId);
            Autor aut = autd.getAuthor(authorId);
            Wydawnictwo wyd = wydd.getPublisher(wydawnictwoId);
            begin();
            Ksiazka book = new Ksiazka(name, about, year, price, kat, aut, wyd);
            
            getSession().save(book);
            commit();
            return book;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć ksiazki");
        }
    }
    
public List<Ksiazka> readBook() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Ksiazka");
        List<Ksiazka> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć ksiazki",ex);
    }
}
    
    public void updateBook(Ksiazka ksiazka, String name, String about, int year, double price, 
            int categoryId, int authorId, int wydawnictwoId) throws Exception{
        try{
            KategoriaDAO katd = new KategoriaDAO();
            AutorDAO autd = new AutorDAO();
            WydawnictwoDAO wydd = new WydawnictwoDAO();
            Kategoria kat = katd.getCategory(categoryId);
            Autor aut = autd.getAuthor(authorId);
            Wydawnictwo wyd = wydd.getPublisher(wydawnictwoId);
            begin();
            ksiazka.setAutor(aut);
            ksiazka.setCenaBiblioteki(price);
            ksiazka.setKategoria(kat);
            ksiazka.setTytuł(name);
            ksiazka.setRokWydania(year);
            ksiazka.setWydawnictwo(wyd);
            getSession().update(ksiazka);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować ksiazki");
        }	
    }
    
    public void deleteBook(int ksiazkaID) throws Exception{
        try{
            begin();
            Ksiazka ksiazka = (Ksiazka)getSession().get(Ksiazka.class, ksiazkaID);
            getSession().delete(ksiazka);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć ksiazki");
        }	
    }
    
        public Ksiazka getBook(String name) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Ksiazka where tytuł = :name");
            q.setParameter("name", name);
            Ksiazka book = (Ksiazka)q.uniqueResult();
            commit();
            return book;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnej ksiazki");
        }	
    }
        
        public Ksiazka getBookById(int name) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Ksiazka where id = :name");
            q.setParameter("name", name);
            Ksiazka book = (Ksiazka)q.uniqueResult();
            commit();
            return book;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnej ksiazki");
        }	
    }        
}
