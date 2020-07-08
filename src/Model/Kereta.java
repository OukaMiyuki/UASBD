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
public class Kereta {
    private String id_kereta;
    private String Nama_Kereta;
    private String id_kelas;
    private int gerbong;

    public String getId_kereta() {
        return id_kereta;
    }

    public void setId_kereta(String id_kereta) {
        this.id_kereta = id_kereta;
    }

    public String getNama_Kereta() {
        return Nama_Kereta;
    }

    public void setNama_Kereta(String Nama_Kereta) {
        this.Nama_Kereta = Nama_Kereta;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public int getGerbong() {
        return gerbong;
    }

    public void setGerbong(int gerbong) {
        this.gerbong = gerbong;
    }
}
