package jdbc.persistenciaDAO;

import java.util.List;
import models.Jogo;
import models.Juiz;
import models.Selecao;

/**
 *
 * @author Ricardo Filho 
 */

public interface IJogoDAO extends IDAO<Jogo> {

    public boolean atualiza(Jogo vo);

    public Jogo buscaJuiz(Jogo vo);

    public Jogo InsereJuiz(Jogo vo);

    public boolean deletaJuiz(Jogo vo);

    public Selecao listaJogosPorSelecao(Selecao vo);
}
