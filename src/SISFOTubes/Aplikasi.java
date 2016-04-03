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
public class Aplikasi {
    private Asisten[] daftarAsisten = new Asisten[20];
    private Mahasiswa[] daftarMahasiswa = new Mahasiswa [20];
    private int banyakAsis = 0;
    private int banyakMhs = 0;
    
    public void addAsisten(Asisten a){
        daftarAsisten[banyakAsis] = a;
        banyakAsis++;
    }
    public void addAsisten(Mahasiswa m){
    daftarMahasiswa[banyakMhs] = m;
    banyakMhs++;
    }
    public Mahasiswa getMahasiswa(long nim){
        int i =0;
        if (daftarMahasiswa[i].getNim() != nim){
            i++;
        }
        return daftarMahasiswa[i];
    }
    public void deletMahasiswa(long nim){
        int i = 0;
        if (daftarMahasiswa[i].getNim() != nim){
            i++;
        }
        daftarMahasiswa[i]=null;
        daftarMahasiswa[i]=daftarMahasiswa[i-1];
    }
}
