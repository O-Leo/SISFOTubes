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
public abstract class Orang {
    String nama;
    long nim;
    public Orang(String nama,long nim){
        this.nama = nama;
        this.nim = nim;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setNim(long nim){
        this.nim = nim;
    }
    public String getNama(){
        return nama;
    }
    public long getNim(){
        return nim;
    }
}
