/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.AdresDAO;
import dao.CzytelnikDAO;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.LoginForm;

/**
 *
 * @author 35747
 */
public class NewAccountController {
    public void createAccount(JFrame frame, String loginField, String passwordField, 
            String fNameField, String sNameField, String emailField, String cityField,
            String streetField, String postalCodeField, String houseNumberField) throws Exception{
        CzytelnikDAO czytd = new CzytelnikDAO();    
            if((loginField.isEmpty() || passwordField.length() == 0 || fNameField.isEmpty()
                    || sNameField.isEmpty() || emailField.isEmpty() || cityField.isEmpty()
                    || streetField.isEmpty() || postalCodeField.isEmpty() || houseNumberField.isEmpty())){
                JOptionPane.showMessageDialog(frame, "Wszystkie pola muszą zostać uzupełnione!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else if((loginField.length() > 30 || loginField.length() < 8 || passwordField.length() > 30 || passwordField.length() < 8)){
                JOptionPane.showMessageDialog(frame, "Login i hasło powinny mieć od 8 do 30 znaków !!!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else if((fNameField.length() > 30 || sNameField.length() > 30 || cityField.length() > 30 || streetField.length() > 30  || !Pattern.matches("[a-zA-Z]*", fNameField)
                    || !Pattern.matches("[a-zA-Z]*", sNameField) || !Pattern.matches("[a-zA-Z]*", cityField) || !Pattern.matches("[a-zA-Z]*", streetField)))
            {
                JOptionPane.showMessageDialog(frame, "Imie, nazwisko, miasto oraz ulica powinny zawierać do 30 liter!!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else if(!Pattern.matches("[0-9][0-9]-[0-9][0-9][0-9]", postalCodeField))
            {
                JOptionPane.showMessageDialog(frame, "Kod pocztowy powinien składać się z dwóch cyfr, myślnika i trzech cyfr. Przykład: 14-500", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else if((!Pattern.matches("[a-zA-Z0-9]+",  houseNumberField) ||  houseNumberField.length() > 4))
            {
                JOptionPane.showMessageDialog(frame, "Numer domów nie powinen zawierać więcej niż 4 znaki - tylko litery oraz cyfry.", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else if((!Pattern.matches("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$",  emailField) || emailField.length() > 255))
            {
                JOptionPane.showMessageDialog(frame, "Email powinen być w dobrej formie i mieć nie więcej niż 255 znaków.", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else if(czytd.readerExist(loginField)){
                JOptionPane.showMessageDialog(frame, "Użytkownik o takim loginie już istnieje w bazie!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else if(czytd.emailExist(emailField)){
                JOptionPane.showMessageDialog(frame, "Email zajęty.", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            else{
                AdresDAO adrd = new AdresDAO();
                int adr = adrd.createAddress(cityField, streetField, postalCodeField, houseNumberField).getId();
                String welcome = czytd.createReader(fNameField, sNameField, loginField, passwordField, emailField, adr, 2).getImie();
                frame.dispose();
                LoginForm lf = new LoginForm();
                lf.setVisible(true);
                JOptionPane.showMessageDialog(lf, welcome+" zostałeś pomyślnie zarejestrowany!", "Witaj!", JOptionPane.INFORMATION_MESSAGE);
            }
    }
}
