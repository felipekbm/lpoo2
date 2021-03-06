package models;

import java.sql.Date;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public class Jogador extends Participante {

    private Posicao posicao = null;
    private Integer camisa;
    private Selecao selecao = null;

    public Jogador(Integer id, String nacionalidade, Date data_nasc, String nome, String foto, Integer camisa) {
        super(id, nacionalidade, data_nasc, nome, foto);

        setCamisa(camisa);

    }

    public Selecao getSelecao() {
        return selecao;
    }

    public void setSelecao(Selecao selecao) {
        this.selecao = selecao;
    }

    public Integer getCamisa() {
        return camisa;
    }

    public void setCamisa(Integer camisa) {
        this.camisa = camisa;
    }

    /**
     * @return the posicao
     */
    public Posicao getPosicao() {
        return posicao;
    }

    /**
     * @param posicao the posicao to set
     */
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }
}
