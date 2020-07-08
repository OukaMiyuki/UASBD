/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Petugas;

import Koneksi.Koneksi;
import Model.Petugas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ouka
 */
public class petugasController {
    private Koneksi conn = new Koneksi();
    private String insert = "INSERT INTO petugas(ID_PETUGAS, NAMA, NO_KTP, ALAMAT, TGL_LAHIR, USERNAME, PASSWORD) VALUES(?,?,?,?,?,?,?)";
    private String update = "UPDATE petugas SET NAMA = ?, NO_KTP = ?, ALAMAT = ?, TGL_LAHIR = ?, USERNAME = ?, PASSWORD = ? WHERE ID_PETUGAS = ?";
    private String delete = "DELETE FROM petugas WHERE ID_PETUGAS = ?";
    private String selectAll = "SELECT * FROM petugas ORDER BY id_petugas ASC";
    
    public void insertRecord(Petugas petugas) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(insert);
            ps.setString(1, petugas.getId_petugas());
            ps.setString(2, petugas.getNama());
            ps.setString(3, petugas.getNo_ktp());
            ps.setString(4, petugas.getAlamat());
            ps.setString(5, petugas.getTgl_lahir());
            ps.setString(6, petugas.getUsername());
            ps.setString(7, petugas.getPassword());
            ps.executeUpdate();
            con.commit();
            JOptionPane.showMessageDialog(null, "Data Inserted!");
        } catch(SQLException e){
            try{
                con.rollback();
            } catch(SQLException ex){
            
            }
            throw new SQLException(e.getMessage());
        } finally{
            try{
                con.setAutoCommit(true);
            } catch(SQLException ex){
            
            }
            if(ps != null){
                try{
                    ps.close();
                } catch(SQLException ex){
                }
            }
        }
    }
    
    public void updateRecord(Petugas petugas) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(update);
            ps.setString(1, petugas.getNama());
            ps.setString(2, petugas.getNo_ktp());
            ps.setString(3, petugas.getAlamat());
            ps.setString(4, petugas.getTgl_lahir());
            ps.setString(5, petugas.getUsername());
            ps.setString(6, petugas.getPassword());
            ps.setString(7, petugas.getId_petugas());
            ps.executeUpdate();
            con.commit();
            JOptionPane.showMessageDialog(null, "Data Updated!!");
        } catch(SQLException e){
            try{
                con.rollback();
            } catch(SQLException ex){
            
            }
            throw new SQLException(e.getMessage());
        } finally{
            try{
                con.setAutoCommit(true);
            } catch(SQLException ex){
            
            }
            if(ps != null){
                try{
                    ps.close();
                } catch(SQLException ex){
                }
            }
        }
    }
    
    public void deleteRecord(String id) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(delete);
            ps.setString(1, id);
            ps.executeUpdate();
            con.commit();
            JOptionPane.showMessageDialog(null, "Data Deleted!!");
        } catch(SQLException e){
            try{
                con.rollback();
            } catch(SQLException ex){
            
            }
            throw new SQLException(e.getMessage());
        } finally{
            try{
                con.setAutoCommit(true);
            } catch(SQLException ex){
            
            }
            if(ps != null){
                try{
                    ps.close();
                } catch(SQLException ex){
                }
            }
        }
    }
    
    public List<Petugas> selectAll() throws SQLException {
        Connection con = conn.getConnection();
        Statement st = null;
        List<Petugas> list = new ArrayList<Petugas>();
        try{
            con.setAutoCommit(false);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            Petugas petugas = null;
            
            while(rs.next()){
                petugas = new Petugas();
                petugas.setId_petugas(rs.getString("ID_PETUGAS"));
                petugas.setNama(rs.getString("NAMA"));
                petugas.setNo_ktp(rs.getString("NO_KTP"));
                petugas.setAlamat(rs.getString("ALAMAT"));
                petugas.setTgl_lahir(rs.getString("TGL_LAHIR"));
                petugas.setUsername(rs.getString("USERNAME"));
                petugas.setPassword(rs.getString("PASSWORD"));
                list.add(petugas);
            }
            con.commit();
            return list;
        } catch(SQLException e){
            try{
                con.rollback();
            } catch(SQLException ex){
            
            }
            throw new SQLException(e.getMessage());
        } finally{
            try{
                con.setAutoCommit(true);
            } catch(SQLException ex){
            
            }
            if(st != null){
                try{
                    st.close();
                } catch(SQLException ex){
                }
            }
        }
    }
}
