/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Czytelnik;
import POJO.Egzemplarz;
import dao.EgzemplarzDAO;
import dao.WypożyczenieDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.additional.crud.LendCreator;

/**
 *
 * @author 35747
 */
public class LendController {
        public void lendActionPerformed(JTable lendTable, Czytelnik czytelnik) {                                           
        try {
            if(lendTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Musisz zaznaczyć rekord, aby go wypożyczyć.", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
                EgzemplarzDAO egzd = new EgzemplarzDAO();
                WypożyczenieDAO wypozyczenied = new WypożyczenieDAO();
                int selectedRow = lendTable.getSelectedRow();
                DefaultTableModel dt = (DefaultTableModel)lendTable.getModel();
                int id = Integer.parseInt(dt.getValueAt(selectedRow, 0).toString());
                Egzemplarz egzemplarz = egzd.getPiece(id);
                if(egzemplarz.getStan()==0){
                    JOptionPane.showMessageDialog(null, "Niestety, nie mamy teraz tej książki na stanie.", "ERROR", JOptionPane.WARNING_MESSAGE);
                }else{
                    wypozyczenied.createLend(czytelnik.getId(), id);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(LendCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
