/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Autor;
import POJO.Egzemplarz;
import POJO.Kategoria;
import POJO.Ksiazka;
import POJO.Wydawnictwo;
import POJO.Wypozyczenia;
import dao.AutorDAO;
import dao.EgzemplarzDAO;
import dao.KategoriaDAO;
import dao.KsiazkaDAO;
import dao.WydawnictwoDAO;
import dao.WypożyczenieDAO;
import java.text.SimpleDateFormat;
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
        
        public DefaultTableModel dtmLend(int id){
            DefaultTableModel tab = null;
            try {
                WypożyczenieDAO wypod = new WypożyczenieDAO();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String[] columnNames = {"id", "Tytuł", "Autor", "Kategoria", "Data_wypożyczenia", "Data_oddania", "Kara", "Oddane"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Wypozyczenia w:wypod.readLendByReader(id)){
                    String oddane;
                    if(w.getOddane()==true){
                        oddane = "Tak";
                    }else{
                        oddane = "Nie";
                    }
                    String returnDate;
                    if(w.getData_oddania()==null){
                        returnDate = null;
                    }else{
                        returnDate = formatter.format(w.getData_oddania());
                    }
                    String[] row = {String.valueOf(w.getId()),w.getEgzemplarz().getKsiazka().getTytuł(), w.getEgzemplarz().getKsiazka().getAutor().getImie() + " " + w.getEgzemplarz().getKsiazka().getAutor().getNazwisko(), w.getEgzemplarz().getKsiazka().getKategoria().getNazwa(),
                    String.valueOf(formatter.format(w.getData_wypozyczenia())), returnDate, String.valueOf(w.getKara()), oddane};
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
        
        
        public DefaultTableModel searchTableModel(){
            DefaultTableModel tab = null;
            try {
                EgzemplarzDAO ed = new EgzemplarzDAO();
                String[] columnNames = {"id","Tytuł", "Autor","Kategoria", "Wydawnictwo", "Stan"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Egzemplarz e:ed.readPieces()){
                    String[] row = {String.valueOf(e.getId()), e.getKsiazka().getTytuł(), e.getKsiazka().getAutor().getNazwisko()+" "+e.getKsiazka().getAutor().getImie(), e.getKsiazka().getKategoria().getNazwa(), e.getKsiazka().getWydawnictwo().getNazwa(), String.valueOf(e.getStan())};
                    tab.addRow(row);
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }
}
