/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import model.*;
import viewB.*;

public class ControllerB extends MouseAdapter implements ActionListener{
    private Aplikasi model;
    private View view;
    private Asisten asisten;
    private Mahasiswa mahasiswa;
    private String kumpulan;
    private String tdokumen;
    private String kd;
    private String dd;
    private int angka = 0;
    private int banyak ;
    private String anak ;
    private int nomember = 0;
    

    public ControllerB(Aplikasi model) {
        this.model = model;
        HomePage m = new HomePage();
        m.setVisible(true);
        m.addListener((ActionListener) this);
        view = m;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (view instanceof HomePage) {
            HomePage m = (HomePage) view;
            if (source.equals(m.getBtnAsisten())) {
                LoginAsisten e = new LoginAsisten();
                e.setVisible(true);
                e.addListener(this);
                m.dispose();
                view = e;
            } else if (source.equals(m.getBtnMahasiswa())) {
                LoginMahasiswa v = new LoginMahasiswa();
                v.setVisible(true);
                v.addListener(this);
                m.dispose();
                view = v;
            } else if (source.equals(m.getBtnAkun())) {
                PilihUser p = new PilihUser();
                p.setVisible(true);
                p.addListener(this);
                m.dispose();
                view = p;
            }
        }else if (view instanceof PilihUser) {
            PilihUser p = (PilihUser) view;
            if (source.equals(p.getBtnAsisten())) {
                BuatAsisten ba = new BuatAsisten();
                ba.setVisible(true);
                ba.addListener(this);
                p.dispose();
                view = ba;
            } else if (source.equals(p.getBtnMahasiswa())) {
                BuatMahasiswa bm = new BuatMahasiswa();
                bm.setVisible(true);
                bm.addListener(this);
                p.dispose();
                view = bm;
            }
        }else if (view instanceof BuatAsisten) {
            BuatAsisten e = (BuatAsisten) view;
            if (source.equals(e.getBtnSimpan())){
                String name = e.getnama();
                long nim = e.getnim();
                String email = e.getemail();
                String matkul = e.getmatkul();
                if ("".equals(name)){
                     JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }else if (nim == 0){
                      JOptionPane.showMessageDialog(null,"Tidak asd kosong");
                }else if ("".equals(email)){
                      JOptionPane.showMessageDialog(null,"Tidak Boleh kosong"); 
                }else if ("".equals(matkul)){
                      JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }else{
                    Asisten a = new Asisten(name,nim,matkul,email);
                    model.addAsisten(a);
                    try {
                        model.saveAsisten();
                    } catch (IOException ex) {
                        e.viewErrorMsg(ex.getMessage());
                    }
                    Notifikasi n = new Notifikasi();
                    n.setVisible(true);
                    n.addListener(this);
                    e.dispose();
                    view = n;
                }
            }
        }else if (view instanceof Notifikasi){
            Notifikasi n = (Notifikasi) view;
            if (source.equals(n.getOK())){
                HomePage m = new HomePage();
                m.setVisible(true);
                m.addListener(this);
                n.dispose();
                view = m;
            }
        }else if(view instanceof BuatMahasiswa){
            BuatMahasiswa e = (BuatMahasiswa) view;
            if (source.equals(e.getBtnSimpan())){
                String name = e.getnama();
                long nim = e.getnim();
                String kelas = e.getkelas();
                if ("".equals(name)){
                     JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }else if (nim == 0){
                      JOptionPane.showMessageDialog(null,"Tidak Boleh kosong");
                }else if ("".equals(kelas)){
                      JOptionPane.showMessageDialog(null,"Tidak Boleh kosong"); 
                }else { 
                    Mahasiswa a = new Mahasiswa(name,nim,kelas);
                    model.addMahasiswa(a);
                    try {
                        model.saveMahasiswa();
                    } catch (IOException ex) {
                        e.viewErrorMsg(ex.getMessage());
                    }
                    Notifikasi n = new Notifikasi();
                    n.setVisible(true);
                    n.addListener(this);
                    e.dispose();
                    view = n;
                }
            } 
        }else if(view instanceof LoginAsisten){
            LoginAsisten la = (LoginAsisten) view;
            if (source.equals(la.getBtnLogin())){
                asisten = model.getAsisten(la.getnim());
                if(model.getAsisten(la.getnim()) != null){
                HomeAsisten n = new HomeAsisten();
                n.setNama(asisten.getNama());
                n.setNim(asisten.getNim());
                if(asisten.getTubes() != null && asisten.getTubes().getMember(0) == null){
                    n.display(asisten.getTubes().getNama()+"\n Anggota : ");
                }else if(asisten.getTubes() != null && asisten.getTubes().getMember(0) != null){
                    while (asisten.getTubes().getMember(nomember) != null){
                        if(anak == null){
                            banyak++;
                            anak = banyak +". "+ asisten.getTubes().getMember(nomember).getNama();
                            nomember++;
                        }else if(asisten.getTubes().getMember(nomember) != asisten.getTubes().getMember(nomember+1)){
                            banyak++;
                            anak = anak + "\n"+banyak+". "+asisten.getTubes().getMember(nomember).getNama();
                            nomember++;
                        }
                    }
                    n.display(asisten.getTubes().getNama()+"\n Anggota : "+"\n"+anak);
                }
                if(asisten.getTubes() != null && asisten.getTubes().getDokumentasi(0) != null){
                    int b = 0;
                    while(asisten.getTubes().getDokumentasi(b) != null)
                        if (kd == null){
                            kd = (b+1) +". "+asisten.getTubes().getDokumentasi(b).getJudul();
                            b++;
                        }else{
                            kd = kd +"\n"+(b+1) +". "+ asisten.getTubes().getDokumentasi(b).getJudul();
                            b++;
                        }
                    n.display2(kd);
                }
                n.setVisible(true);
                n.addListener(this);
                la.dispose();
                view = n;
                }else{
                    Gagal g = new Gagal();
                    g.setVisible(true);
                    g.addListener(this);
                    la.dispose();
                    view = g;
                }
            }else if (source.equals(la.getBack())){
                HomePage m = new HomePage();
                m.setVisible(true);
                m.addListener(this);
                la.dispose();
                view = m;
            }
        }else if(view instanceof HomeAsisten){
            HomeAsisten ha = (HomeAsisten) view;
            if (source.equals(ha.getadd())){
                String tubes = ha.getTubes();
                asisten.createTugasBesar(ha.getTubes());
                if (kumpulan == null){
                    angka++;
                    kumpulan = angka+". "+tubes;
                }else{
                    angka++;
                    kumpulan =  kumpulan +"\n"+angka+". "+ tubes;
                }
                ha.display(tubes+"\n Anggota : ");
            }else if (source.equals(ha.getlogout())){
                HomePage m = new HomePage();
                m.setVisible(true);
                m.addListener(this);
                ha.dispose();
                view = m;
            }else if(source.equals(ha.getdelete())){
                asisten.getTubes().getMember(ha.getcombo()).setTubes(null);
                asisten.getTubes().deletemember(ha.getcombo());
                anak = null;
                kumpulan = null;
                nomember = 0;
                banyak = 0;
            }
        }else if (view instanceof Gagal){
            Gagal n = (Gagal) view;
            if (source.equals(n.getOK())){
                LoginAsisten m = new LoginAsisten();
                m.setVisible(true);
                m.addListener(this);
                n.dispose();
                view = m;
            }
        }else if(view instanceof LoginMahasiswa){
            LoginMahasiswa la = (LoginMahasiswa) view;
            if (source.equals(la.getBtnLogin())){
                try {
                    model.loadMahasiswa();
                } catch (IOException ex) {
                    la.viewErrorMsg(ex.getMessage());
                }
                mahasiswa = model.getMahasiswa(la.getnim());
                if(model.getMahasiswa(la.getnim()) != null){
                HomeMahasiswa n = new HomeMahasiswa();
                n.setNama(mahasiswa.getNama());
                n.setNim(mahasiswa.getNim());
                n.display("Daftar Tubes :\n"+kumpulan);
                if(mahasiswa.getTubes() != null){
                    n.setjudul(mahasiswa.getTubes().getNama());
                }
                n.setVisible(true);
                n.addListener(this);
                la.dispose();
                view = n;
                }else{
                    GagalLagi g = new GagalLagi();
                    g.setVisible(true);
                    g.addListener(this);
                    la.dispose();
                    view = g;
                }
            }else if (source.equals(la.getBack())){
                HomePage m = new HomePage();
                m.setVisible(true);
                m.addListener(this);
                la.dispose();
                view = m;
            }
        }else if (view instanceof GagalLagi){
            GagalLagi n = (GagalLagi) view;
            if (source.equals(n.getOK())){
                LoginMahasiswa m = new LoginMahasiswa();
                m.setVisible(true);
                m.addListener(this);
                n.dispose();
                view = m;
            }
        }else if(view instanceof HomeMahasiswa){
            HomeMahasiswa ha = (HomeMahasiswa) view;
            ha.getjudul();
            if (source.equals(ha.getok())){
                int urutan =  ha.getcombo();
                TugasBesar tb = model.getAsistenInt(urutan).getTubes();
                model.getAsistenInt(urutan).getTubes().addMember(mahasiswa);
                ha.setjudul(model.getAsistenInt(urutan).getTubes().getNama());
                mahasiswa.setTubes(tb);
                try {
                        model.saveMahasiswa();
                    } catch (IOException ex) {
                        ha.viewErrorMsg(ex.getMessage());
                    }
            }else if (source.equals(ha.getadd())){
                if ("".equals(ha.getjudul())){
                     JOptionPane.showMessageDialog(null,"Belum Mengambil Tubes");
                }else{
                    Dokumentasi dokumen = new Dokumentasi (ha.getDokumen());
                    mahasiswa.getTubes().addDokumentasi(dokumen);
                    int jumdok = 1;
                        if( dd == null){
                        dd = jumdok +". "+dokumen.getJudul();
                        jumdok++;
                    }else{
                        dd = dd+"\n"+ jumdok +". "+dokumen.getJudul();
                        jumdok++;
                    }
                    ha.display2(dd);
                    try {
                        model.saveMahasiswa();
                    } catch (IOException ex) {
                        ha.viewErrorMsg(ex.getMessage());
                    }
                }
            }else if (source.equals(ha.getlogout())){
                HomePage m = new HomePage();
                m.setVisible(true);
                m.addListener(this);
                ha.dispose();
                view = m;
            }
        }
    }        
}