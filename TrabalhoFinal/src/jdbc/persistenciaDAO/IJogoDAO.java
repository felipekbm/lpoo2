/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistenciaDAO;

import models.Jogo;
import models.Juiz;
import models.Selecao;

/**
 *
 * @author User
 */
public interface IJogoDAO extends IDAO<Jogo> {

    public boolean atualiza(Jogo vo);

    public Jogo buscaJuiz(Jogo vo);

    public Jogo InsereJuiz(Jogo vo, Juiz j);

    public Jogo DeletaJuiz(Jogo vo, int j_id);

    public Selecao listaJogosPorSelecao(Selecao vo);
}
