/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Login.Access;

import Dashboard.Manager.managerDashboard;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ouka
 */
public class Access {
    private String access;
    String id;
    private managerDashboard managerdashboard;
    public Access(String access, String id) throws SQLException{
        this.access = access;
        this.id = id;
        login();
    }
    
    private void login() throws SQLException{
        if(access.trim().equals("manager")){
            managerdashboard = new managerDashboard();
            managerdashboard.setVisible(true);
        } else if(access.trim().equals("petugas")){
            JOptionPane.showMessageDialog(null, "Petugas");
        } else if(access.trim().equals("masinis")){
            JOptionPane.showMessageDialog(null, "Masinis");
        }
    }
}
