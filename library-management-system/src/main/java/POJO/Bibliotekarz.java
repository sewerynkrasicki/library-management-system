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
public class Bibliotekarz {
    @Id
    int id;
    @Column(nullable=false)
    String imie;
    @Column(nullable=false)
    String nazwisko;
    @Column(nullable=false)
    String login;
    @Column(nullable=false)
    String haslo;
    @Column(nullable=false)
    String email;
    @Column(nullable=false)
    @ManyToOne(targetEntity=Adres.class, optional=false)
    Adres adres;
    @Column(nullable=false)
    @ManyToOne(targetEntity=Rola.class, optional=false)
    Rola rola;

    public Bibliotekarz() {
    }

    public Bibliotekarz(String imie, String nazwisko, String login, String haslo, String email, Adres adres, Rola rola) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.adres = adres;
        this.rola = rola;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
    }
    
    
}
