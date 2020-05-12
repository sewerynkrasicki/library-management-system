/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 35747
 */
@Entity
public class Egzemplarz {
    @Id
    private int id;
    @Column(nullable=false)
    private int stan;
    @Column(nullable=false)
    private boolean dostepna;
    @ManyToOne(targetEntity=Ksiazka.class, optional=false)
    private Ksiazka ksiazka;

    public Egzemplarz() {
    }
    
    

    public Egzemplarz(int stan, boolean dostepna, Ksiazka ksiazka) {
        this.stan = stan;
        this.dostepna = dostepna;
        this.ksiazka = ksiazka;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    public boolean getDostepna() {
        return dostepna;
    }

    public void setDostepna(boolean dostepna) {
        this.dostepna = dostepna;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }
}
