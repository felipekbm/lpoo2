package jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author https://github.com/felipekbm/lpoo2.git
 */

public class ConexaoDAO {
    public  Connection conectaDB(){
        Connection conn = null;
        
        try{
            //String url = "jdbc:mysql://localhost:3306/trabalho_lpoo2?user=root&password=root&useSSL=true";
            String url = "jdbc:mysql://localhost:3306/trabalho_lpoo2?user=root&password=testeteste";
            conn = DriverManager.getConnection(url);
        }catch(Exception error){
            JOptionPane.showMessageDialog(null, "CONEXAO: " + error.getMessage());
        }
        
        return conn;   
    }
}
