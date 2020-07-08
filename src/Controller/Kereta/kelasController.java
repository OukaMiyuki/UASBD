/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Kereta;

import Koneksi.Koneksi;
import Model.Kelas;
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
public class kelasController {
    private Koneksi conn = new Koneksi();
    private String insert = "INSERT INTO jenis_kelas(ID_KELAS, NAMA_KELAS, KETERANGAN) VALUES(?,?,?)";
    private String update = "UPDATE jenis_kelas SET NAMA_KELAS = ?, KETERANGAN = ? WHERE ID_KELAS = ?";
    private String delete = "DELETE FROM jenis_kelas WHERE ID_KELAS = ?";
    private String selectAll = "SELECT * FROM jenis_kelas ORDER BY id_kelas ASC";
    
    public void insertRecord(Kelas kelas) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(insert);
            ps.setString(1, kelas.getId_kelas());
            ps.setString(2, kelas.getNama());
            ps.setString(3, kelas.getKeterangan());
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
    
    public void updateRecord(Kelas kelas) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(update);
            ps.setString(1, kelas.getNama());
            ps.setString(2, kelas.getKeterangan());
            ps.setString(3, kelas.getId_kelas());
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
    
    public List<Kelas> selectAll() throws SQLException {
        Connection con = conn.getConnection();
        Statement st = null;
        List<Kelas> list = new ArrayList<Kelas>();
        try{
            con.setAutoCommit(false);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            Kelas kelas = null;
            
            while(rs.next()){
                kelas = new Kelas();
                kelas.setId_kelas(rs.getString("ID_KELAS"));
                kelas.setNama(rs.getString("NAMA_KELAS"));
                kelas.setKeterangan(rs.getString("KETERANGAN"));
                list.add(kelas);
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
