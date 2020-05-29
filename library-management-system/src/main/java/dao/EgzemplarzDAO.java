/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Egzemplarz;
import POJO.Ksiazka;
import static dao.DAO.getSession;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class EgzemplarzDAO extends DAO{
     public Egzemplarz createPiece (int stan, boolean dostepna, int ksiazkaId) throws Exception{
        try{
            KsiazkaDAO ksid = new KsiazkaDAO();
            Ksiazka ksi = ksid.getBookById(ksiazkaId);     
            begin();
            Egzemplarz egzemplarz = new Egzemplarz(stan, dostepna, ksi);
            getSession().save(egzemplarz);
            commit();
            return egzemplarz;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć egzemplarza "+ex);
        }
    }
     
    public void lendPiece (Egzemplarz egzemplarz) throws Exception{
        try{
            begin();
            int stan = egzemplarz.getStan();
            egzemplarz.setStan(stan-1);
            if(egzemplarz.getStan()>0){
                egzemplarz.setDostepna(true);
            }else{
                egzemplarz.setDostepna(false);
            }
            getSession().save(egzemplarz);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć egzemplarza "+ex);
        }
    }
    
public List<Egzemplarz> readPieces() throws Exception{
    try{
        begin();
        Query q = getSession().createQuery("from Egzemplarz");
        List<Egzemplarz> list = q.list();
        commit();
        return list;
    }
    catch(HibernateException ex){
        rollback();
        throw new Exception("Nie moge znaleźć egzemplarzy",ex);
    }
}
    
    public void updatePiece(Egzemplarz egzemplarz, int stan, boolean dostepna, int ksiazkaId) throws Exception{
        try{
            KsiazkaDAO ksid = new KsiazkaDAO();
            Ksiazka ksi = ksid.getBookById(ksiazkaId);     
            begin();
            egzemplarz.setStan(stan);
            egzemplarz.setDostepna(dostepna);
            egzemplarz.setKsiazka(ksi);
            getSession().update(egzemplarz);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować egzemplarza");
        }	
    }
    
    public void deletePiece(int pieceId) throws Exception{
        try{
            begin();
            Egzemplarz egzemplarz = (Egzemplarz)getSession().get(Egzemplarz.class, pieceId);
            getSession().delete(egzemplarz);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć egzemplarza");
        }	
    }
    
        public Egzemplarz getPiece(int egzemplarzID) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Egzemplarz where id = :egzemplarzID");
            q.setParameter("egzemplarzID", egzemplarzID);
            Egzemplarz egzemplarz = (Egzemplarz)q.uniqueResult();
            commit();
            return egzemplarz;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego egzemplarza");
        }	
    }     
}
