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
public class Mahasiswa extends Orang implements Serializable{
    String kelas;
    TugasBesar tb;
    public Mahasiswa (String nama , long nim,String kelas){
        super(nama,nim);
        this.kelas = kelas;
    }
    public void setTubes(TugasBesar judul){
        tb = judul;
    }
    public TugasBesar getTubes(){
        if (tb == null){
            return null;
        }
        else {
            return tb;
        }    
    }
    @Override
    public String toString(){
        return nama+nim;
    }
}