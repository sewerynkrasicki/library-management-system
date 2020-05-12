/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Egzemplarz;
import dao.EgzemplarzDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 35747
 */
public class SearchByController {
    
        public DefaultTableModel searchByTitle(JTextField str){
            String tytul = str.getText();
            DefaultTableModel tab = null;
            try {
                EgzemplarzDAO ed = new EgzemplarzDAO();
                String[] columnNames = {"id", "Tytuł", "Autor","Kategoria", "Wydawnictwo", "Stan"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Egzemplarz e:ed.readPieces()){
                    if(e.getKsiazka().getTytuł().equals(tytul)){
                    String[] row = {String.valueOf(e.getId()), e.getKsiazka().getTytuł(), e.getKsiazka().getAutor().getNazwisko()+" "+e.getKsiazka().getAutor().getImie(), e.getKsiazka().getKategoria().getNazwa(), e.getKsiazka().getWydawnictwo().getNazwa(), String.valueOf(e.getStan())};
                    tab.addRow(row);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }
    
    public DefaultTableModel searchByCategory(JTextField str){
            String kategoria = str.getText();
            DefaultTableModel tab = null;
            try {
                EgzemplarzDAO ed = new EgzemplarzDAO();
                String[] columnNames = {"id","Tytuł", "Autor","Kategoria", "Wydawnictwo", "Stan"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Egzemplarz e:ed.readPieces()){
                    if(e.getKsiazka().getKategoria().getNazwa().equals(kategoria)){
                    String[] row = {String.valueOf(e.getId()), e.getKsiazka().getTytuł(), e.getKsiazka().getAutor().getNazwisko()+" "+e.getKsiazka().getAutor().getImie(), e.getKsiazka().getKategoria().getNazwa(), e.getKsiazka().getWydawnictwo().getNazwa(), String.valueOf(e.getStan())};
                    tab.addRow(row);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }
    
    public DefaultTableModel searchByAuthor(JTextField str){
            String autor = str.getText();
            DefaultTableModel tab = null;
            try {
                EgzemplarzDAO ed = new EgzemplarzDAO();
                String[] columnNames = {"id","Tytuł", "Autor","Kategoria", "Wydawnictwo", "Stan"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Egzemplarz e:ed.readPieces()){
                    if(e.getKsiazka().getAutor().getNazwisko().equals(autor)){
                    String[] row = {String.valueOf(e.getId()), e.getKsiazka().getTytuł(), e.getKsiazka().getAutor().getNazwisko()+" "+e.getKsiazka().getAutor().getImie(), e.getKsiazka().getKategoria().getNazwa(), e.getKsiazka().getWydawnictwo().getNazwa(), String.valueOf(e.getStan())};
                    tab.addRow(row);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }
    
        public DefaultTableModel searchByPublisher(JTextField str){
            String wydawca = str.getText();
            DefaultTableModel tab = null;
            try {
                EgzemplarzDAO ed = new EgzemplarzDAO();
                String[] columnNames = {"id","Tytuł", "Autor","Kategoria", "Wydawnictwo", "Stan"};
                tab = new DefaultTableModel(columnNames, 0);
                for(Egzemplarz e:ed.readPieces()){
                    if(e.getKsiazka().getWydawnictwo().getNazwa().equals(wydawca)){
                    String[] row = {String.valueOf(e.getId()), e.getKsiazka().getTytuł(), e.getKsiazka().getAutor().getNazwisko()+" "+e.getKsiazka().getAutor().getImie(), e.getKsiazka().getKategoria().getNazwa(), e.getKsiazka().getWydawnictwo().getNazwa(), String.valueOf(e.getStan())};
                    tab.addRow(row);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(DataTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tab;
    }
}
