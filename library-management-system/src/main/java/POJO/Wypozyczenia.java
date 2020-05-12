/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.joda.time.LocalDate;

/**
 *
 * @author 35747
 */

@Entity
public class Wypozyczenia {
    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date data_wypozyczenia;
    @Temporal(TemporalType.DATE)
    @Column(nullable=true)
    private Date data_oddania;
    @Column(nullable=false)
    @ManyToOne(targetEntity=Egzemplarz.class)
    private Egzemplarz egzemplarz;
    @Column(nullable=false)
    @ManyToOne(targetEntity=Czytelnik.class, optional=false)
    private Czytelnik czytelnik;
    @Column(nullable=false)
    private double kara;
    @Column(nullable=false)
    private boolean oddane;

    public Wypozyczenia() {
    }

    public Wypozyczenia(Date data_wypozyczenia, Date data_oddania, Egzemplarz egzemplarz, Czytelnik czytelnik, double kara, boolean oddane) {
        this.data_wypozyczenia = data_wypozyczenia;
        this.data_oddania = data_oddania;
        this.egzemplarz = egzemplarz;
        this.czytelnik = czytelnik;
        this.kara=kara;
        this.oddane=oddane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_wypozyczenia() {
        return data_wypozyczenia;
    }

    public void setData_wypozyczenia(Date data_wypozyczenia) {
        this.data_wypozyczenia = data_wypozyczenia;
    }

    public Date getData_oddania() {
        return data_oddania;
    }

    public void setData_oddania(Date data_oddania) {
        this.data_oddania = data_oddania;
    }

    public Egzemplarz getEgzemplarz() {
        return egzemplarz;
    }

    public void setEgzemplarz(Egzemplarz egzemplarz) {
        this.egzemplarz = egzemplarz;
    }

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }

    public double getKara() {
        return kara;
    }

    public void setKara(double kara) {
        this.kara = kara;
    }

    public boolean getOddane() {
        return oddane;
    }

    public void setOddane(boolean oddane) {
        this.oddane = oddane;
    }
}
