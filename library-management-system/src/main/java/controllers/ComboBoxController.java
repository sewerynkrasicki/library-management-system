/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Adres;
import POJO.Autor;
import POJO.Czytelnik;
import POJO.Egzemplarz;
import POJO.Kategoria;
import POJO.Ksiazka;
import POJO.Rola;
import POJO.Wydawnictwo;
import dao.AdresDAO;
import dao.AutorDAO;
import dao.CzytelnikDAO;
import dao.EgzemplarzDAO;
import dao.KategoriaDAO;
import dao.KsiazkaDAO;
import dao.RolaDAO;
import dao.WydawnictwoDAO;
import javax.swing.JComboBox;

/**
 *
 * @author 35747
 */
public class ComboBoxController {
    public void bookComboBox(JComboBox j) throws Exception{
        KsiazkaDAO ksid = new KsiazkaDAO();
        for(Ksiazka k : ksid.readBook()){
            j.addItem(k);
        }
    }

    public void categoryComboBox(JComboBox j) throws Exception{
        KategoriaDAO kd = new KategoriaDAO();
        for(Kategoria k : kd.readCategory()){
            j.addItem(k);
        }
    }
    
    public void authorComboBox(JComboBox j) throws Exception{
        AutorDAO ad = new AutorDAO();
        for(Autor a : ad.readAuthor()){
            j.addItem(a);
        }
    }
    
    public void publisherComboBox(JComboBox j) throws Exception{
        WydawnictwoDAO wd = new WydawnictwoDAO();
        for(Wydawnictwo w : wd.readPublisher()){
            j.addItem(w);
        }
    }
    
    public void pieceComboBox(JComboBox j) throws Exception{
        EgzemplarzDAO ed = new EgzemplarzDAO();
        for(Egzemplarz e : ed.readPieces()){
            j.addItem(e);
        }
    }
    
    public void readerComboBox(JComboBox j) throws Exception{
        CzytelnikDAO czytd = new CzytelnikDAO();
        for(Czytelnik c : czytd.readReader()){
            j.addItem(c);
        }
    }
    
    public void roleComboBox(JComboBox j) throws Exception{
        RolaDAO rd = new RolaDAO();
        for(Rola r : rd.readRole()){
            j.addItem(r);
        }
    }
    
    public void addressComboBox(JComboBox j) throws Exception{
        AdresDAO ad = new AdresDAO();
        for(Adres a : ad.readAddress()){
            j.addItem(a);
        }
    }
}
