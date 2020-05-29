/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import javax.persistence.Column;
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
    @Column(nullable=false)
    private String miasto;
    @Column(nullable=false)
    private String ulica;
    @Column(nullable=false)
    private String kodPocztowy;
    @Column(nullable=false)
    private String numerDomu;
    public Adres() {
    }
    
    
    public Adres(String miasto, String ulica, String kodPocztowy, String numerDomu) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.kodPocztowy = kodPocztowy;
        this.numerDomu = numerDomu;
    }
    
    
    public String getNumerDomu() {
        return numerDomu;
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
    
    public void setNumerDomu(String numerDomu) {
        this.numerDomu = numerDomu;
    }
    
    @Override
    public String toString() {
        return getMiasto()+" "+getUlica()+" "+getNumerDomu();
    }
}
