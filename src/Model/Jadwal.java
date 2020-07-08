/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ouka
 */
public class Jadwal {
    private String id_jadwal;
    private String id_kereta;
    private String id_masinis;
    private String tanggal;
    private String jam;
    private String tujuan;

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getId_kereta() {
        return id_kereta;
    }

    public void setId_kereta(String id_kereta) {
        this.id_kereta = id_kereta;
    }

    public String getId_masinis() {
        return id_masinis;
    }

    public void setId_masinis(String id_masinis) {
        this.id_masinis = id_masinis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
    
    
}
