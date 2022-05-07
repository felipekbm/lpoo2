package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdbc.persistenciaDAO.IJogadorDAO;
import models.Jogador;
import models.Participante;
import java.sql.Statement;
import models.Posicao;
import models.Selecao;

/**
 *
 * @author Ricardo Filho - Karine Antoniacomi
 */

public class MySqlJogadorDAO implements IJogadorDAO {

    Connection conn = null;

    public MySqlJogadorDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Jogador> buscaPorNome(String nome) {
        List<Jogador> itens = new ArrayList<Jogador>();
        Jogador item = null;
        try {
            PreparedStatement st = conn.prepareStatement("select participante.id, participante.nome, participante.foto, participante.nacionalidade, jogador.camisa \n"
                    + " from participante inner join \n"
                    + " jogador on participante.id = jogador.id where nome like ?;");
            st.setString(1, "%" + nome + "%");
            ResultSet rs = (st.executeQuery());
            while (rs != null && rs.next()) {
                item = new Jogador(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"),
                        rs.getString("foto"), rs.getInt("camisa")
                );

                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }

    @Override
    public boolean novo(Jogador vo) {
        try {
            PreparedStatement st = conn.prepareStatement(" insert into jogador(id, selec_id, posicao_id, camisa)"
                    + "values(?, ?, ?, ?);");
            
            st.setInt(1, vo.getId());
            st.setInt(2, vo.getSelecao().getId());
            st.setInt(3, vo.getPosicao().getId());
            st.setInt(4, vo.getCamisa());
            st.execute();
        } catch (Exception e) {
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

    @Override
    public Jogador busca(int id) {

        Jogador item = null;

        try {
            PreparedStatement st = conn.prepareStatement("select participante.id, participante.nome, participante.nacionalidade, participante.data_nasc, participante.foto, jogador.camisa, posicao.id as posicao_id \n"
                    + "from participante inner join jogador on participante.id = jogador.id inner join posicao on jogador.posicao_id = posicao.id ; where id = ?;");
            st.setInt(1, id);
            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                item = new Jogador(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"),
                        rs.getString("foto"), rs.getInt("camisa")
                );

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return item;

    }

    @Override
    public List<Jogador> listaTodos() {
        List<Jogador> itens = new ArrayList<Jogador>();
        Jogador item = null;
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.executeQuery(" select participante.id, participante.nome, participante.nacionalidade, participante.data_nasc, participante.foto, jogador.camisa, posicao.id as posicao_id \n"
                    + "from participante inner join jogador on participante.id = jogador.id inner join posicao on jogador.posicao_id = posicao.id ;"));

            while (rs != null && rs.next()) {
                item = new Jogador(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"),
                        rs.getString("foto"), rs.getInt("camisa")
                );

                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }
    
    
    @Override
    public List<Jogador> listaTodosPorSelecao(Selecao vo) {
        List<Jogador> itens = new ArrayList<Jogador>();
        Jogador item = null;
        try {
            PreparedStatement st = conn.prepareStatement(" select participante.id, participante.nome, participante.nacionalidade, participante.data_nasc, participante.foto, jogador.camisa, posicao.id as posicao_id, posicao.nome as posicao \n"
                    + "from participante inner join jogador on "
                    + "participante.id = jogador.id inner join posicao on jogador.posicao_id = posicao.id "
                    + "where jogador.selec_id = ? order by posicao.id;");
           
             st.setInt(1, vo.getId());
            ResultSet rs = (st.executeQuery());

            while (rs != null && rs.next()) {
                item = new Jogador(rs.getInt("id"), rs.getString("nacionalidade"), rs.getDate("data_nasc"), rs.getString("nome"),
                        rs.getString("foto"), rs.getInt("camisa")
                );
                item.setPosicao(new Posicao(rs.getInt("posicao_id"), rs.getString("posicao")));
                item.setSelecao(vo);
                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }

    public boolean atualizar(Jogador vo) {
        try {
            PreparedStatement st = conn.prepareStatement("update jogador set select_id = ?, posicao_id = ?, camisa = ? where  id=?");

            st.setInt(1, vo.getSelecao().getId());
            st.setInt(2, vo.getPosicao().getId());
            st.setInt(3, vo.getCamisa());
            st.setInt(4, vo.getId());
            st.execute();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Jogador buscaSelecao(Jogador vo) {

        try {
            MySqlSelecaoDAO selecaoDAO = new MySqlSelecaoDAO(conn);
            selecaoDAO.buscaPorJogador(vo);

        } catch (Exception e) {
            System.out.println(e);
        }

        return vo;

    }

    @Override
    public Jogador buscaPosicao(Jogador vo) {
        Jogador jogador = null;
        try {
            MySqlPosicaoDAO DAO = new MySqlPosicaoDAO(conn);
            jogador = DAO.buscaPorJogador(vo);

        } catch (Exception e) {
            System.out.println(e);
        }

        return jogador;
    }

}
