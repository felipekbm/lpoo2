/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalhofinal;

import java.sql.Connection;
import jdbc.conexao.ConexaoDAO;
import models.Posicao;
import persistencia.dao.mysql.MySqlJuizDAO;
import persistencia.dao.mysql.MySqlParticipanteDAO;
import persistencia.dao.mysql.MySqlPosicaoDAO;

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
      
         MySqlParticipanteDAO daoParticipante = new  MySqlParticipanteDAO(conn);
         
             MySqlJuizDAO daoJuiz = new  MySqlJuizDAO(conn);

       System.out.println(daoParticipante.listaTodos().get(1).getNome()) ;
       
       
       // MySqlPosicaoDAO  mysqlPosicaoDAO = new MySqlPosicaoDAO(conn);
       /* mysqlPosicaoDAO.novo(new Posicao(0, "ATACANTE"));*/
       //System.out.println(mysqlPosicaoDAO.busca(1).getNome()) ;
        
    }
    
}
