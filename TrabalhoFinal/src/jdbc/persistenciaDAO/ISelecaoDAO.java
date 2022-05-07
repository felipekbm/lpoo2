package jdbc.persistenciaDAO;

import models.Jogador;
import models.Selecao;
import models.Treinador;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public interface ISelecaoDAO extends IDAO<Selecao>  {
    public boolean atualizar(Selecao vo);

    public java.util.List<Selecao> buscaPorNome(String nome);
    public Jogador buscaPorJogador(Jogador vo);
    public Treinador buscaPorTreinador(Treinador vo);
    
}
