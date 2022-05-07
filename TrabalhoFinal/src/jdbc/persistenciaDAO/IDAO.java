package jdbc.persistenciaDAO;

/**
 *
 * @author Ricardo Filho
 */

public interface IDAO<T> {

    public boolean novo(T vo);

    

    public boolean excluir(int id);

    public T busca(int id);

    public java.util.List<T> listaTodos();
}
