/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.persistenciaDAO.ITreinadorDAO;
import models.Selecao;
import models.Treinador;

/**
 *
 * @author User
 */
public class MySqlTreinadorDAO implements ITreinadorDAO {

    Connection conn = null;

    public MySqlTreinadorDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Treinador buscaPorSelecao(Selecao vo) {

        Treinador item = null;
        try {
            PreparedStatement st = conn.prepareStatement("select participante.* from treinador "
                    + "inner join participante on treinador.id = participante.id where treinador.selec_id = ?;");
            st.setInt(1, vo.getId());

            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                item = new Treinador(rs.getInt("id"), rs.getString("nacionalidade"),
                        rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));
                item.setSelecao(vo);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return item;

    }

    @Override
    public boolean atualiza(Treinador vo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Treinador buscaSelecao(Treinador vo) {
        MySqlSelecaoDAO dao = new MySqlSelecaoDAO(conn);
        dao.buscaPorTreinador(vo);

        return vo;
    }

  @Override
    public boolean novo(Treinador vo) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into treinador(id,selec_id) values(?,?)");
            st.setInt(1, vo.getId());
            st.setInt(2, vo.getSelecao().getId());
            st.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Treinador busca(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Treinador> listaTodos() {
        List<Treinador> itens = new ArrayList<Treinador>();
        Treinador item = null;
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.
                    executeQuery("select participante.* from treinador inner join participante on treinador.id = participante.id;"));

            while (rs != null && rs.next()) {
                item = new Treinador(rs.getInt("id"), rs.getString("nacionalidade"),
                        rs.getDate("data_nasc"), rs.getString("nome"), rs.getString("foto"));

                itens.add(item);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return itens;
    }


}
