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
public class TugasBesar {
    Dokumentasi[] dokumentasi ;
    Mahasiswa[] member = new Mahasiswa[20];
    String juduldoc;
    String judultubes;
    int jumdoc = 0;
    int jummhs = 0;
    
    public TugasBesar(String judultubes){
        this.judultubes = judultubes;
        dokumentasi = new Dokumentasi[10];
    }
    public void addDokumentasi(String juduldoc){
        if (jumdoc < 10){
            dokumentasi[jumdoc].setJudul(juduldoc);
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
        return dokumentasi[i];
    }
    public Mahasiswa getMember(int i){
        return member[i];
    }
}
