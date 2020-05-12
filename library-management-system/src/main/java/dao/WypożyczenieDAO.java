/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Czytelnik;
import POJO.Egzemplarz;
import POJO.Wypozyczenia;
import static dao.DAO.getSession;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author 35747
 */
public class WypożyczenieDAO extends DAO{
     public Wypozyczenia createLend(int czytelnikId, int egzemplarzId) throws Exception{
        try{
            EgzemplarzDAO egzd = new EgzemplarzDAO();
            CzytelnikDAO czytd = new CzytelnikDAO();
            Egzemplarz egz = egzd.getPiece(egzemplarzId);
            Czytelnik czyt = czytd.getReader(czytelnikId);
            egzd.lendPiece(egz);
            Date lendDate = new Date();
            begin();
            Wypozyczenia wypożyczenie = new Wypozyczenia(lendDate, null, egz, czyt, 0, false);
            getSession().save(wypożyczenie);
            commit();
            return wypożyczenie;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć wypożyczenia "+ex);
        }
    }
     
    public Wypozyczenia createLendAdmin(Date data_wypozyczenia, Date data_oddania, double kara, int czytelnikId, int egzemplarzId, boolean oddane) throws Exception{
        try{
            EgzemplarzDAO egzd = new EgzemplarzDAO();
            CzytelnikDAO czytd = new CzytelnikDAO();
            Egzemplarz egz = egzd.getPiece(egzemplarzId);
            Czytelnik czyt = czytd.getReader(czytelnikId);
            egzd.lendPiece(egz);
            begin();
            Wypozyczenia wypożyczenie = new Wypozyczenia(data_wypozyczenia, data_oddania, egz, czyt, kara, oddane);
            getSession().save(wypożyczenie);
            commit();
            return wypożyczenie;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge stworzyć wypożyczenia "+ex);
        }
    }
    
    public void returnLend(Wypozyczenia wypozyczenia) throws Exception{
        try{
            Date returnDate = new Date();
            
            Date lendDate = new Date(wypozyczenia.getData_wypozyczenia().getTime());
            long daysBetween = Duration.between(lendDate.toInstant(), returnDate.toInstant()).toDays();
            
            double kara = 0;
            if(daysBetween > 14){
                long late = daysBetween-14;
                kara = late * 3.50;
            }
            
            begin();
            wypozyczenia.setData_oddania(returnDate);
            wypozyczenia.setKara(kara);
            wypozyczenia.setOddane(true);
            int ilosc = wypozyczenia.getEgzemplarz().getStan();
            wypozyczenia.getEgzemplarz().setStan(ilosc+1);
            getSession().save(wypozyczenia);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie mozesz oddac "+ex);
        }        
    }
    
    public List<Wypozyczenia> readLend() throws Exception{
        try{
            begin();
            Query q = getSession().createQuery("from Wypozyczenia");
            List<Wypozyczenia> list = q.list();
            commit();
            return list;
        }
        catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć wypozyczenia",ex);
        }
    }
    
    public List<Wypozyczenia> readLendByReader(int readerID) throws Exception{
        try{
            begin();
            Query q = getSession().createQuery("from Wypozyczenia where czytelnik_id = :readerID");
            q.setParameter("readerID", readerID);
            List<Wypozyczenia> list = q.list();
            commit();
            return list;
        }
        catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć wypozyczenia",ex);
        }
    }
    
    public void updateLend(Wypozyczenia wypozyczenie, Date data_wypozyczneia, Date data_oddania, double kara, int czytelnikId, int egzemplarzId, boolean oddane) throws Exception{
        try{
            EgzemplarzDAO egzd = new EgzemplarzDAO();
            CzytelnikDAO czytd = new CzytelnikDAO();
            Egzemplarz egz = egzd.getPiece(egzemplarzId);
            Czytelnik czyt = czytd.getReader(czytelnikId);
            begin();
            wypozyczenie.setData_wypozyczenia(data_wypozyczneia);
            wypozyczenie.setData_oddania(data_oddania);
            wypozyczenie.setKara(kara);
            wypozyczenie.setCzytelnik(czyt);
            wypozyczenie.setEgzemplarz(egz);
            wypozyczenie.setOddane(oddane);
            getSession().update(wypozyczenie);
            commit();
        }catch(HibernateException ex)
        {
            rollback();
            throw new Exception("Nie moge zmodyfikować wypozyczenia");
        }	
    }
    
    public void deleteLend(int lendID) throws Exception{
        try{
            begin();
            Wypozyczenia wypozyczenie = (Wypozyczenia)getSession().get(Wypozyczenia.class, lendID);
            getSession().delete(wypozyczenie);
            commit();
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge usunąć wypozyczenia");
        }	
    }
    
        public Wypozyczenia getLend(int lendID) throws Exception{
         try{
            begin();
            Query q = getSession().createQuery("FROM Wypozyczenia where id = :lendID");
            q.setParameter("lendID", lendID);
            Wypozyczenia wypozyczenie = (Wypozyczenia)q.uniqueResult();
            commit();
            return wypozyczenie;
        }catch(HibernateException ex){
            rollback();
            throw new Exception("Nie moge znaleźć konkretnego wypozyczenia");
        }
        }      
}
