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
public class Asisten extends Orang implements Serializable{
    TugasBesar tb ;
    String email;
    String matkul;
    public Asisten (String nama,long nim,String e,String m){
        super(nama,nim);
        email = e;
        matkul = m;
    }
    public void createTugasBesar(String judul){
        tb = new TugasBesar(judul);
    }
    public TugasBesar getTubes(){
        if(tb != null){
            return tb;
        }else return null;
    }
    @Override
    public String toString(){
        return nama+nim;
    }
}
