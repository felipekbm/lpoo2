package persistencia.dao.mysql;

import java.util.List;
import jdbc.persistenciaDAO.IParticipanteDAO;
import models.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public class MySqlParticipanteDAO implements IParticipanteDAO {
    
    Connection conn = null;
    
    public MySqlParticipanteDAO(Connection conn) {
        this.conn = conn;
    }
    public int ultimo(){
        
         try {
            Statement st = conn.createStatement();
            
            ResultSet rs = (st.executeQuery("select id from participante  order by id desc limit 1 "));
            
            if (rs.next()) {
               return rs.getInt("id");
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
        return 0;
        
    }
    @Override()
    public boolean novo(Participante vo) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into Participante( nome, nacionalidade, data_nasc, foto) values(?, ?, ?, ?)");
            st.setString(1, vo.getNome());
            st.setString(2, vo.getNacionalidade());
            st.setDate(3, vo.getData_nasc());
            st.setString(4, vo.getFoto());
           st.execute();
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    
    
    @Override()
    public boolean atualizar(Participante vo) {
        try {
            PreparedStatement st = conn.prepareStatement("update Participante set nome = ?,  nacionalidade = ?, data_nasc = ?, foto=? where  id=?");
            
            st.setString(1, vo.getNome());
            st.setString(2, vo.getNacionalidade());
            st.setDate(3, vo.getData_nasc());
            st.setString(4, vo.getFoto());
            
            st.setInt(5, vo.getId());
            st.execute();
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    @Override()
    public boolean excluir(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM Participante WHERE ID = ?;");
            st.setInt(1, id);
            st.execute();
            
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
    
    @Override()
    public Participante busca(int id) {
        Participante participante = null;
        
        try {
            PreparedStatement st = conn.prepareStatement("select * FROM Participante WHERE ID = ?;");
            st.setInt(1, id);
            ResultSet rs = (st.executeQuery());
            
            if (rs != null && rs.next()) {
                participante = new Participante(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return participante;
        
    }
    
    @Override()
    public List<Participante> listaTodos() {
        List<Participante> participantes = new ArrayList<Participante>();
        Participante participante = null;
        try {
            Statement st = conn.createStatement();
            
            ResultSet rs = (st.executeQuery("select * from participante"));
            
            while (rs.next()) {
                participante = new Participante(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));
                
                participantes.add(participante);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
        return participantes;
    }
    
    @Override()
    public List<Participante> buscaPorNome(String nome) {
        List<Participante> participantes = new ArrayList<Participante>();
        Participante participante = null;
        try {
            PreparedStatement st = conn.prepareStatement("select * FROM Participante WHERE nome like ?;");
            st.setString(1, "%" + nome + "%");
            
            ResultSet rs = (st.executeQuery());
            
            if (rs != null && rs.next()) {
                System.out.print(rs.getString("nome"));
                participante = new Participante(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));
                
                participantes.add(participante);
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
        
        return participantes;
    }
    
}
