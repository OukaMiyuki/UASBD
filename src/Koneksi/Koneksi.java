/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ouka
 */
public class Koneksi {
    private Connection conn;
    public Connection getConnection(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Found mate!");
            try{
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "amar90487", "OukaDB");
		System.out.println("Connected!");
                return conn;
            } catch (SQLException e){
                System.out.println("Not connected!");
                return null;
            }
        } catch(ClassNotFoundException ex){
            System.out.println("Not Found Mate!" + ex);
            return null;
        }
    }
}