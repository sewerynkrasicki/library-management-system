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
public class Wydawnictwo {
    @Id
    int id;
    String nazwa;
    String miasto;
    String REGON;
    String NIP;
    
    public Wydawnictwo() {
    }
    
    public Wydawnictwo(String nazwa, String miasto, String REGON, String NIP) {
        this.nazwa = nazwa;
        this.miasto = miasto;
        this.REGON = REGON;
        this.NIP = NIP;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getREGON() {
        return REGON;
    }

    public void setREGON(String REGON) {
        this.REGON = REGON;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
}
