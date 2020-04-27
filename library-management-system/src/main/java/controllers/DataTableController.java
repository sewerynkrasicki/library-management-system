/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Autor;
import POJO.Kategoria;
import POJO.Ksiazka;
import POJO.Wydawnictwo;
import dao.AutorDAO;
import dao.KategoriaDAO;
import dao.KsiazkaDAO;
import dao.WydawnictwoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 35747
 */
public class DataTableController {
        public DefaultTableModel dtmBooks(){
            DefaultTableModel tab = null;
            try {
                KsiazkaDAO ksid = new KsiazkaDAO();
                String[] columnNames = {"Tytuł", "Autor", "Rok wydania", "Cena biblioteki", "Wydawnictwo", "Kategoria"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Ksiazka k:ksid.readBook()){
                    String[] row = {k.getTytuł(), k.getAutor().getNazwisko()+" "+k.getAutor().getImie(), String.valueOf(k.getRokWydania()),
                        String.valueOf(k.getCenaBiblioteki()), k.getWydawnictwo().getNazwa(), k.getKategoria().getNazwa()};
                    tab.addRow(row);
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }    
        
        public DefaultTableModel dtmCategory(){
            DefaultTableModel tab = null;
            try {
                KategoriaDAO katd = new KategoriaDAO();
                String[] columnNames = {"Kategoria"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Kategoria k:katd.readCategory()){
                    String[] row = {k.getNazwa()};
                    tab.addRow(row);
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }    
        
        public DefaultTableModel dtmAuthor(){
            DefaultTableModel tab = null;
            try {
                AutorDAO autd = new AutorDAO();
                String[] columnNames = {"Imie", "Nazwisko", "Miejsce urodzenia", "Wiek działania"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Autor a:autd.readAuthor()){
                    String[] row = {a.getImie(), a.getNazwisko(), a.getMiejsceUrodzenia(), a.getWiekDzialania()};
                    tab.addRow(row);
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }    
        
        public DefaultTableModel dtmPublisher(){
            DefaultTableModel tab = null;
            try {
                WydawnictwoDAO wydd = new WydawnictwoDAO();
                String[] columnNames = {"Nazwa", "Miasto", "REGON", "NIP"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Wydawnictwo w:wydd.readPublisher()){
                    String[] row = {w.getNazwa(), w.getMiasto(), w.getNIP(), w.getREGON()};
                    tab.addRow(row);
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }    
}
