/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import POJO.Czytelnik;
import dao.CzytelnikDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.Application;

/**
 *
 * @author 35747
 */
public class UserLoginController implements ILoginInterface {
    private String login;
    private String password;
    private CzytelnikDAO czytd;
    private Czytelnik czytelnik;
    
    public UserLoginController(JTextField login, JPasswordField password){
        this.czytd = new CzytelnikDAO();
        this.login = login.getText();
        this.password = new String(password.getPassword());
    }
    
    public Boolean personExist() throws Exception{
        if(czytd.readerExist(login)){
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
        if(czytd.getReaderByLogin(login).getRola().getUserType().equals("user")){
            if(czytd.getReaderByLogin(login).getHaslo().equals(password)){
                czytelnik = czytd.getReaderByLogin(login);
                Application app = new Application(czytelnik);
                f.dispose();
                app.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Błędny login bądź hasło", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }else{
             JOptionPane.showMessageDialog(null, "Nie jesteś użytkownikiem", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }
}
