/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Manager;

import Dashboard.Manager.Menu.masinisCardMenu;
import Dashboard.Manager.managerDashboard;
import Koneksi.Koneksi;
import Model.Masinis;
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
public class masinisController {
    private Koneksi conn = new Koneksi();
    private String insertMasinis = "INSERT INTO masinis(ID_MASINIS, NAMA, NO_KTP, ALAMAT, TGL_LAHIR, USERNAME, PASSWORD) VALUES(?,?,?,?,?,?,?)";
    private String updateMasinis = "UPDATE masinis SET NAMA = ?, NO_KTP = ?, ALAMAT = ?, TGL_LAHIR = ?, USERNAME = ?, PASSWORD = ? WHERE ID_MASINIS = ?";
    private String deleteMasinis = "DELETE FROM masinis WHERE ID_MASINIS = ?";
    private String selectAllData = "SELECT * FROM masinis ORDER BY id_masinis ASC";
    
    public void insertRecord(Masinis masinis) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(insertMasinis);
            ps.setString(1, masinis.getId_masinis());
            ps.setString(2, masinis.getNama());
            ps.setString(3, masinis.getNo_ktp());
            ps.setString(4, masinis.getAlamat());
            ps.setString(5, masinis.getTgl_lahir());
            ps.setString(6, masinis.getUsername());
            ps.setString(7, masinis.getPassword());
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
    
    public void updateRecord(Masinis masinis) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(updateMasinis);
            ps.setString(1, masinis.getNama());
            ps.setString(2, masinis.getNo_ktp());
            ps.setString(3, masinis.getAlamat());
            ps.setString(4, masinis.getTgl_lahir());
            ps.setString(5, masinis.getUsername());
            ps.setString(6, masinis.getPassword());
            ps.setString(7, masinis.getId_masinis());
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
            ps = con.prepareStatement(deleteMasinis);
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
    
    public List<Masinis> selectAllMasinis() throws SQLException {
        Connection con = conn.getConnection();
        Statement st = null;
        List<Masinis> list = new ArrayList<Masinis>();
        try{
            con.setAutoCommit(false);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(selectAllData);
            Masinis masinis = null;
            
            while(rs.next()){
                masinis = new Masinis();
                masinis.setId_masinis(rs.getString("ID_MASINIS"));
                masinis.setNama(rs.getString("NAMA"));
                masinis.setNo_ktp(rs.getString("NO_KTP"));
                masinis.setAlamat(rs.getString("ALAMAT"));
                masinis.setTgl_lahir(rs.getString("TGL_LAHIR"));
                masinis.setUsername(rs.getString("USERNAME"));
                masinis.setPassword(rs.getString("PASSWORD"));
                list.add(masinis);
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
