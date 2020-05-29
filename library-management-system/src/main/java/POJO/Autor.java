package POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 35747
 */
@Entity
public class Autor {
    @Id
    private int id;
    @Column(nullable=false)
    private String imie;
    @Column(nullable=false)
    private String nazwisko;
    @Column(nullable=false)
    private String miejsceUrodzenia;
    @Column(nullable=false)
    private String wiekDzialania;
    
    public Autor(){
        
    }
    
    public Autor(String imie, String nazwisko, String miejsceUrodzenia, String wiekDzialania){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miejsceUrodzenia = miejsceUrodzenia;
        this.wiekDzialania = wiekDzialania;
    }
    

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getMiejsceUrodzenia() {
        return miejsceUrodzenia;
    }

    public String getWiekDzialania() {
        return wiekDzialania;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setMiejsceUrodzenia(String miejsceUrodzenia) {
        this.miejsceUrodzenia = miejsceUrodzenia;
    }

    public void setWiekDzialania(String wiekDzialania) {
        this.wiekDzialania = wiekDzialania;
    }
    
    @Override
    public String toString() {
        return getImie()+ " " + getNazwisko();
    }
}

