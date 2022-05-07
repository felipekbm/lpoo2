package jdbc.persistenciaDAO;

import models.Selecao;
import models.Treinador;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public interface ITreinadorDAO extends IDAO<Treinador>{
               
        public Treinador buscaSelecao(Treinador vo);
        
        public Treinador buscaPorSelecao(Selecao vo);

}
