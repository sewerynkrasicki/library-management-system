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
public class Ksiazka {
    @Id
    private int id;
    @Column(nullable=false)
    private String tytuł;
    @Column(nullable=false)
    private String opis;
    @Column(nullable=false)
    private int rokWydania;
    @Column(nullable=false)
    private double cenaBiblioteki;
    @Column(nullable=false)
    @ManyToOne(targetEntity=Kategoria.class, optional=false)
    private Kategoria kategoria;
    @Column(nullable=false)
    @ManyToOne(targetEntity=Autor.class, optional=false)
    private Autor autor;
    @Column(nullable=false)
    @ManyToOne(targetEntity=Wydawnictwo.class, optional=false)
    private Wydawnictwo wydawnictwo;

    public Ksiazka() {
    }

    public Ksiazka(String tytuł, String opis, int rokWydania, double cenaBiblioteki, Kategoria kategoria, Autor autor, Wydawnictwo wydawnictwo) {
        this.tytuł = tytuł;
        this.opis = opis;
        this.rokWydania = rokWydania;
        this.cenaBiblioteki = cenaBiblioteki;
        this.kategoria = kategoria;
        this.autor = autor;
        this.wydawnictwo = wydawnictwo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public double getCenaBiblioteki() {
        return cenaBiblioteki;
    }

    public void setCenaBiblioteki(double cenaBiblioteki) {
        this.cenaBiblioteki = cenaBiblioteki;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Wydawnictwo getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(Wydawnictwo wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }
    
    @Override
    public String toString() {
        return getTytuł();
    }
    
    
    
}
