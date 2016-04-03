/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SISFOTubes;

/**
 *
 * @author xxx
 */
public class Dokumentasi {
    String judul;
    public Dokumentasi(String judul){
        this.judul = judul;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public String getJudul(){
        return judul;
    }
    @Override
    public String toString(){
        return judul;
    }
}
