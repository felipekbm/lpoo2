/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistenciaDAO;

import models.Treinador;

/**
 *
 * @author User
 */
public interface ITreinadorDAO extends IDAO{
        public boolean atualiza(Treinador vo);
        
        public Treinador buscaSelecao(Treinador vo);

}
