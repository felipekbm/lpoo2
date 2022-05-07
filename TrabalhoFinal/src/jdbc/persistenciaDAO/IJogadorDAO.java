package jdbc.persistenciaDAO;

import java.util.List;
import models.Jogador;
import models.Selecao;

/**
 *
 * @author Felipe Miyazaki - Karine Antoniacomi - Ricardo Filho
 */

public interface IJogadorDAO extends IDAO<Jogador> {

    public java.util.List<Jogador> buscaPorNome(String nome);

    public Jogador buscaPosicao(Jogador vo);

    public Jogador buscaSelecao(Jogador vo);

    public List<Jogador> listaTodosPorSelecao(Selecao vo);
}
