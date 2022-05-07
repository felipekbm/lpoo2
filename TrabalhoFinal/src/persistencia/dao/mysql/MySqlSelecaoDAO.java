package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.persistenciaDAO.ISelecaoDAO;
import models.Jogador;

import models.Selecao;
import models.Treinador;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public class MySqlSelecaoDAO implements ISelecaoDAO {

    Connection conn = null;

    public MySqlSelecaoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean atualizar(Selecao vo) {
        try {
            PreparedStatement st = conn.prepareStatement("update selecao set nome = ?, logo = ? where  id=?");

            st.setString(1, vo.getNome());
            st.setString(2, vo.getLogo());
            st.setInt(3, vo.getId());
            st.execute();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<Selecao> buscaPorNome(String nome) {
        List<Selecao> itens = new ArrayList<Selecao>();
        Selecao item = null;
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.executeQuery("select * from selecao where id = ?;"));

            while (rs != null && rs.next()) {
                item = new Selecao(rs.getInt("id"), rs.getString("nome"), rs.getString("logo"));

                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }

    @Override
    public boolean novo(Selecao vo) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into selecao( nome, logo) values(?, ?)");
            st.setString(1, vo.getNome());
            st.setString(2, vo.getLogo());
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean excluir(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM selecao WHERE ID = ?;");
            st.setInt(1, id);
            st.execute();

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override()
    public Jogador buscaPorJogador(Jogador vo) {
        Selecao item = null;

        try {
            PreparedStatement st = conn.prepareStatement("select selecao.id, selecao.logo, selecao.nome from  "
                    + "selecao inner join jogador "
                    + "on selecao.id = jogador.selec_id where jogador.id = ?;");
            st.setInt(1, vo.getId());
            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                item = new Selecao(rs.getInt("id"), rs.getString("nome"), rs.getString("logo"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        vo.setSelecao(item);
        return vo;
    }

    @Override()
    public Treinador buscaPorTreinador(Treinador vo) {
        Selecao item = null;

        try {
            PreparedStatement st = conn.prepareStatement("select selecao.id, selecao.logo, selecao.nome from  "
                    + "selecao inner join treinador "
                    + "on selecao.id = treinador.selec_id where treinador.id = ?;");
            st.setInt(1, vo.getId());
            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                item = new Selecao(rs.getInt("id"), rs.getString("nome"), rs.getString("logo"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        vo.setSelecao(item);
        return vo;
    }

    @Override
    public Selecao busca(int id) {
        Selecao item = null;

        try {
            PreparedStatement st = conn.prepareStatement("select * FROM selecao WHERE ID = ?;");
            st.setInt(1, id);
            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                item = new Selecao(rs.getInt("id"), rs.getString("nome"), rs.getString("logo"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return item;
    }

    @Override
    public List<Selecao> listaTodos() {
        List<Selecao> itens = new ArrayList<Selecao>();
        Selecao item = null;
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.executeQuery("select * from selecao;"));

            while (rs != null && rs.next()) {
                item = new Selecao(rs.getInt("id"), rs.getString("nome"), rs.getString("logo"));

                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }

    public List<Selecao> listaTodosSemTreinador() {
        List<Selecao> itens = new ArrayList<Selecao>();
        Selecao item = null;
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.executeQuery("select * from selecao left join treinador  on selecao.id = treinador.selec_id where selec_id is null"));

            while (rs != null && rs.next()) {
                item = new Selecao(rs.getInt("id"), rs.getString("nome"), rs.getString("logo"));

                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }

}
