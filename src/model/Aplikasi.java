/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import database.FileIO;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author xxx
 */
public class Aplikasi {
    private Asisten[] daftarAsisten ;
    private Mahasiswa[] daftarMahasiswa ;
    private int banyakAsis = 0;
    private int banyakMhs = 0;
    private FileIO save;
    private int a = 0;
    
    public Aplikasi(){
        daftarAsisten = new Asisten[20];
        daftarMahasiswa = new Mahasiswa [20];
        save = new FileIO();
    }
    
    public void addAsisten(Asisten a){
        daftarAsisten[banyakAsis] = a;
        banyakAsis++;
    }
    public void addMahasiswa(Mahasiswa m){
    daftarMahasiswa[banyakMhs] = m;
    banyakMhs++;
    }
    public Mahasiswa getMahasiswa(long nim){
        int i =0;
        //if (banyakMhs == 0 ){
            //return null;
        //}else 
        if (daftarMahasiswa[i].getNim() != nim){
            i++;
        }else if (daftarMahasiswa[i].getNim() == nim){
            return daftarMahasiswa[i];
        }
        return null;
    }
    public Asisten getAsisten(long nim){
        int i =0;
        /*if(banyakAsis == 0){
            return null;
        }
        else if(banyakAsis != 0){
            while(i < banyakAsis){
            if (daftarAsisten[i].getNim() != nim){
                i++;
            }else if (daftarAsisten[i].getNim() == nim){
                return daftarAsisten[i];
            }
        }*/
        if (daftarAsisten[i].getNim() != nim){
            i++;
        }else if (daftarAsisten[i].getNim() == nim){
            return daftarAsisten[i];
        }return null;
    }
    public Mahasiswa getMahasiswaInt(int i){
        return daftarMahasiswa[i];
    }
    public Asisten getAsistenInt(int i){
        return daftarAsisten[i];
    }
    public void deletMahasiswa(long nim){
        int i = 0;
        if (daftarMahasiswa[i].getNim() != nim){
            i++;
        }
        daftarMahasiswa[i]=daftarMahasiswa[i-1];
    }
    public void deletMahasiswaIndex(int index){
        daftarMahasiswa[index] = null;
    }
    public void loadMahasiswa() throws FileNotFoundException, IOException {
        try {
            daftarMahasiswa = (Mahasiswa[])save.getObject("MHS.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("MHS.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarMahasiswa = new Mahasiswa[20];
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            throw new IOException("error " + ex.getMessage());
        }
    }
    public void loadAsisten() throws FileNotFoundException, IOException {
        try {
            daftarAsisten = (Asisten[]) save.getObject("Asis.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("Asis.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarAsisten = new Asisten[20];
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            throw new IOException("error " + ex.getMessage());
        }
    }
    public void saveAsisten() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarAsisten, "Asis.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    public void saveMahasiswa() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarMahasiswa, "MHS.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
}
