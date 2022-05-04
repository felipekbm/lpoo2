/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistenciaDAO;

import models.Jogador;
import models.Selecao;
import models.Treinador;

/**
 *
 * @author User
 */
public interface ISelecaoDAO extends IDAO<Selecao>  {
    public boolean atualizar(Selecao vo);

    public java.util.List<Selecao> buscaPorNome(String nome);
    public Jogador buscaPorJogador(Jogador vo);
    public Treinador buscaPorTreinador(Treinador vo);
    
}
