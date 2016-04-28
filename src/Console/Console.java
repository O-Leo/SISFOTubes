/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
/**
 *
 * @author xxx
 */
public class Console {
    private Aplikasi model;
    private Scanner sInt;
    private Scanner sStr;

    public Console(Aplikasi model) {
        this.model = model;
        sInt = new Scanner(System.in);
        sStr = new Scanner(System.in);
    }

    public int inputInteger() {
        try {
            return sInt.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input must be Integer");
        } finally {
            sInt = new Scanner(System.in);
        }
    }

    public void mainMenu() {
        int pil = 0;
        int pil2 = 0;
        do {
            try {

                System.out.println("Menu");
                System.out.println("1. Buat Akun");
                System.out.println("2. Buat Tubes");
                System.out.println("3. show list Tubes");
                System.out.println("4. Join Tubes");
                System.out.println("5. Buat Dokumen");
                System.out.println("0. exit");
                System.out.print("Input menu : ");
                pil = inputInteger();
                switch (pil) {
                    case 1:
                        do{
                            try{
                        System.out.println("Buat Akun");
                        System.out.println("1. Asisten");
                        System.out.println("2. Mahasiswa");
                        System.out.println("0. Back");
                        pil2 = inputInteger();
                        switch(pil2){
                            case 1:
                                System.out.print("input name : ");
                                String name = sStr.nextLine();
                                System.out.print("Input nim : ");
                                int id = inputInteger();
                                System.out.println("input kelas :");
                                String kelas = sStr.nextLine();
                                Mahasiswa a = new Mahasiswa(name,id,kelas);
                                model.addMahasiswa(a);
                                break;
                            case 2:
                                System.out.print("input name : ");
                                name = sStr.nextLine();
                                System.out.print("Input nim : ");
                                id = inputInteger();
                                System.out.println("Input Email :");
                                String email = sStr.nextLine();
                                System.out.println("input kelas :");
                                kelas = sStr.nextLine();
                                Asisten b = new Asisten(name,id,email,kelas);
                                model.addAsisten(b);
                                break;
                            case 0:
                                System.out.println("Thank You");
                                break;
                            }
                            }catch (Exception e) {
                            System.out.println("error : " + e.getMessage());
                            }finally {
                            sInt = new Scanner(System.in);
                            sStr = new Scanner(System.in);
                            }
                            }while(pil2 != 0);
                    case 2:
                        System.out.println("input nim asisten : ");
                        long nim = inputInteger();
                        Asisten a = model.getAsisten(nim);
                        if(a != null){
                        System.out.print("input judul : ");
                        String name = sStr.nextLine();
                        a.createTugasBesar(name);
                        break;
                        }else{
                            System.out.println("Salah nim");
                        }
                    case 3:
                        System.out.println("show list Tubes");
                        for (int i = 0;model.getAsistenInt(i) != null;i++){
                            System.out.println(model.getAsistenInt(i).getTubes());
                        }
                        System.out.println("------------------------------");
                        break;
                    case 4:
                        System.out.println("input nim Mahasiswa : ");
                        nim = inputInteger();
                        Mahasiswa b = model.getMahasiswa(nim);
                        if(b != null){
                        System.out.print("Pilih index tubes : ");
                        int index = inputInteger();
                        model.getAsisten(index).getTubes().addMember(b);
                        break;
                        }else{
                            System.out.println("Salah nim");
                        }
                    case 5:
                        System.out.println("input nim Mahasiswa : ");
                        nim = inputInteger();
                        b = model.getMahasiswa(nim);
                        if(b != null){
                        System.out.println("Judul Dokumen :");
                        String judul = sStr.nextLine();
                        Dokumentasi doc = new Dokumentasi(judul);
                        b.getTubes().addDokumentasi(doc);
                        break;
                        }
                    case 0:
                        System.out.println("Thank You");
                        break;
                    default:
                        throw new IllegalStateException("Wrong Menu Input");
                }
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            } finally {
                sInt = new Scanner(System.in);
                sStr = new Scanner(System.in);
            }
        } while (pil != 0);
    }
}
