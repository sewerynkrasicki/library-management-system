/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Wypozyczenia;
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
public class ReturnLendController {
        public void returnLendActionPerformed(JTable lendTable) {                                           
        try {
            if(lendTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Musisz zaznaczyć rekord, aby go oddać.", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
                WypożyczenieDAO wypozyczenied = new WypożyczenieDAO();
                int selectedRow = lendTable.getSelectedRow();
                DefaultTableModel dt = (DefaultTableModel)lendTable.getModel();
                int id = Integer.parseInt(dt.getValueAt(selectedRow, 0).toString());
                Wypozyczenia wypozyczenie = wypozyczenied.getLend(id);
                if(wypozyczenie.getOddane()==true){
                    JOptionPane.showMessageDialog(null, "Już oddałeś tą książkę!!", "ERROR", JOptionPane.WARNING_MESSAGE);
                }else{
                    wypozyczenied.returnLend(wypozyczenie);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(LendCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
