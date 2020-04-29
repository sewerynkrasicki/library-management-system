/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.KsiazkaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author 35747
 */
public class BookDetailController {
    private KsiazkaDAO ksiazka = new KsiazkaDAO();
    private String tytul;
    
    public BookDetailController(String tytul)
    {
        this.tytul = tytul;
    }
    
    public void setAuthorLabel(JLabel autor){
        try {
            String sAutor = ksiazka.getBook(tytul).getAutor().getImie() + " " + ksiazka.getBook(tytul).getAutor().getNazwisko();
            autor.setText(sAutor);
        } catch (Exception ex) {
            Logger.getLogger(BookDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCategoryLabel(JLabel category){
        try {
            String sKategoria = ksiazka.getBook(tytul).getKategoria().getNazwa();
            category.setText(sKategoria);
        } catch (Exception ex) {
            Logger.getLogger(BookDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setPublisherLabel(JLabel publisher)
    {
        try {
            String wydawnictwo = ksiazka.getBook(tytul).getWydawnictwo().getNazwa();
            publisher.setText(wydawnictwo);
        } catch (Exception ex) {
            Logger.getLogger(BookDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setDescriptionText(JTextArea text){
        try {
            String opis = ksiazka.getBook(tytul).getOpis();
            text.setText(opis);
        } catch (Exception ex) {
            Logger.getLogger(BookDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
