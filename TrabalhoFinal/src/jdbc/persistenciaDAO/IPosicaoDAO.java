package jdbc.persistenciaDAO;

import models.Jogador;
import models.Posicao;

/**
 *
 * @author Ricardo Filho
 */

public interface IPosicaoDAO extends IDAO<Posicao> {
    
       public Jogador buscaPorJogador(Jogador vo);
    
}
