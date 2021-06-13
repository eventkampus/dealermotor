/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KONEKSI_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Dewa Supera
 */
public class KONEKSI {
    private static Connection KONEKSI;
    public Connection conn;
    Statement stm;
    
    public KONEKSI(){}
    
   public Connection openkoneksi() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            KONEKSI = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_dealer_motor", "root", "");
            return KONEKSI;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi yang terbuka.");
            return null;
        }
    }
    
    public void closekoneksi() throws SQLException{
        try{
            if(KONEKSI != null){
                System.out.print("Tutup Koneksi\n");
            }
        }catch(Exception ex){
        }
    } 
}
