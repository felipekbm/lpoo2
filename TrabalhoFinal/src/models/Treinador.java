package models;

import java.sql.Date;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
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
