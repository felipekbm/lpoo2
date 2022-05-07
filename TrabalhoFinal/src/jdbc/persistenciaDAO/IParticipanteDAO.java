package jdbc.persistenciaDAO;

import models.Participante;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public interface IParticipanteDAO extends IDAO<Participante> {

    public boolean atualizar(Participante vo);

    public java.util.List<Participante> buscaPorNome(String nome);

}
