/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jdbc.persistenciaDAO;

import models.Participante;

/**
 *
 * @author User
 */
public interface IParticipanteDAO extends IDAO<Participante> {

    public boolean atualizar(Participante vo);

    public java.util.List<Participante> buscaPorNome(String nome);

}
