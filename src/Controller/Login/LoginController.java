/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Login;

import Controller.Login.Access.Access;
import Koneksi.Koneksi;
import View.Login.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ouka
 */
public class LoginController {
    private Access access;
    public LoginController(Login view){
        Koneksi conn = new Koneksi();
        PreparedStatement psManager;
        PreparedStatement psPetugas;
        PreparedStatement psMasinis;
        ResultSet rsManager;
        ResultSet rsPetugas;
        ResultSet rsMasinis;
        
        String username = view.getTxtUsername().getText();
        String password = String.valueOf(view.getTxtPassword().getPassword());
        
        if(username.trim().equals("") || password.trim().equals("")){
            view.setLblError("Username atau Password tidak boleh kosong!");
        } else{
            Connection con = conn.getConnection();
            String sqlManager = "SELECT * FROM manager WHERE USERNAME = ? AND PASSWORD = ?";
            String sqlPetugas = "SELECT * FROM petugas WHERE USERNAME = ? AND PASSWORD = ?";
            String sqlMasinis = "SELECT * FROM masinis WHERE USERNAME = ? AND PASSWORD = ?";
            
            try{
                psManager = con.prepareStatement(sqlManager);
                psManager.setString(1, username);
                psManager.setString(2, password);
                rsManager = psManager.executeQuery();
                
                psPetugas = con.prepareStatement(sqlPetugas);
                psPetugas.setString(1, username);
                psPetugas.setString(2, password);
                rsPetugas = psPetugas.executeQuery();
                
                psMasinis = con.prepareStatement(sqlManager);
                psMasinis.setString(1, username);
                psMasinis.setString(2, password);
                rsMasinis = psMasinis.executeQuery();
                
                if(rsManager.next()){
                    access = new Access("manager", rsManager.getString("ID_MANAGER"));
                    view.setVisible(false);
                } else if(rsPetugas.next()){
                    access = new Access("petugas", rsPetugas.getString("ID_PETUGAS"));
                    view.setVisible(false);
                } else if(rsMasinis.next()){
                    access = new Access("masinis", rsMasinis.getString("ID_MASINIS"));
                    view.setVisible(false);
                }else{
                    view.setLblError("Username atau Password salah!");
                }
                
            } catch(SQLException ex){
                System.err.println(ex.getMessage());

            }
        }
    }
    
}
