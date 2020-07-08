/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Kereta;

import Koneksi.Koneksi;
import Model.Kereta;
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
public class keretaController {
    private Koneksi conn = new Koneksi();
    private String insert = "INSERT INTO kereta_api(ID_KERETA, NAMA_KERETA, ID_KELAS, GERBONG) VALUES(?,?,?,?)";
    private String update = "UPDATE kereta_api SET NAMA_KERETA = ?, ID_KELAS = ?, GERBONG = ? WHERE ID_KERETA = ?";
    private String delete = "DELETE FROM kereta_api WHERE ID_KERETA = ?";
    private String selectAll = "SELECT * FROM kereta_api ORDER BY ID_KERETA ASC";
    
    public void insertRecord(Kereta kereta) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(insert);
            ps.setString(1, kereta.getId_kereta());
            ps.setString(2, kereta.getNama_Kereta());
            ps.setString(3, kereta.getId_kelas());
            ps.setInt(4, kereta.getGerbong());
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
    
    public void updateRecord(Kereta kereta) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(update);
            ps.setString(1, kereta.getNama_Kereta());
            ps.setString(2, kereta.getId_kelas());
            ps.setInt(3, kereta.getGerbong());
            ps.setString(4, kereta.getId_kereta());
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
    
    public List<Kereta> selectAll() throws SQLException {
        Connection con = conn.getConnection();
        Statement st = null;
        List<Kereta> list = new ArrayList<Kereta>();
        try{
            con.setAutoCommit(false);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            Kereta kereta = null;
            
            while(rs.next()){
                kereta = new Kereta();
                kereta.setId_kereta(rs.getString("ID_KERETA"));
                kereta.setNama_Kereta(rs.getString("NAMA_KERETA"));
                kereta.setId_kelas(rs.getString("ID_KELAS"));
                kereta.setGerbong(rs.getInt("GERBONG"));
                list.add(kereta);
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
