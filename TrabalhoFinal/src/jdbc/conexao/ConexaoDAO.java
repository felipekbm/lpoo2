/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ConexaoDAO {
    public  Connection conectaDB(){
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/trabalho_lpoo2?user=root&password=tatu1964";
            conn = DriverManager.getConnection(url);
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, "CONEXAO: " + error.getMessage());
        }
        
        return conn;
        
    }
    
}
