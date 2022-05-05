/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistenciaDAO;

import models.Selecao;
import models.Treinador;

/**
 *
 * @author User
 */
public interface ITreinadorDAO extends IDAO<Treinador>{
        public boolean atualiza(Treinador vo);
        
        public Treinador buscaSelecao(Treinador vo);
        
        public Treinador buscaPorSelecao(Selecao vo);

}
