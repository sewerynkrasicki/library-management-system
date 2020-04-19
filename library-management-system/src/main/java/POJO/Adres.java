/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author 35747
 */
@Entity
public class Adres {
    @Id
    private int id;
    private String miasto;
    private String ulica;
    private String kodPocztowy;
    
    public Adres() {
    }
    
    
    public Adres(int id, String miasto, String ulica, String kodPocztowy) {
        this.id = id;
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
    }
    
    
    public int getId() {
        return id;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
    
}
