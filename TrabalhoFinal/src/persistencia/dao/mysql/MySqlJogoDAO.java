/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dao.mysql;

import java.sql.Connection;
import java.util.List;
import jdbc.persistenciaDAO.IJogoDAO;
import models.Jogo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.persistenciaDAO.ISelecaoDAO;
import models.Juiz;
import models.Posicao;
import models.Selecao;

/**
 *
 * @author User
 */
public class MySqlJogoDAO implements IJogoDAO {

    Connection conn = null;

    public MySqlJogoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean atualiza(Jogo vo) {
        try {
            PreparedStatement st = conn.prepareStatement("update jogo  selecao_1 = ?,selecao_2 = ? ,"
                    + "data = ?, resultado=?, local=? where  id=?");
            st.setInt(1, vo.getSelecao1().getId());
            st.setInt(2, vo.getSelecao2().getId());
            st.setDate(3, vo.getData());
            st.setString(4, vo.getResultado());
            st.setString(5, vo.getLocal());
            st.setInt(6, vo.getId());
            st.execute();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Jogo buscaJuiz(Jogo vo) {
        try {

            List<Juiz> itens = new ArrayList<Juiz>();

            try {
                PreparedStatement st = conn.prepareStatement("  select participante.id, participante.nome, participante.foto, participante.data_nasc, participante.nacionalidade \n"
                        + "from juiz_jogo inner join juiz on juiz_jogo.id_juiz = juiz.id inner join participante on "
                        + "juiz.id = participante.id where id_jogo = ?;\n"
                        + "");
                st.setInt(1, vo.getId());
                ResultSet rs = (st.executeQuery());

                if (rs != null && rs.next()) {
                    //Integer id, String nacionalidade, Date data_nasc, String nome, String foto
                    itens.add(new Juiz(rs.getInt("id"), rs.getString("nome"), rs.getDate("data_nasc"), rs.getString("nacionalidade"),
                            rs.getString("foto")));

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            vo.setJuizes(itens);
            return vo;

        } catch (Exception e) {

        }
        return vo;
    }

    @Override
    public boolean novo(Jogo vo) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into jogo( selecao_1, selecao_2, data, resultado, local) "
                    + "values(?, ?,?,?,?,?)");
            st.setInt(1, vo.getSelecao1().getId());
            st.setInt(2, vo.getSelecao2().getId());
            st.setDate(3, vo.getData());
            st.setString(4, vo.getResultado());
            st.setString(5, vo.getLocal());
            st.execute();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean excluir(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM jogo WHERE ID = ?;");
            st.setInt(1, id);
            st.execute();

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Jogo busca(int id) {
        Jogo item = null;

        try {
            PreparedStatement st = conn.prepareStatement(" select jogo.id, jogo.resultado, jogo.data, jogo.local ,\n"
                    + " A.id as A_ID, A.NOME as A_NOME, A.LOGO  as A_LOGO,\n"
                    + "  B.id as B_ID, B.NOME as B_NOME, B.LOGO  as B_LOGO\n"
                    + " from jogo INNER JOIN SELECAO as A  ON  jogo.selecao_1 = A.id\n"
                    + " inner join selecao as B on jogo.selecao_2 = b.id\n"
                    + " \n"
                    + "  WHERE ID = ?;");
            st.setInt(1, id);
            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                //int id, Date data, String resultado, String local
                item = new Jogo(rs.getInt("id"), rs.getDate("data"), rs.getString("resultado"), rs.getString("local"));
                //Integer id, String nome, String logo
                item.setSelecao1(new Selecao(rs.getInt("A_ID"), rs.getString("A_NOME"), rs.getString("A_LOGO")));
                item.setSelecao2(new Selecao(rs.getInt("B_ID"), rs.getString("B_NOME"), rs.getString("B_LOGO")));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return item;
    }

    @Override
    public List<Jogo> listaTodos() {
        List<Jogo> itens = new ArrayList<Jogo>();
        Jogo item = null;
        try {
            PreparedStatement st = conn.prepareStatement(" select jogo.id, jogo.resultado, jogo.data, jogo.local ,\n"
                    + " A.id as A_ID, A.NOME as A_NOME, A.LOGO  as A_LOGO,\n"
                    + "  B.id as B_ID, B.NOME as B_NOME, B.LOGO  as B_LOGO\n"
                    + " from jogo INNER JOIN SELECAO as A  ON  jogo.selecao_1 = A.id\n"
                    + " inner join selecao as B on jogo.selecao_2 = b.id\n"
                    + ";");

            ResultSet rs = (st.executeQuery());
            while (rs != null && rs.next()) {
                item = new Jogo(rs.getInt("id"), rs.getDate("data"), rs.getString("resultado"), rs.getString("local"));
                item.setSelecao1(new Selecao(rs.getInt("A_ID"), rs.getString("A_NOME"), rs.getString("A_LOGO")));
                item.setSelecao2(new Selecao(rs.getInt("B_ID"), rs.getString("B_NOME"), rs.getString("B_LOGO")));
                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }

    @Override
    public Jogo InsereJuiz(Jogo vo, Juiz j) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into juiz_jogo( id,id_juiz, id_jogo) "
                    + "values( ?,?,?)");
            st.setInt(1, Integer.parseInt(String.valueOf(vo.getId()) + String.valueOf(j.getId())));
            st.setInt(2, j.getId());
            st.setInt(3, vo.getId());
            st.execute();

            vo.getJuizes().add(j);

        } catch (Exception e) {

        }

        return vo;
    }

    @Override
    public Jogo DeletaJuiz(Jogo vo, int j_id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM juiz_jogo WHERE ID_juiz = ? and id_jogo = ?;");
            st.setInt(1, j_id);
            st.setInt(2, vo.getId());
            st.execute();

        } catch (Exception e) {

        }

        return vo;
    }

}
