/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Tiket;

import Koneksi.Koneksi;
import Model.Tiket;
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
public class tiketController {
    private Koneksi conn = new Koneksi();
    private String insert = "INSERT INTO stok_tiket(ID_TIKET, ID_JADWAL, ID_KELAS, HARGA, STOK_TIKET) VALUES(?,?,?,?,?)";
    private String update = "UPDATE stok_tiket SET ID_JADWAL = ?, ID_KELAS = ?, HARGA = ?, STOK_TIKET = ? WHERE ID_TIKET = ?";
    private String delete = "DELETE FROM stok_tiket WHERE ID_TIKET = ?";
    private String selectAll = "SELECT * FROM stok_tiket ORDER BY ID_TIKET ASC";
    
    public void insertRecord(Tiket tiket) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(insert);
            ps.setString(1, tiket.getId_tiket());
            ps.setString(2, tiket.getId_jadwal());
            ps.setString(3, tiket.getId_kelas());
            ps.setInt(4, tiket.getHarga());
            ps.setInt(5, tiket.getStok());
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
    
    public void updateRecord(Tiket tiket) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(update);
            ps.setString(1, tiket.getId_jadwal());
            ps.setString(2, tiket.getId_kelas());
            ps.setInt(3, tiket.getHarga());
            ps.setInt(4, tiket.getStok());
            ps.setString(5, tiket.getId_tiket());
            ps.executeUpdate();
            con.commit();
            JOptionPane.showMessageDialog(null, "Data Updated!");
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
            JOptionPane.showMessageDialog(null, "Data Deleted!");
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
    
    public List<Tiket> selectAll() throws SQLException {
        Connection con = conn.getConnection();
        Statement st = null;
        List<Tiket> list = new ArrayList<Tiket>();
        try{
            con.setAutoCommit(false);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            Tiket tiket = null;
            
            while(rs.next()){
                tiket = new Tiket();
                tiket.setId_tiket(rs.getString("ID_TIKET"));
                tiket.setId_jadwal(rs.getString("ID_JADWAL"));
                tiket.setId_kelas(rs.getString("ID_KELAS"));
                tiket.setHarga(rs.getInt("HARGA"));
                tiket.setStok(rs.getInt("STOK_TIKET"));
                list.add(tiket);
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
