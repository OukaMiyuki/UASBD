/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Jadwal;

import Controller.Kereta.kelasController;
import Koneksi.Koneksi;
import Model.Jadwal;
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
public class jadwalController {
    private Koneksi conn = new Koneksi();
    private String insert = "INSERT INTO jadwal(ID_JADWAL, ID_KERETA, ID_MASINIS, TANGGAL, JAM, TUJUAN) VALUES(?,?,?,?,?,?)";
    private String update = "UPDATE jadwal SET ID_KERETA = ?, ID_MASINIS = ?, TANGGAL = ?, JAM = ?, TUJUAN = ? WHERE ID_JADWAL = ?";
    private String delete = "DELETE FROM jadwal WHERE ID_JADWAL = ?";
    private String selectAll = "SELECT * FROM jadwal ORDER BY id_jadwal ASC";
    private String pilihJadwal = "SELECT  kereta_api.id_kelas FROM kereta_api JOIN jadwal ON jadwal.id_kereta = kereta_api.id_kereta WHERE id_jadwal = ?";
    
    public void insertRecord(Jadwal jadwal) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(insert);
            ps.setString(1, jadwal.getId_jadwal());
            ps.setString(2, jadwal.getId_kereta());
            ps.setString(3, jadwal.getId_masinis());
            ps.setString(4, jadwal.getTanggal());
            ps.setString(5, jadwal.getJam());
            ps.setString(6, jadwal.getTujuan());
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
    
    public void updateRecord(Jadwal jadwal) throws SQLException{
        Connection con = conn.getConnection();
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(update);
            ps.setString(1, jadwal.getId_kereta());
            ps.setString(2, jadwal.getId_masinis());
            ps.setString(3, jadwal.getTanggal());
            ps.setString(4, jadwal.getJam());
            ps.setString(5, jadwal.getTujuan());
            ps.setString(6, jadwal.getId_jadwal());
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
    
    public List<Jadwal> selectAll() throws SQLException {
        Connection con = conn.getConnection();
        Statement st = null;
        List<Jadwal> list = new ArrayList<Jadwal>();
        try{
            con.setAutoCommit(false);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            Jadwal jadwal = null;
            
            while(rs.next()){
                jadwal = new Jadwal();
                jadwal.setId_jadwal(rs.getString("ID_JADWAL"));
                jadwal.setId_kereta(rs.getString("ID_KERETA"));
                jadwal.setId_masinis(rs.getString("ID_MASINIS"));
                jadwal.setTanggal(rs.getString("TANGGAL"));
                jadwal.setJam(rs.getString("JAM"));
                jadwal.setTujuan(rs.getString("TUJUAN"));
                list.add(jadwal);
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
    
    public String pilihJadwal(String idJadwal) throws SQLException{
        Connection con = conn.getConnection();
        String kelas = null;
        PreparedStatement ps = null;
        try{
            con.setAutoCommit(false);
            ps = con.prepareStatement(pilihJadwal);
            ps.setString(1, idJadwal);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                kelas = rs.getString("ID_KELAS");
            } else{
                throw new SQLException("not found!");
            }
            con.commit();
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
        return kelas;
    }
}
