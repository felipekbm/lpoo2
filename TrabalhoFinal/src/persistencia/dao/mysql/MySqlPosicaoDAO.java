/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dao.mysql;

import java.sql.Connection;
import java.util.List;
import jdbc.persistenciaDAO.IPosicaoDAO;
import models.Posicao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class MySqlPosicaoDAO implements IPosicaoDAO {

    Connection conn = null;

    public MySqlPosicaoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean novo(Posicao vo) {
        try {
            PreparedStatement st = conn.prepareStatement("Insert into posicao( nome) values(?)");
            st.setString(1, vo.getNome());
            st.execute();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean excluir(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM posicao WHERE ID = ?;");
            st.setInt(1, id);
            st.execute();

        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean atualiza(Posicao vo) {

        try {
            PreparedStatement st = conn.prepareStatement("update posicao set nome = ? where  id=?");

            st.setString(1, vo.getNome());

            st.setInt(2, vo.getId());
            st.execute();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Posicao busca(int id) {
        Posicao posicao = null;

        try {
            PreparedStatement st = conn.prepareStatement("select * FROM posicao WHERE ID = ?;");
            st.setInt(1, id);
            ResultSet rs = (st.executeQuery());

            if (rs != null && rs.next()) {
                posicao = new Posicao(rs.getInt("id"), rs.getString("nome"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return posicao;
    }

    @Override
    public List<Posicao> listaTodos() {
        List<Posicao> posicoes = new ArrayList<Posicao>();
        Posicao posicao = null;
        try {
            Statement st = conn.createStatement();

            ResultSet rs = (st.executeQuery("select * from posicao"));

            while (rs != null && rs.next()) {
                posicao = new Posicao(rs.getInt("id"), rs.getString("nome"));

                posicoes.add(posicao);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return posicoes;
    }

}
