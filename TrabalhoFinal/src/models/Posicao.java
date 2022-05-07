package models;

/**
 *
 * @author User
 */

public class Posicao {
    private Integer id;
    private String nome;
    
       public Posicao(Integer id, String nome){
           this.id = id;
           this.nome = nome;
       }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
