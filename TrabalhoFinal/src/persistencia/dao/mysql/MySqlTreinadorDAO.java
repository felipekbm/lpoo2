/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dao.mysql;

import java.sql.Connection;
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
    public boolean novo(Object vo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object busca(int id) {
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
