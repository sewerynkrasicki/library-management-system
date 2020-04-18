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
public class Kategoria {
    @Id
    private int id;
    private String nazwa;
    
    public Kategoria(){
        
    }
    
    public Kategoria(String nazwa){
        this.nazwa = nazwa;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNazwa(){
        return nazwa;
    }
    
    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }
    
    
    
}
