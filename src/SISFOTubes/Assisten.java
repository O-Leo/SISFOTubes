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
public class Assisten extends Orang {
    TugasBesar tb;
    public Assisten (String nama,long nim){
        super(nama,nim);
    }
    public void createTugasBesar(String judul){
        tb = new TugasBesar(judul);
    }
}
