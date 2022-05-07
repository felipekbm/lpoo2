package jdbc.persistenciaDAO;

import models.Jogador;
import models.Posicao;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public interface IPosicaoDAO extends IDAO<Posicao> {
    
       public Jogador buscaPorJogador(Jogador vo);
    
}
