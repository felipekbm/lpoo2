
package trabalhofinal;

import java.sql.Connection;
import jdbc.conexao.ConexaoDAO;
import telas.Menu;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
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
