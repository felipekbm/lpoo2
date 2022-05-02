/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Treinador extends Participante {

    private Selecao selecao = null;

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

    public Treinador(Integer id, String nacionalidade, Date data_nasc, String nome, String foto) {
        super(id, nacionalidade, data_nasc, nome, foto);

    }

}
