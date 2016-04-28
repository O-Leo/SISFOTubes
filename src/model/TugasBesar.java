/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class TugasBesar implements Serializable{
    Dokumentasi[] dokumentasi ;
    Mahasiswa[] member = new Mahasiswa[20];
    String juduldoc ;
    String judultubes ;
    int jumdoc = 0;
    int jummhs = 0;
    
    public TugasBesar(String judultubes){
        this.judultubes = judultubes;
        dokumentasi = new Dokumentasi[10];
    }
    public void addDokumentasi(Dokumentasi doc){
        if (jumdoc < 10){
            dokumentasi[jumdoc] = doc;
            jumdoc++;
        }
        else
            System.out.println("Dokumentasi sudah mencapai maksismal");
    }
    public void addMember(Mahasiswa mhs){
        if (jummhs<20){
            member[jummhs] = mhs;
            jummhs++;
        }
        else
            System.out.println("Maaf member sudah penuh");
    }
    public Dokumentasi getDokumentasi(int i){
        if(dokumentasi[i] != null){
            return dokumentasi[i];
        }
        else return null;
    }
    public Mahasiswa getMember(int i){
        if (member[i] == null){
            return null;
        }else{
            return member[i];
        }
    }
        public Mahasiswa getMemberNim(long nim){
        int i =0;
        if (member[i].getNim() == nim ){
            return member[i];
        }else{
            i++;
        }return null;
    }
    public String getNama(){
        return judultubes;
    }
    public void TampilDokumen(){
        for(int i = 0 ; i < 10;i++){
            System.out.println(i+" "+dokumentasi[i].getJudul());
        }
    }
    public void deletemember(int index){
        while(member[index] != null){
            member[index] = member[index+1];
            jummhs--;
            index++;
        }
    }
    @Override
    public String toString(){
        return juduldoc+judultubes+jummhs+jumdoc;
    }
}
