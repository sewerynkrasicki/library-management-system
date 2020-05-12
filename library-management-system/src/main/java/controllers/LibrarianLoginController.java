/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Bibliotekarz;
import dao.BibliotekarzDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.AdminFrame;

/**
 *
 * @author 35747
 */
public class LibrarianLoginController implements ILoginInterface{
    private String login;
    private String password;
    private BibliotekarzDAO biblid;
    private Bibliotekarz bibliotekarz;
    
    public LibrarianLoginController(JTextField login, JPasswordField password){
        this.biblid = new BibliotekarzDAO();
        this.login = login.getText();
        this.password = new String(password.getPassword());
    }
    
    public Boolean personExist() throws Exception{
        if(biblid.librarianExist(login)){
            return true;
        }
        return false;
    }
    
    public Boolean emptyFields(){
        if(login.isEmpty() || password.isEmpty())
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public void login(JFrame f) throws Exception{
        if(biblid.getLibrarianByLogin(login).getRola().getUserType().equals("librarian")){
            if(biblid.getLibrarianByLogin(login).getHaslo().equals(password)){
                bibliotekarz = biblid.getLibrarianByLogin(login);
                AdminFrame af = new AdminFrame();
                f.dispose();
                af.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Błędny login bądź hasło", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }else{
             JOptionPane.showMessageDialog(null, "Nie jesteś bibliotekarzem", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void adminLogin(JFrame f) throws Exception{
        if(biblid.getLibrarianByLogin(login).getRola().getUserType().equals("admin")){
            if(biblid.getLibrarianByLogin(login).getHaslo().equals(password)){
                bibliotekarz = biblid.getLibrarianByLogin(login);
                AdminFrame af = new AdminFrame();
                f.dispose();
                af.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Błędny login bądź hasło", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }else{
             JOptionPane.showMessageDialog(null, "Nie jesteś administratorem", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Bibliotekarz getBibliotekarz() {
        return bibliotekarz;
    }
    
}
