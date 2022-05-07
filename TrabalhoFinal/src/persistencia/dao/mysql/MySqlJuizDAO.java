package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import jdbc.persistenciaDAO.IJuizDAO;
import models.Juiz;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.Jogo;

/**
 *
 * @author Ricardo Filho - Karine Antoniacomi
 */

public class MySqlJuizDAO implements IJuizDAO {

    Connection conn = null;

    public MySqlJuizDAO(Connection conn) {
        this.conn = conn;
    }

    @Override()
    public boolean excluir(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM juiz WHERE ID = ?;");
            st.setInt(1, id);
            st.execute();

        } catch (Exception e) {
            return false;
        }

        return true;

    }

    @Override()
    public Juiz busca(int id) {

        Juiz juiz = null;

        try {
            PreparedStatement st = conn.prepareStatement("select participante.id, nome, foto, data_nasc, nacionalidade from participante \n"
                    + "inner join juiz on participante.id = juiz.id where  participante.id = ?;");
            st.setInt(1, id);
            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                juiz = new Juiz(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return juiz;

    }

    @Override()
    public List<Juiz> listaTodos() {
        List<Juiz> juizes = new ArrayList<Juiz>();
        Juiz participante = null;
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.executeQuery("select participante.id, nome, foto, data_nasc, nacionalidade from participante \n"
                    + "inner join juiz on participante.id = juiz.id;"));

            while (rs != null && rs.next()) {
                participante = new Juiz(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));

                juizes.add(participante);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return juizes;

    }

    public List<Juiz> buscaPorNome(String nome) {
        List<Juiz> juizes = new ArrayList<Juiz>();
        Juiz juiz = null;
        try {
            PreparedStatement st = conn.prepareStatement("select participante.id, nome, foto, data_nasc, nacionalidade from participante \n"
                    + "inner join juiz on participante.id = juiz.id where  nome like ?;");
            st.setString(1, "%" + nome + "%");

            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                juiz = new Juiz(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));

                juizes.add(juiz);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return juizes;
    }

    @Override()
    public List<Juiz> buscaPorJogo(Jogo vo) {
        List<Juiz> juizes = new ArrayList<Juiz>();
        Juiz juiz = null;
        try {
            PreparedStatement st = conn.prepareStatement("select participante.id, nome, foto, data_nasc, nacionalidade from participante \n"
                    + "inner join juiz on participante.id = juiz.id inner join juiz_jogo on juiz.id = juiz_jogo.id_juiz\n"
                    + "where id_jogo = ?\n"
                    + " ;");
            st.setInt(1, vo.getId());

            ResultSet rs = (st.executeQuery());

            while (rs != null && rs.next()) {
                juiz = new Juiz(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));

                juizes.add(juiz);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return juizes;
    }

    @Override
    public boolean novo(Juiz vo) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into juiz(id) values(?)");
            st.setInt(1, vo.getId());
            st.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
