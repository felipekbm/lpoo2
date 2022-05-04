/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhofinal;

import java.sql.Connection;
import jdbc.conexao.ConexaoDAO;
import telas.Menu;

/**
 *
 * @author User
 */
public class TrabalhoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexaoDAO conexaoDAO = new ConexaoDAO();
        Connection conn= conexaoDAO.conectaDB();
      
       
      
       
       
        Menu tela = new Menu(conn);
        
    }
    
}
