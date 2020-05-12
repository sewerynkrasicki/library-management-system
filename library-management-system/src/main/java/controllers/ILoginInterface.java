/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JFrame;

/**
 *
 * @author 35747
 */
public interface ILoginInterface {
    public Boolean personExist() throws Exception;
    public Boolean emptyFields();
    public void login(JFrame f) throws Exception;
}
