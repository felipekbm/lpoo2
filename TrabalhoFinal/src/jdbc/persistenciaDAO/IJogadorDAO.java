/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.persistenciaDAO;

import models.Jogador;

/**
 *
 * @author User
 */
public interface IJogadorDAO extends IDAO<Jogador> {
      public java.util.List<Jogador> buscaPorNome(String nome);
      
      public Jogador buscaPosicao(Jogador vo);
      
       public Jogador buscaSelecao(Jogador vo);
}
