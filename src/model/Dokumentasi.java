/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author xxx
 */
public class Dokumentasi implements Serializable{
    String judul;
    public Dokumentasi(String judul){
        this.judul = judul+"abc";
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public String getJudul(){
        if(judul != null){
            return judul;
        }
        else return null;
    }
    @Override
    public String toString(){
        return judul;
    }
}
