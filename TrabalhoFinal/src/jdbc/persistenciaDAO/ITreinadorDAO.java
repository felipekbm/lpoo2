package jdbc.persistenciaDAO;

import models.Selecao;
import models.Treinador;

/**
 *
 * @author Ricardo Filho - Karine Antoniacomi
 */

public interface ITreinadorDAO extends IDAO<Treinador>{
               
        public Treinador buscaSelecao(Treinador vo);
        
        public Treinador buscaPorSelecao(Selecao vo);

}
